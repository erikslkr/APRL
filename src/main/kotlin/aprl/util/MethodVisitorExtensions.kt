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

private var leftType: Class<*>? = null
private var rightType: Class<*>? = null

private fun MethodVisitor.visitExpression(expressionTree: ExpressionTree, localVariables: LocalVariables) {
    // TODO: call visitExpressionNode from somewhere
    //      (also, visitExpressionNode might need rewriting, because just traversing post-order obviously doesn't work)
    visitDisjunction(expressionTree, localVariables)
}

private fun MethodVisitor.visitLogicalConnective(
    expressionTree: ExpressionTree,
    operatorClass: Class<out AprlOperator<*>>,
    headOperation: (labelLoad0: Label, labelLoad1: Label, labelContinue: Label) -> Unit,
    labelsOperation: (labelLoad0: Label, labelLoad1: Label, labelContinue: Label) -> Unit,
    visitSingle: (operand: ExpressionTree) -> Unit,
    localVariables: LocalVariables
) {
    val operands = mutableListOf<ExpressionTree>()
    // flatten operation tree into list
    var currentNode = expressionTree
    while (currentNode.content?.javaClass == operatorClass) {
        operands.add(expressionTree.firstChild as ExpressionTree)
        currentNode = currentNode.secondChild as ExpressionTree
        // TODO: adding firstChild to operands is not enough, secondNode might be a connector (logical connective operator like && or ||) as well
    }
    operands.add(currentNode)
    if (operands.size > 1) {
        val labelLoad0 = Label() // label to load 0 if expression evaluates to zero/false
        val labelLoad1 = Label() // label to load 1 if expression evaluates to one/true
        val labelContinue = Label() // label below to allow skipping labelLoad0 or labelLoad1
        for (node in operands.dropLast(1)) {
            visitExpression(node, localVariables)
            // TODO: check if implicit conversion to boolean is necessary (check leftType)
            visitImplicitConversion(aprl.lang.Boolean::class.java, node.positionRange)
            headOperation(labelLoad0, labelLoad1, labelContinue)
        }
        visitExpression(operands.last(), localVariables)
        labelsOperation(labelLoad0, labelLoad1, labelContinue)
        visitLabel(labelContinue)
    } else {
        visitSingle(operands.single())
    }
}

private fun MethodVisitor.visitDisjunction(expressionTree: ExpressionTree, localVariables: LocalVariables) {
    visitLogicalConnective(
        expressionTree,
        AprlDisjunctionOperator::class.java,
        headOperation = { _, labelLoad1, _ ->
            visitJumpInsn(IFNE, labelLoad1) // whole expression is one if any disjunct is non-zero
        },
        labelsOperation = { labelLoad0, labelLoad1, labelContinue ->
            visitJumpInsn(IFEQ, labelLoad0) // whole expression is zero if all disjuncts, including the last one, are zero
            visitLabel(labelLoad1)
            visitInsn(ICONST_1)
            visitJumpInsn(GOTO, labelContinue) // 1 has been loaded, skip loading 0
            visitLabel(labelLoad0)
            visitInsn(ICONST_0)
        },
        visitSingle = { operand ->
            visitConjunction(operand, localVariables)
        },
        localVariables)
}

private fun MethodVisitor.visitConjunction(expressionTree: ExpressionTree, localVariables: LocalVariables) {
    visitLogicalConnective(
        expressionTree,
        AprlConjunctionOperator::class.java,
        headOperation = { labelLoad0, _, _ ->
            visitJumpInsn(IFEQ, labelLoad0) // whole expression is zero if any conjunct is zero
        },
        labelsOperation = { labelLoad0, labelLoad1, labelContinue ->
            visitJumpInsn(IFEQ, labelLoad1) // whole expression is zero if all conjuncts, including the last one, are zero
            visitLabel(labelLoad0)
            visitInsn(ICONST_0)
            visitJumpInsn(GOTO, labelContinue) // 1 has been loaded, skip loading 0
            visitLabel(labelLoad1)
            visitInsn(ICONST_1)
        },
        visitSingle = { operand ->
            
            visitExpression(operand, localVariables)
            // TODO: fix infinite recursion
            //   (we can't simply go to visitComparison, because conjuncts.single() could be parenthesized and contain conjunctions on its own, but we can't visitExpression every time either)
            //   A check is necessary to somehow check whether conjuncts.single() needs to be treated as an expression vs a comparison
        },
        localVariables
    )
}

private fun MethodVisitor.visitComparison(expressionTree: ExpressionTree, localVariables: LocalVariables) {
    // TODO: call visitExpressionNode from here (traverse expressionTree)
}

private fun MethodVisitor.visitExpressionNode(node: AprlNode<*>, localVariables: LocalVariables) {
    when (node) {
        is AprlOverloadableOperator -> {
            // TODO: check for #Verbatim annotation, don't replace operators if annotation is present
            var functionExists = false
            for (method in leftType!!.methods.filter { it.name == node.functionName }) {
                // find function that matches given rhs type and is annotated with #OperatorFunction
                if (method.parameterTypes[0] == rightType && OperatorFunction() in method.annotations) {
                    val returnType = Type.getType(method.returnType).descriptor
                    visitMethodInsn(INVOKEVIRTUAL, leftType!!.name.replace(".", "/"), node.functionName, "(${Type.getType(rightType).descriptor})$returnType", false)
                    leftType = method.returnType
                    functionExists = true
                    break
                }
            }
            if (!functionExists && rightType != null) {
                // no operator function found
                ERROR("Operation '${node.operatorSymbol}' is not defined on types '${leftType!!.simpleName}' and '${rightType!!.simpleName}'", node.context.positionRange)
            }
            // rightType must be freed for next expression
            rightType = null
        }
        is AprlLiteral<*> -> {
            visitWrapperInitialization(node.value, node.internalType)
        }
        is AprlIdentifier -> {
            val localVariable = localVariables["$node"]
            if (localVariable != null) {
                if (!localVariable.initialized) {
                    ERROR("Local variable '$node' might not have been initialized", node.context.positionRange)
                }
                visitVarInsn(ALOAD, localVariable.index)
                if (leftType == null) {
                    leftType = localVariable.type
                } else if (rightType == null) {
                    rightType = localVariable.type
                }
            } else {
                ERROR("Unresolved reference '$node'", node.context.positionRange)
            }
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
    if (leftType == null) {
        leftType = type
    } else if (rightType == null) {
        rightType = type
    }
}

private fun MethodVisitor.visitImplicitConversion(expectedType: Class<*>, expressionPosition: PositionRange) {
    val conversionFunctionName = "to${expectedType.simpleName}"
    var bestConversionFunctionMatch: Method? = null
    for (method in leftType!!.methods.filter { it.name == conversionFunctionName }) {
        // find conversion function with no parameters and matching return type
        if (method.parameters.isEmpty() && expectedType.isAssignableFrom(method.returnType)) {
            if (bestConversionFunctionMatch?.returnType?.isAssignableFrom(method.returnType) != false) {
                // current method is better if best match is null or current return type is more precise
                bestConversionFunctionMatch = method
            }
        }
    }
    if (bestConversionFunctionMatch == null) {
        ERROR("Type '${leftType!!.simpleName}' cannot be implicitly converted to '${expectedType.simpleName}' (No function '${leftType!!.simpleName}.${conversionFunctionName}() -> ${expectedType.simpleName}')", expressionPosition)
    } else {
        visitMethodInsn(INVOKEVIRTUAL, Type.getType(leftType!!).internalName, conversionFunctionName, "()${Type.getType(bestConversionFunctionMatch.returnType).descriptor}", false)
        WARNING("Implicit conversion from '${leftType!!.simpleName}' to '${expectedType.simpleName}'", expressionPosition)
    }
}

// +
//   int
//   +
//      *
//         str
//         int
//      str

fun MethodVisitor.visitAprlVariableDeclaration(declaration: AprlVariableDeclaration, localVariables: LocalVariables) {
    var variableType = declaration.typeAnnotation?.javaType
    val expressionTree = declaration.expression?.toTree()
    if (expressionTree != null) {
        val beforeOptimization = expressionTree.deepCopy()
        expressionTree.optimize()
        expressionTree.print()
        if (expressionTree.childCount != beforeOptimization.childCount && "$expressionTree" != "$beforeOptimization") {
            WARNING("Expression '$beforeOptimization' can be evaluated to '$expressionTree'", declaration.expression!!.context.positionRange)
        }
        expressionTree.traverse(BinaryTree.TraversalOrder.POSTORDER) {
            visitExpressionNode(it, localVariables)
        }
        println()
        // visitExpression(expressionTree, localVariables)
    } else {
        visitWrapperInitialization(variableType?.defaultValue, variableType!!)
    }
    variableType = variableType ?: leftType!!
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
    if (!variableType.isAssignableFrom(leftType ?: variableType)) {
        // no direct assignment possible => conversion required
        visitImplicitConversion(variableType, declaration.expression!!.context.positionRange)
    }
    visitVarInsn(ASTORE, index)
    leftType = rightType
    rightType = null
}

fun MethodVisitor.visitAprlVariableAssignment(assignment: AprlVariableAssignment, localVariables: LocalVariables) {
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
        expressionTree.traverse(BinaryTree.TraversalOrder.POSTORDER) {
            visitExpressionNode(it, localVariables)
        }
        if (leftType?.let { localVariable.type.isAssignableFrom(it) } != true) {
            visitImplicitConversion(localVariable.type, assignment.expression!!.context.positionRange)
        }
        visitVarInsn(ASTORE, localVariable.index)
        leftType = rightType
        rightType = null
    }
}
