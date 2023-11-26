package aprl.util

import aprl.compiler.ERROR
import aprl.compiler.PositionRange
import aprl.compiler.WARNING
import aprl.ir.*
import aprl.ir.operators.*
import aprl.lang.OperatorFunction
import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import java.lang.reflect.Method
import java.util.*

val localVariables = emptyLocalVariables()

private val types = ArrayDeque<Class<*>>()

private fun MethodVisitor.visitExpression(expressionTree: ExpressionTree) {
    visitDisjunction(expressionTree)
}

private fun MethodVisitor.visitLogicalConnective(
    expressionTree: ExpressionTree,
    operatorClass: Class<out AprlOperator<*>>,
    inferiorExpressionHandler: (ExpressionTree) -> Unit,
    logicHandler: (labelLoad0: Label, labelLoad1: Label, labelContinue: Label) -> Unit,
    labelHandler: (labelLoad0: Label, labelLoad1: Label, labelContinue: Label) -> Unit
) {
    val booleanType = aprl.lang.Boolean::class.java
    val booleanInternalName = Type.getType(booleanType).internalName
    
    fun handleOperand(operand: ExpressionTree) {
        inferiorExpressionHandler(operand)
        // implicit conversion to boolean if necessary
        if (!booleanType.isAssignableFrom(types.last)) {
            visitImplicitConversion(booleanType, operand)
        }
        // read primitive value from boolean wrapper
        visitMethodInsn(INVOKEVIRTUAL, booleanInternalName, "component1", "()Z", false)
    }
    
    val operands = expressionTree.flatSplit { it.javaClass == operatorClass }
    if (operands.size > 1) {
        visitTypeInsn(NEW, booleanInternalName)
        visitInsn(DUP)
        val labelLoad0 = Label() // label to load 0 if expression evaluates to zero/false
        val labelLoad1 = Label() // label to load 1 if expression evaluates to one/true
        val labelContinue = Label() // label below to allow skipping labelLoad0 or labelLoad1
        for (operand in operands.dropLast(1)) {
            handleOperand(operand)
            logicHandler(labelLoad0, labelLoad1, labelContinue)
        }
        handleOperand(operands.last())
        labelHandler(labelLoad0, labelLoad1, labelContinue)
        visitLabel(labelContinue)
        // convert primitive boolean back to wrapper type
        visitMethodInsn(INVOKESPECIAL, booleanInternalName, "<init>", "(Z)V", false)
        types.add(booleanType)
    } else {
        inferiorExpressionHandler(operands.single())
    }
}

private fun MethodVisitor.visitDisjunction(expressionTree: ExpressionTree) {
    visitLogicalConnective(
        expressionTree,
        AprlDisjunctionOperator::class.java,
        inferiorExpressionHandler = { operand ->
            visitConjunction(operand)
        },
        logicHandler = { _, labelLoad1, _ ->
            visitJumpInsn(IFNE, labelLoad1) // whole expression is one if any disjunct is non-zero
        },
        labelHandler = { labelLoad0, labelLoad1, labelContinue ->
            visitJumpInsn(IFEQ, labelLoad0) // whole expression is zero if all disjuncts, including the last one, are zero
            visitLabel(labelLoad1)
            visitInsn(ICONST_1)
            visitJumpInsn(GOTO, labelContinue) // 1 has been loaded, skip loading 0
            visitLabel(labelLoad0)
            visitInsn(ICONST_0)
        }
    )
}

private fun MethodVisitor.visitConjunction(expressionTree: ExpressionTree) {
    visitLogicalConnective(
        expressionTree,
        AprlConjunctionOperator::class.java,
        inferiorExpressionHandler = { operand ->
            if (operand.content is AprlDisjunctionOperator) {
                visitDisjunction(operand)
            } else {
                visitComparison(operand)
            }
        },
        logicHandler = { labelLoad0, _, _ ->
            visitJumpInsn(IFEQ, labelLoad0) // whole expression is zero if any conjunct is zero
        },
        labelHandler = { labelLoad0, labelLoad1, labelContinue ->
            visitJumpInsn(IFNE, labelLoad1) // whole expression is one if all conjuncts, including the last one, are non-zero
            visitLabel(labelLoad0)
            visitInsn(ICONST_0)
            visitJumpInsn(GOTO, labelContinue) // 1 has been loaded, skip loading 0
            visitLabel(labelLoad1)
            visitInsn(ICONST_1)
        }
    )
}

private fun MethodVisitor.visitComparison(expressionTree: ExpressionTree) {
    
    val booleanInternalName = Type.getType(aprl.lang.Boolean::class.java).internalName
    val comparands = expressionTree.flatSplitIncludingDelimiters { it is AprlComparisonOperator }
    
    fun handleComparand(comparand: ExpressionTree) {
        when (comparand.content) {
            is AprlDisjunctionOperator -> {
                visitDisjunction(comparand)
            }
            is AprlConjunctionOperator -> {
                visitConjunction(comparand)
            }
            else -> {
                visitBitwiseExpression(comparand)
            }
        }
    }
    
    if (comparands.size > 1) {
        visitTypeInsn(NEW, booleanInternalName)
        visitInsn(DUP)
        handleComparand(comparands.first().second)
    } else {
        handleComparand(comparands.first().second)
        return
    }
    
    var previousComparand: ExpressionTree? = null
    val labelLoad0 = Label()
    val labelLoad1 = Label()
    val labelContinue = Label()
    
    fun performComparison(
        comparator: AprlNode<*>?,
        comparand: ExpressionTree,
        comparisonOperation: (compareToInvoker: () -> Unit) -> Unit
    ) {
        if (comparator !is AprlComparisonOperator) {
            throw InternalError("Compiler assumed comparison operator in comparison expression, but found '$comparator' (${comparator?.javaClass})")
        }
        if (previousComparand != null) {
            handleComparand(previousComparand!!)
        }
        handleComparand(comparand)
        val lhsType = types.previousToLast
        val rhsType = types.last()
        var bestComparatorFunctionMatch: Method? = null
        for (method in lhsType.methods.filter { it.name == "compareTo" }) {
            // find function that returns Int, matches given rhs type and is annotated with #OperatorFunction
            if (Int::class.java.isAssignableFrom(method.returnType) && method.parameters.size == 1 && method.parameterTypes[0].isAssignableFrom(rhsType) && OperatorFunction() in method.annotations) {
                if (bestComparatorFunctionMatch?.parameterTypes?.get(0)?.isAssignableFrom(method.parameterTypes[0]) != false) {
                    bestComparatorFunctionMatch = method
                }
            }
        }
        if (bestComparatorFunctionMatch == null) {
            ERROR("Operation '${comparator.operatorSymbol}' is not defined on types '${lhsType.simpleName}' and '${rhsType.simpleName}'", comparator.context.positionRange)
        } else {
            val compareToInvoker = {
                val functionSignature = "(${Type.getType(rhsType).descriptor})${Type.getType(bestComparatorFunctionMatch.returnType).descriptor}"
                visitMethodInsn(INVOKEVIRTUAL, Type.getType(lhsType).internalName, "compareTo", functionSignature, lhsType.isInterface)
                visitInsn(ICONST_0)
            }
            comparisonOperation(compareToInvoker)
        }
    }
    
    for ((comparator, comparand) in comparands.drop(1).dropLast(1)) {
        performComparison(comparator, comparand) { compareToInvoker ->
            when (comparator) {
                is AprlComparisonOperator.AprlIdenticalOperator -> {
                    visitJumpInsn(IF_ACMPNE, labelLoad0)
                }
                is AprlComparisonOperator.AprlNotIdenticalOperator -> {
                    visitJumpInsn(IF_ACMPEQ, labelLoad0)
                }
                is AprlComparisonOperator.AprlEqualOperator -> {
                    compareToInvoker()
                    visitJumpInsn(IF_ICMPNE, labelLoad0)
                }
                is AprlComparisonOperator.AprlNotEqualOperator -> {
                    compareToInvoker()
                    visitJumpInsn(IF_ICMPEQ, labelLoad0)
                }
                is AprlComparisonOperator.AprlLessThanOperator -> {
                    compareToInvoker()
                    visitJumpInsn(IF_ICMPGE, labelLoad0)
                }
                is AprlComparisonOperator.AprlLessEqualOperator -> {
                    compareToInvoker()
                    visitJumpInsn(IF_ICMPGT, labelLoad0)
                }
                is AprlComparisonOperator.AprlGreaterThanOperator -> {
                    compareToInvoker()
                    visitJumpInsn(IF_ICMPLE, labelLoad0)
                }
                is AprlComparisonOperator.AprlGreaterEqualOperator -> {
                    compareToInvoker()
                    visitJumpInsn(IF_ICMPLT, labelLoad0)
                }
            }
        }
        previousComparand = comparand
    }
    val (comparator, comparand) = comparands.last()
    // logic for last comparison
    performComparison(comparator, comparand) { compareToInvoker ->
        when (comparator) {
            is AprlComparisonOperator.AprlIdenticalOperator -> {
                visitJumpInsn(IF_ACMPEQ, labelLoad1)
            }
            is AprlComparisonOperator.AprlNotIdenticalOperator -> {
                visitJumpInsn(IF_ACMPNE, labelLoad1)
            }
            is AprlComparisonOperator.AprlEqualOperator -> {
                compareToInvoker()
                visitJumpInsn(IF_ICMPEQ, labelLoad1)
            }
            is AprlComparisonOperator.AprlNotEqualOperator -> {
                compareToInvoker()
                visitJumpInsn(IF_ICMPNE, labelLoad1)
            }
            is AprlComparisonOperator.AprlLessThanOperator -> {
                compareToInvoker()
                visitJumpInsn(IF_ICMPLT, labelLoad1)
            }
            is AprlComparisonOperator.AprlLessEqualOperator -> {
                compareToInvoker()
                visitJumpInsn(IF_ICMPLE, labelLoad1)
            }
            is AprlComparisonOperator.AprlGreaterThanOperator -> {
                compareToInvoker()
                visitJumpInsn(IF_ICMPGT, labelLoad1)
            }
            is AprlComparisonOperator.AprlGreaterEqualOperator -> {
                compareToInvoker()
                visitJumpInsn(IF_ICMPGE, labelLoad1)
            }
        }
    }
    visitLabel(labelLoad0)
    visitInsn(ICONST_0)
    visitJumpInsn(GOTO, labelContinue)
    visitLabel(labelLoad1)
    visitInsn(ICONST_1)
    visitLabel(labelContinue)
    // convert primitive boolean back to wrapper type
    visitMethodInsn(INVOKESPECIAL, booleanInternalName, "<init>", "(Z)V", false)
    types.add(aprl.lang.Boolean::class.java)
}

private fun MethodVisitor.visitOverloadableExpression(
    expression: ExpressionTree,
    operatorClass: Class<out AprlOverloadableOperator<*>>,
    inferiorExpressionHandler: (ExpressionTree) -> Unit,
    verbatim: Boolean
) {
    val operator = (expression.content as? AprlOverloadableOperator) ?: return inferiorExpressionHandler(expression)
    if (!operatorClass.isAssignableFrom(operator.javaClass)) {
        return inferiorExpressionHandler(expression)
    }
    if (expression.firstChild == null || expression.secondChild == null) {
        (expression.firstChild as? ExpressionTree)?.also { visitOverloadableExpression(it, operatorClass, inferiorExpressionHandler, verbatim) }
        (expression.secondChild as? ExpressionTree)?.also { visitOverloadableExpression(it, operatorClass, inferiorExpressionHandler, verbatim) }
    } else {
        visitOverloadableExpression(expression.firstChild as ExpressionTree, operatorClass, inferiorExpressionHandler, verbatim)
        visitOverloadableExpression(expression.secondChild as ExpressionTree, operatorClass, inferiorExpressionHandler, verbatim)
        val leftType = types.previousToLast ?: throw InternalError("The compiler was not able to type-check one or multiple expressions")
        val rightType = types.lastButNotFirstOrNull() ?: Any::class.java.also { types.add(it) }
        if (verbatim) {
            // TODO: Verbatim operation
        } else {
            var bestOperatorFunctionMatch: Method? = null
            for (method in leftType.methods.filter { it.name == operator.functionName }) {
                // find function that matches given rhs type and is annotated with #OperatorFunction
                if (method.parameters.size == 1 && method.parameterTypes[0].isAssignableFrom(rightType) && OperatorFunction() in method.annotations) {
                    if (bestOperatorFunctionMatch?.parameterTypes?.get(0)?.isAssignableFrom(method.parameterTypes[0]) != false) {
                        bestOperatorFunctionMatch = method
                    }
                }
            }
            if (bestOperatorFunctionMatch != null) {
                val returnType = Type.getType(bestOperatorFunctionMatch.returnType).descriptor
                visitMethodInsn(INVOKEVIRTUAL, types.previousToLast.name.replace(".", "/"), operator.functionName, "(${Type.getType(types.lastButNotFirst).descriptor})$returnType", false)
                // remove operand types
                types.pollLast()
                types.pollLast()
                // add return type
                types.add(bestOperatorFunctionMatch.returnType)
            } else {
                // no operator function found
                ERROR("Operation '${operator.operatorSymbol}' is not defined on types '${types.previousToLast.simpleName}' and '${types.lastButNotFirst.simpleName}'", operator.context.positionRange)
            }
        }
    }
}

private fun MethodVisitor.visitBitwiseExpression(expression: ExpressionTree) {
    visitOverloadableExpression(
        expression = expression,
        operatorClass = AprlBitwiseOperator::class.java,
        inferiorExpressionHandler = { operand ->
            when (operand.content) {
                is AprlDisjunctionOperator -> {
                    visitDisjunction(operand)
                }
                is AprlConjunctionOperator -> {
                    visitConjunction(operand)
                }
                is AprlComparisonOperator -> {
                    visitComparison(operand)
                }
                else -> {
                    visitAdditiveExpression(operand)
                }
            }
        },
        verbatim = false
    )
}

private fun MethodVisitor.visitAdditiveExpression(expression: ExpressionTree) {
    visitOverloadableExpression(
        expression = expression,
        operatorClass = AprlAdditiveOperator::class.java,
        inferiorExpressionHandler = { operand ->
            when (operand.content) {
                is AprlDisjunctionOperator -> {
                    visitDisjunction(operand)
                }
                is AprlConjunctionOperator -> {
                    visitConjunction(operand)
                }
                is AprlComparisonOperator -> {
                    visitComparison(operand)
                }
                is AprlBitwiseOperator -> {
                    visitBitwiseExpression(operand)
                }
                else -> {
                    visitMultiplicativeExpression(operand)
                }
            }
        },
        verbatim = false
    )
}

private fun MethodVisitor.visitMultiplicativeExpression(expression: ExpressionTree) {
    visitOverloadableExpression(
        expression = expression,
        operatorClass = AprlMultiplicativeOperator::class.java,
        inferiorExpressionHandler = { operand ->
            when (operand.content) {
                is AprlDisjunctionOperator -> {
                    visitDisjunction(operand)
                }
                is AprlConjunctionOperator -> {
                    visitConjunction(operand)
                }
                is AprlComparisonOperator -> {
                    visitComparison(operand)
                }
                is AprlBitwiseOperator -> {
                    visitBitwiseExpression(operand)
                }
                is AprlAdditiveOperator -> {
                    visitAdditiveExpression(operand)
                }
                else -> {
                    visitExponentialExpression(operand)
                }
            }
        },
        verbatim = false
    )
}

private fun MethodVisitor.visitExponentialExpression(expression: ExpressionTree) {
    visitOverloadableExpression(
        expression = expression,
        operatorClass = AprlExponentialOperator::class.java,
        inferiorExpressionHandler = { operand ->
            when (operand.content) {
                is AprlDisjunctionOperator -> {
                    visitDisjunction(operand)
                }
                is AprlConjunctionOperator -> {
                    visitConjunction(operand)
                }
                is AprlComparisonOperator -> {
                    visitComparison(operand)
                }
                is AprlBitwiseOperator -> {
                    visitBitwiseExpression(operand)
                }
                is AprlAdditiveOperator -> {
                    visitAdditiveExpression(operand)
                }
                is AprlMultiplicativeOperator -> {
                    visitMultiplicativeExpression(operand)
                }
                else -> {
                    visitAtomicExpression(operand)
                }
            }
        },
        verbatim = false
    )
}

private fun MethodVisitor.visitAtomicExpression(expression: ExpressionTree) {
    when (expression.content) {
        is AprlDisjunctionOperator -> {
            visitDisjunction(expression)
        }
        is AprlConjunctionOperator -> {
            visitConjunction(expression)
        }
        is AprlComparisonOperator -> {
            visitComparison(expression)
        }
        is AprlBitwiseOperator -> {
            visitBitwiseExpression(expression)
        }
        is AprlAdditiveOperator -> {
            visitAdditiveExpression(expression)
        }
        is AprlMultiplicativeOperator -> {
            visitMultiplicativeExpression(expression)
        }
        is AprlExponentialOperator -> {
            visitExponentialExpression(expression)
        }
        is AprlLiteral<*> -> {
            with (expression.content as AprlLiteral<*>) {
                visitWrapperInitialization(value, internalType)
            }
        }
        is AprlIdentifier -> {
            (expression.content as AprlIdentifier).also { identifier ->
                val localVariable = localVariables["$identifier"]
                if (localVariable != null) {
                    if (!localVariable.initialized) {
                        ERROR("Local variable '$identifier' might not have been initialized", identifier.context.positionRange)
                    }
                    visitVarInsn(ALOAD, localVariable.index)
                    types.add(localVariable.type)
                } else {
                    ERROR("Unresolved reference '$identifier'", identifier.context.positionRange)
                }
            }
        }
        else -> {
            throw InternalError("Compiler encountered unexpected token: '$expression'")
        }
    }
}

fun <T: Any> MethodVisitor.visitWrapperInitialization(value: T?, type: Class<out T>) {
    // Name of the wrapper class, e.g. `aprl/lang/Int`
    val internalName = Type.getType(type).internalName
    visitTypeInsn(NEW, internalName)
    visitInsn(DUP)
    if (value != null) {
        visitLdcInsn(value)
    } else {
        visitInsn(ACONST_NULL)
    }
    val representedType = Type.getType(value?.javaClass ?: Any::class.java).descriptor
    val primitiveType = when (representedType) {
        "Ljava/lang/Boolean;" -> "Z"
        "Ljava/lang/Long;" -> "J"
        "Ljava/lang/Double;" -> "D"
        "Ljava/lang/Character;" -> "C"
        else -> null
    }
    visitMethodInsn(INVOKESPECIAL, internalName, "<init>", "(${primitiveType ?: representedType})V", false)
    types.add(type)
}

private fun MethodVisitor.visitImplicitConversion(expectedType: Class<*>, expressionString: String, expressionPosition: PositionRange) {
    val conversionFunctionName = "to${expectedType.simpleName}"
    var bestConversionFunctionMatch: Method? = null
    for (method in types.last.methods.filter { it.name == conversionFunctionName }) {
        // find conversion function with no parameters and matching return type
        if (method.parameters.isEmpty() && expectedType.isAssignableFrom(method.returnType)) {
            if (bestConversionFunctionMatch?.returnType?.isAssignableFrom(method.returnType) != false) {
                // current method is better if best match is null or current return type is more precise
                bestConversionFunctionMatch = method
            }
        }
    }
    if (bestConversionFunctionMatch == null) {
        ERROR("Expression '$expressionString' (of type '${types.last.simpleName}') cannot be implicitly converted to '${expectedType.simpleName}' (No function '${types.last.simpleName}.$conversionFunctionName() -> ${expectedType.simpleName}')", expressionPosition)
    } else {
        visitMethodInsn(INVOKEVIRTUAL, Type.getType(types.last).internalName, conversionFunctionName, "()${Type.getType(bestConversionFunctionMatch.returnType).descriptor}", false)
        types.pollLast()
        types.add(bestConversionFunctionMatch.returnType)
        WARNING("Implicit conversion from '${types.last.simpleName}' to '${bestConversionFunctionMatch.returnType.simpleName}'", expressionPosition)
    }
}

private fun MethodVisitor.visitImplicitConversion(expectedType: Class<*>, expression: ExpressionTree) {
    visitImplicitConversion(expectedType, expression.toString(), expression.positionRange)
}

private fun MethodVisitor.visitImplicitConversion(expectedType: Class<*>, expression: AprlNode<*>) {
    visitImplicitConversion(expectedType, expression.toString(), expression.context.positionRange)
}

fun MethodVisitor.visitAprlVariableDeclaration(declaration: AprlVariableDeclaration) {
    var variableType = declaration.typeAnnotation?.javaType
    val expressionTree = declaration.expression?.toTree()
    if (expressionTree != null) {
        val beforeOptimization = expressionTree.deepCopy()
        expressionTree.optimize()
        if (expressionTree.childCount != beforeOptimization.childCount && "$expressionTree" != "$beforeOptimization") {
            WARNING("Expression '$beforeOptimization' can be evaluated to '$expressionTree'", declaration.expression!!.context.positionRange)
        }
        visitExpression(expressionTree)
    } else {
        visitWrapperInitialization(variableType?.defaultValue, variableType!!)
    }
    variableType = variableType ?: types.lastOrNull() ?: return
    val index: Int
    if (declaration.identifier!! in localVariables.keys) {
        index = localVariables[declaration.identifier]!!.index
        val originalDeclaration = localVariables[declaration.identifier]!!.originalDeclaration
        val errorMessage = run {
            val originalSignature = "${originalDeclaration.variableClassifier} ${originalDeclaration.identifier}: ${localVariables[declaration.identifier]!!.type.simpleName}"
            val redeclaredSignature = "${declaration.variableClassifier} ${declaration.identifier}: ${variableType.simpleName}"
            "Conflicting declarations: $originalSignature, $redeclaredSignature"
        }
        ERROR(errorMessage, declaration.context.simpleIdentifier().positionRange)
        ERROR(errorMessage, originalDeclaration.context.simpleIdentifier().positionRange)
    } else {
        index = localVariables.values.map { it.index }.nextOrMissing()
        val isMutable = declaration.variableClassifier != VariableClassifier.VAL
        localVariables[declaration.identifier!!] = LocalVariable(index, isMutable, variableType, expressionTree != null, declaration)
    }
    if (!variableType.isAssignableFrom(types.lastOrNull() ?: variableType)) {
        // no direct assignment possible => conversion required
        visitImplicitConversion(variableType, declaration.expression!!)
    }
    visitVarInsn(ASTORE, index)
}

fun MethodVisitor.visitAprlVariableAssignment(assignment: AprlVariableAssignment) {
    val expressionTree = assignment.expression!!.toTree()
    expressionTree.optimize()
    if (assignment.identifier!! !in localVariables.keys) {
        ERROR("Unresolved reference '${assignment.identifier}'", assignment.context.simpleIdentifier().positionRange)
    } else {
        val localVariable = localVariables[assignment.identifier]!!
        if (!localVariable.isMutable) {
            // Variable cannot be reassigned
            ERROR("'${assignment.identifier}' is immutable", assignment.context.simpleIdentifier().positionRange)
        }
        visitExpression(expressionTree)
        if (types.firstOrNull()?.let { localVariable.type.isAssignableFrom(it) } != true) {
            visitImplicitConversion(localVariable.type, assignment.expression!!)
        }
        visitVarInsn(ASTORE, localVariable.index)
    }
}
