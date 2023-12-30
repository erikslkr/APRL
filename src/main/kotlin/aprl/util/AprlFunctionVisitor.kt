package aprl.util

import aprl.compiler.ERROR
import aprl.compiler.WARNING
import aprl.grammar.AprlParser.UnaryPostfixedExpressionContext
import aprl.ir.*
import aprl.ir.operators.*
import aprl.jvm.JvmMethod
import aprl.lang.OperatorFunction
import aprl.lang.Wrapper
import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import java.lang.reflect.Method
import java.util.ArrayDeque
import java.util.Comparator
import kotlin.math.max
import kotlin.math.min

class AprlFunctionVisitor(
    mv: MethodVisitor,
    private val ownerFile: AprlFile
) : MethodVisitor(ASM9, mv) {
    
    private lateinit var returnType: Class<*>
    
    private val types = ArrayDeque<Class<*>>()
    
    private val functionReferencesCandidates = ArrayDeque<List<JvmMethod>>()
    
    private val arguments = mutableListOf<AprlValueParameter>()
    
    private var currentLocalScope = LocalScope()
    private val maxLocalVariables = mutableListOf<Int>()
    
    private fun getAllAccessibleLocalVariables(): LocalVariables {
        val accessibleLocalVariables = emptyLocalVariables()
        var localScope: LocalScope? = currentLocalScope
        while (localScope != null) {
            accessibleLocalVariables.putAll(localScope.localVariables)
            localScope = localScope.parent
        }
        return accessibleLocalVariables
    }
    
    private fun enterLocalScope() {
        currentLocalScope = LocalScope(currentLocalScope)
    }
    
    private fun exitLocalScope() {
        val currentMaxLocals = currentLocalScope.localVariables.size
        val index = currentLocalScope.depth
        if (maxLocalVariables.size <= index) {
            maxLocalVariables.add(currentMaxLocals)
        } else {
            maxLocalVariables[index] = max(maxLocalVariables[index], currentMaxLocals)
        }
        currentLocalScope = currentLocalScope.parent ?: throw InternalError("More local scopes have been exited than entered")
    }
    
    @Suppress("SameParameterValue")
    private fun visitMaxs(maxStack: Int) {
        val maxLocals = maxLocalVariables.sum() + arguments.size
        super.visitMaxs(maxStack, maxLocals)
    }
    
    private fun visitExpression(expressionTree: ExpressionTree) {
        visitDisjunction(expressionTree)
    }
    
    private inline fun <reified Operator> visitLogicalConnective(
        expressionTree: ExpressionTree,
        crossinline inferiorExpressionHandler: (ExpressionTree) -> Unit,
        logicHandler: (labelLoad0: Label, labelLoad1: Label, labelContinue: Label) -> Unit,
        labelHandler: (labelLoad0: Label, labelLoad1: Label, labelContinue: Label) -> Unit
    ) {
        val handleOperand = { operand: ExpressionTree ->
            inferiorExpressionHandler(operand)
            // implicit conversion to boolean if necessary
            if (!aprl.lang.Boolean::class.java.isAssignableFrom(types.last)) {
                visitImplicitConversion(aprl.lang.Boolean::class.java, operand)
            }
            // primitive value from boolean wrapper
            visitMethodInsn(INVOKEVIRTUAL, "aprl/lang/Boolean", "__value__", "()Z", false)
        }
        
        val operands = expressionTree.flatSplit { it is Operator }
        if (operands.size > 1) {
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
            visitMethodInsn(INVOKESTATIC, "aprl/lang/Boolean", "valueOf", "(Z)Laprl/lang/Boolean;", false)
            types.add(aprl.lang.Boolean::class.java)
        } else {
            inferiorExpressionHandler(operands.single())
        }
    }
    
    private fun visitDisjunction(expressionTree: ExpressionTree) {
        visitLogicalConnective<AprlDisjunctionOperator>(
            expressionTree,
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
    
    private fun visitConjunction(expressionTree: ExpressionTree) {
        visitLogicalConnective<AprlConjunctionOperator>(
            expressionTree,
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
    
    private fun visitComparison(expressionTree: ExpressionTree) {
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
        
        handleComparand(comparands.first().second)
        
        if (comparands.size <= 1) {
            return
        }
        
        var previousComparand: ExpressionTree? = null
        val labelLoad0 = Label()
        val labelLoad1 = Label()
        val labelContinue = Label()
        
        fun performComparison(
            comparator: AprlNode<*>?,
            comparand: ExpressionTree,
            opcodes: IntArray,
            jumpLabel: Label
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
            var bestEqualsFunctionMatch: Method? = null
            for (method in lhsType.methods.filter { it.name == "compareTo" }) {
                // find function that returns Int and matches given rhs type
                if (Int::class.java.isAprlAssignableFrom(method.returnType)
                    && method.parameters.size == 1
                    && method.parameterTypes[0].isAprlAssignableFrom(rhsType)
                ) {
                    if (bestComparatorFunctionMatch?.parameterTypes?.get(0)?.isAssignableFrom(method.parameterTypes[0]) != false) {
                        bestComparatorFunctionMatch = method
                    }
                }
            }
            for (method in lhsType.methods.filter { it.name == "equals" }) {
                // find function that returns Boolean and matches given rhs type
                if (Boolean::class.java.isAprlAssignableFrom(method.returnType)
                    && method.parameters.size == 1
                    && method.parameterTypes[0].isAprlAssignableFrom(rhsType)
                ) {
                    if (bestEqualsFunctionMatch?.parameterTypes?.get(0)?.isAssignableFrom(method.parameterTypes[0]) != false) {
                        bestEqualsFunctionMatch = method
                    }
                }
            }
            if (bestEqualsFunctionMatch == null) {
                throw InternalError("Every object should have at least one .equals function")
            }
            if (bestComparatorFunctionMatch == null && !comparator.isIntrinsic) {
                ERROR("Operation '${comparator.operatorSymbol}' is not defined on types '${lhsType.simpleName}' and '${rhsType.simpleName}'", comparator.context.positionRange)
            } else {
                val invokeCompareTo = bestComparatorFunctionMatch?.let {{
                    wrapOrUnwrap(rhsType, bestComparatorFunctionMatch.parameterTypes[0])
                    val functionSignature = Type.getType(bestComparatorFunctionMatch).descriptor
                    visitMethodInsn(
                        INVOKEVIRTUAL,
                        bestComparatorFunctionMatch.declaringClass.internalName,
                        "compareTo",
                        functionSignature,
                        lhsType.isInterface
                    )
                    if (!Int::class.java.isAssignableFrom(bestComparatorFunctionMatch.returnType)) {
                        visitMethodInsn(
                            INVOKEVIRTUAL,
                            "aprl/lang/Int",
                            "__int__",
                            "()I",
                            false
                        )
                    }
                    visitInsn(ICONST_0)
                }}
                val invokeEquals = {
                    wrapOrUnwrap(rhsType, bestEqualsFunctionMatch.parameterTypes[0])
                    val functionSignature = Type.getType(bestEqualsFunctionMatch).descriptor
                    visitMethodInsn(
                        INVOKEVIRTUAL,
                        bestEqualsFunctionMatch.declaringClass.internalName,
                        "equals",
                        functionSignature,
                        false
                    )
                    if (!Boolean::class.java.isAssignableFrom(bestEqualsFunctionMatch.returnType)) {
                        visitMethodInsn(
                            INVOKEVIRTUAL,
                            "aprl/lang/Boolean",
                            "__value__",
                            "()Z",
                            false
                        )
                    }
                }
                when (comparator) {
                    is AprlComparisonOperator.AprlIdenticalOperator -> {
                        visitJumpInsn(opcodes[0], jumpLabel)
                    }
                    is AprlComparisonOperator.AprlNotIdenticalOperator -> {
                        visitJumpInsn(opcodes[1], jumpLabel)
                    }
                    is AprlComparisonOperator.AprlEqualOperator -> {
                        invokeEquals()
                        visitJumpInsn(opcodes[2], jumpLabel)
                    }
                    is AprlComparisonOperator.AprlNotEqualOperator -> {
                        invokeEquals()
                        visitJumpInsn(opcodes[3], jumpLabel)
                    }
                    is AprlComparisonOperator.AprlGreaterEqualOperator -> {
                        invokeCompareTo?.invoke()
                        visitJumpInsn(opcodes[4], jumpLabel)
                    }
                    is AprlComparisonOperator.AprlGreaterThanOperator -> {
                        invokeCompareTo?.invoke()
                        visitJumpInsn(opcodes[5], jumpLabel)
                    }
                    is AprlComparisonOperator.AprlLessEqualOperator -> {
                        invokeCompareTo?.invoke()
                        visitJumpInsn(opcodes[6], jumpLabel)
                    }
                    is AprlComparisonOperator.AprlLessThanOperator -> {
                        invokeCompareTo?.invoke()
                        visitJumpInsn(opcodes[7], jumpLabel)
                    }
                }
            }
        }
        
        for ((comparator, comparand) in comparands.drop(1).dropLast(1)) {
            performComparison(comparator, comparand, intArrayOf(IF_ACMPNE, IF_ACMPEQ, IFEQ, IFNE, IF_ICMPLT, IF_ICMPLE, IF_ICMPGT, IF_ICMPGE), labelLoad0)
            previousComparand = comparand
        }
        
        val (comparator, comparand) = comparands.last()
        performComparison(comparator, comparand, intArrayOf(IF_ACMPEQ, IF_ACMPNE, IFNE, IFEQ, IF_ICMPGE, IF_ICMPGT, IF_ICMPLE, IF_ICMPLT), labelLoad1)
        
        visitLabel(labelLoad0)
        visitInsn(ICONST_0)
        visitJumpInsn(GOTO, labelContinue)
        
        visitLabel(labelLoad1)
        visitInsn(ICONST_1)
        
        visitLabel(labelContinue)
        
        // convert primitive boolean back to wrapper type
        visitMethodInsn(INVOKESTATIC, "aprl/lang/Boolean", "valueOf", "(Z)Laprl/lang/Boolean;", false)
        types.add(aprl.lang.Boolean::class.java)
    }
    
    private fun visitOverloadableBinaryExpression(
        expression: ExpressionTree,
        operatorClass: Class<out AprlOverloadableBinaryOperator<*>>,
        inferiorExpressionHandler: (ExpressionTree) -> Unit,
        verbatim: Boolean
    ) {
        val operator = (expression.content as? AprlOverloadableBinaryOperator) ?: return inferiorExpressionHandler(expression)
        if (!operatorClass.isAssignableFrom(operator.javaClass)) {
            return inferiorExpressionHandler(expression)
        }
        if (expression.firstChild == null || expression.secondChild == null) {
            (expression.firstChild as? ExpressionTree)?.also { visitOverloadableBinaryExpression(it, operatorClass, inferiorExpressionHandler, verbatim) }
            (expression.secondChild as? ExpressionTree)?.also { visitOverloadableBinaryExpression(it, operatorClass, inferiorExpressionHandler, verbatim) }
        } else {
            visitOverloadableBinaryExpression(expression.firstChild as ExpressionTree, operatorClass, inferiorExpressionHandler, verbatim)
            var verbatimType: Class<*>? = null
            
            @Suppress("FunctionName")
            fun NO_VERBATIM() {
                WARNING("Verbatim evaluation not possible for expression '$expression'", expression.positionRange)
                verbatimType = null
            }
            
            if (verbatim) {
                if (types.last().methods.none { it.name == "__value__" && it.parameterTypes.isEmpty() }) {
                    WARNING("Verbatim evaluation not possible for expression '$expression'", expression.positionRange)
                } else {
                    val primitiveType = types.last().aprlToPrimitiveType()
                    if (primitiveType != null) {
                        visitMethodInsn(
                            INVOKEVIRTUAL,
                            types.last().internalName,
                            "__value__",
                            "()${primitiveType.descriptor}",
                            false
                        )
                        verbatimType = primitiveType
                    } else {
                        WARNING("Verbatim evaluation not possible for expression '$expression'", expression.positionRange)
                    }
                }
            }
            visitOverloadableBinaryExpression(expression.secondChild as ExpressionTree, operatorClass, inferiorExpressionHandler, verbatim)
            if (verbatim && verbatimType != null) {
                if (types.last().methods.none { it.name == "__value__" && it.parameterTypes.isEmpty() }) {
                    NO_VERBATIM()
                } else {
                    val primitiveType = types.last().aprlToPrimitiveType()
                    if (primitiveType != null) {
                        visitMethodInsn(INVOKEVIRTUAL, types.last().internalName, "__value__", "()$primitiveType", false)
                        if (primitiveType != verbatimType) {
                            NO_VERBATIM()
                        } else {
                            types.pollLast()
                            types.pollLast()
                            types.add(primitiveType)
                        }
                    } else {
                        WARNING("Verbatim evaluation not possible for expression '$expression'", expression.positionRange)
                        verbatimType = null
                    }
                }
            }
            val leftType = types.previousToLast ?: throw InternalError("The compiler was not able to type-check one or multiple expressions")
            val rightType = types.lastButNotFirstOrNull() ?: Any::class.java.also { types.add(it) }
            if (verbatim && verbatimType != null) {
                val primitiveDescriptor = verbatimType!!.primitiveDescriptorOrNull()!!
                when (operator) {
                    is AprlBitwiseOperator.AprlAndOperator -> {
                        when (primitiveDescriptor) {
                            "I" -> visitInsn(IAND)
                            "J" -> visitInsn(LAND)
                            else -> NO_VERBATIM()
                        }
                    }
                    is AprlBitwiseOperator.AprlOrOperator -> {
                        when (primitiveDescriptor) {
                            "I" -> visitInsn(IOR)
                            "J" -> visitInsn(LOR)
                            else -> NO_VERBATIM()
                        }
                    }
                    is AprlBitwiseOperator.AprlXorOperator -> {
                        when (primitiveDescriptor) {
                            "I" -> visitInsn(IXOR)
                            "J" -> visitInsn(LXOR)
                            else -> NO_VERBATIM()
                        }
                    }
                    is AprlBitwiseOperator.AprlShlOperator -> {
                        when (primitiveDescriptor) {
                            "I" -> visitInsn(ISHL)
                            "J" -> visitInsn(LSHL)
                            else -> NO_VERBATIM()
                        }
                    }
                    is AprlBitwiseOperator.AprlShrOperator -> {
                        when (primitiveDescriptor) {
                            "I" -> visitInsn(ISHR)
                            "J" -> visitInsn(LSHR)
                            else -> NO_VERBATIM()
                        }
                    }
                    is AprlBitwiseOperator.AprlUshrOperator -> {
                        when (primitiveDescriptor) {
                            "I" -> visitInsn(IUSHR)
                            "J" -> visitInsn(LUSHR)
                            else -> NO_VERBATIM()
                        }
                    }
                    is AprlAdditiveOperator.AprlPlusOperator -> {
                        when (primitiveDescriptor) {
                            "I" -> visitInsn(IADD)
                            "J" -> visitInsn(LADD)
                            "F" -> visitInsn(FADD)
                            "D" -> visitInsn(DADD)
                            else -> NO_VERBATIM()
                        }
                    }
                    is AprlAdditiveOperator.AprlMinusOperator -> {
                        when (primitiveDescriptor) {
                            "I" -> visitInsn(ISUB)
                            "J" -> visitInsn(LSUB)
                            "F" -> visitInsn(FSUB)
                            "D" -> visitInsn(DSUB)
                            else -> NO_VERBATIM()
                        }
                    }
                    is AprlMultiplicativeOperator.AprlMultiplyOperator -> {
                        when (primitiveDescriptor) {
                            "I" -> visitInsn(IMUL)
                            "J" -> visitInsn(LMUL)
                            "F" -> visitInsn(FMUL)
                            "D" -> visitInsn(DMUL)
                            else -> NO_VERBATIM()
                        }
                    }
                    is AprlMultiplicativeOperator.AprlDivideOperator -> {
                        when (primitiveDescriptor) {
                            "I" -> visitInsn(IDIV)
                            "J" -> visitInsn(LDIV)
                            "F" -> visitInsn(FDIV)
                            "D" -> visitInsn(DDIV)
                            else -> NO_VERBATIM()
                        }
                    }
                    is AprlMultiplicativeOperator.AprlModuloOperator -> {
                        when (primitiveDescriptor) {
                            "I" -> visitInsn(IREM)
                            "J" -> visitInsn(LREM)
                            "F" -> visitInsn(FREM)
                            "D" -> visitInsn(DREM)
                            else -> NO_VERBATIM()
                        }
                    }
                    else -> NO_VERBATIM()
                }
                when (primitiveDescriptor) {
                    "D", "F" -> visitUnspecificWrapperInitialization(Double::class.java, aprl.lang.Float::class.java)
                    "J", "I" -> visitUnspecificWrapperInitialization(Long::class.java, aprl.lang.Int::class.java)
                    else -> NO_VERBATIM()
                }
            }
            if (!verbatim) {
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
                    val returnType = bestOperatorFunctionMatch.returnType.descriptor
                    visitMethodInsn(INVOKEVIRTUAL, types.previousToLast.name.replace(".", "/"), operator.functionName, "(${types.lastButNotFirst.descriptor})$returnType", false)
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
    
    private fun visitBitwiseExpression(expression: ExpressionTree) {
        visitOverloadableBinaryExpression(
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
    
    private fun visitAdditiveExpression(expression: ExpressionTree) {
        visitOverloadableBinaryExpression(
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
    
    private fun visitMultiplicativeExpression(expression: ExpressionTree) {
        visitOverloadableBinaryExpression(
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
                        visitUnaryPrefixedExpression(operand)
                    }
                }
            },
            verbatim = false
        )
    }
    
    private fun visitUnaryPrefixedExpression(expressionTree: ExpressionTree) {
        val operand = expressionTree.firstChild as? ExpressionTree ?: expressionTree
        if (expressionTree.content !is AprlUnaryPrefixOperator) {
            visitExponentialExpression(expressionTree)
            return
        }
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
                visitExponentialExpression(operand)
            }
        }
        val operator = expressionTree.content as? AprlUnaryPrefixOperator ?: return
        val operatorFunction = types.last().methods.singleOrNull { it.name == operator.functionName && it.parameterTypes.isEmpty() }
        if (operatorFunction != null) {
            val returnType = operatorFunction.returnType.descriptor
            visitMethodInsn(INVOKEVIRTUAL, types.last().name.replace(".", "/"), operator.functionName, "()$returnType", false)
            // remove operand type
            types.pollLast()
            // add return type
            types.add(operatorFunction.returnType)
        } else {
            ERROR("Operation '${operator.operatorSymbol}' not defined on type '${types.last().simpleName}'", operator.context.positionRange)
        }
    }
    
    private fun visitExponentialExpression(expression: ExpressionTree) {
        visitOverloadableBinaryExpression(
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
                    is AprlUnaryPrefixOperator -> {
                        visitUnaryPrefixedExpression(operand)
                    }
                    else -> {
                        visitUnaryPostfixedExpression(operand)
                    }
                }
            },
            verbatim = false
        )
    }
    
    private fun visitUnaryPostfixedExpression(expressionTree: ExpressionTree) {
        val oldFunctionReferenceCount = functionReferencesCandidates.size
        val operand = expressionTree.firstChild as? ExpressionTree ?: expressionTree
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
            is AprlUnaryPostfix<*> -> {
                visitUnaryPostfixedExpression(operand)
            }
            else -> {
                visitAtomicExpression(operand)
            }
        }
        val postfix = expressionTree.content as? AprlUnaryPostfix<*> ?: return
        when (postfix) {
            is AprlValueArguments -> {
                val argsCount = postfix.valueArguments.size
                val newFunctionReferenceCount = functionReferencesCandidates.size
                visitValueArguments(postfix)
                if (newFunctionReferenceCount > oldFunctionReferenceCount) {
                    // find matching function and call it
                    val functionCandidates = functionReferencesCandidates.removeLast()
                    if (functionCandidates.isEmpty()) {
                        val identifier = (postfix.context.getParent() as? UnaryPostfixedExpressionContext)?.atomicExpression()?.identifier()
                            ?: throw InternalError("Identifier had value arguments before, but not anymore")
                        ERROR("Unresolved reference: '$identifier'", identifier.positionRange)
                    }
                    val functionRatings = hashMapOf<JvmMethod, Pair<Int, MutableList<() -> Unit>>>()
                    for (function in functionCandidates) {
                        val expectedArgsCount = function.parameterTypes.size
                        val argCountDifference = argsCount - expectedArgsCount
                        val mismatchedTypeErrors = mutableListOf<() -> Unit>()
                        for (i in 0 until min(expectedArgsCount, argsCount)) {
                            val expectedType = function.parameterTypes[i].nonPrimitive()
                            val aprlExpectedType = expectedType.jvmToAprlType()
                            
                            val providedType = types.elementAt(types.size - argsCount + i)
                            val jvmProvidedType = providedType.aprlToJvmType()
                            
                            if (!(expectedType.isAssignableFrom(jvmProvidedType) || expectedType.isAssignableFrom(providedType))) {
                                mismatchedTypeErrors.add {
                                    ERROR("Type mismatch: Parameter '${function.parameterNames[i]}' expects '${aprlExpectedType.simpleName}', got '${providedType.simpleName}'", postfix.valueArguments[i].context.positionRange)
                                }
                            }
                        }
                        functionRatings[function] = argCountDifference to mismatchedTypeErrors
                    }
                    val ratingsComparator = Comparator<Pair<JvmMethod, Pair<Int, List<() -> Unit>>>> { p0, p1 ->
                        if (p0.second.first > p1.second.first) 1
                        else if (p0.second.first < p1.second.first) -1
                        else if (p0.second.second.size > p1.second.second.size) 1
                        else if (p0.second.second.size < p1.second.second.size) -1
                        else 0
                    }
                    val sortedFunctions = functionRatings.toList().sortedWith(ratingsComparator)
                    val optimalMatches = mutableListOf<JvmMethod>()
                    for ((function, rating) in sortedFunctions) {
                        if (rating.first != 0 || rating.second.isNotEmpty()) {
                            break
                        }
                        optimalMatches.add(function)
                    }
                    val bestMatch: JvmMethod
                    when (optimalMatches.size) {
                        0 -> {
                            // error for wrong args count and mismatched types
                            bestMatch = sortedFunctions[0].first
                            val argCountDifference = bestMatch.parameterTypes.size - argsCount
                            if (argCountDifference > 0) {
                                val message = if (argCountDifference == 1) {
                                    "1 missing argument for function '${bestMatch.simpleName}'" // TODO: specify which argument is missing
                                } else {
                                    "${-argCountDifference} missing arguments for function '${bestMatch.simpleName}'" // TODO: specify which arguments are missing
                                }
                                ERROR(message, postfix.context.positionRange)
                            } else if (argCountDifference < 0) {
                                val message = "$argCountDifference too many arguments for function '${bestMatch.simpleName}'"
                                ERROR(message, postfix.valueArguments.drop(bestMatch.parameterTypes.size).let { it.first().context.positionRange.join(it.last().context.positionRange) })
                            }
                            sortedFunctions[0].second.second.forEach { it() }
                        }
                        1 -> {
                            bestMatch = optimalMatches.single()
                        }
                        else -> {
                            // error for ambiguity
                            bestMatch = optimalMatches[0]
                            ERROR("Ambiguous function call, could refer to ${optimalMatches.dropLast(1).joinToString(", ") { "'${it.simpleName}'" }} or '${optimalMatches.last().simpleName}'", postfix.context.getParent().positionRange)
                        }
                    }
                    visitMethodInsn(INVOKESTATIC, ownerFile.jvmInternalName, bestMatch.name, bestMatch.descriptor, false)
                    repeat(argsCount) {
                        types.pollLast()
                    }
                    val aprlReturnType = bestMatch.returnType.jvmToAprlType()
                    if (aprlReturnType != bestMatch.returnType) {
                        @Suppress("UNCHECKED_CAST")
                        visitUnspecificWrapperInitialization(bestMatch.returnType, aprlReturnType as Class<out Wrapper<*>>)
                    }
                    types.add(aprlReturnType)
                } else {
                    // find matching .invoke() @OperatorFunction function on TOS and call it
                }
            }
        }
    }
    
    private fun visitAtomicExpression(expression: ExpressionTree) {
        when (val content = expression.content) {
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
            is AprlUnaryPrefixOperator -> {
                visitUnaryPrefixedExpression(expression)
            }
            is AprlExponentialOperator -> {
                visitExponentialExpression(expression)
            }
            is AprlLiteral<*> -> {
                visitExplicitWrapperInitialization(content.value, content.internalType)
            }
            is AprlIdentifier -> {
                val localVariable = getAllAccessibleLocalVariables()["$content"]
                val argument = arguments.firstOrNull { it.name == content.toString() }
                if (localVariable != null) {
                    if (!localVariable.initialized) {
                        ERROR(
                            "Local variable '$content' might not have been initialized",
                            content.context.positionRange
                        )
                    }
                    visitVarInsn(ALOAD, localVariable.index)
                    types.add(localVariable.type)
                } else if (argument != null) {
                    visitVarInsn(ALOAD, arguments.indexOf(argument))
                    types.add(argument.type.javaType)
                } else if ((content.context.parent.parent as UnaryPostfixedExpressionContext).unaryPostfix()?.valueArguments() != null) {
                    // TODO (LATER): identifier could refer to instance functions instead of just static ones
                    val functionCandidates = ownerFile.findStaticFunctions(content)
                    functionReferencesCandidates.add(functionCandidates)
                } else {
                    ERROR("Unresolved reference '$content'", content.context.positionRange)
                }
            }
            else -> {
                throw InternalError("Compiler encountered unexpected token: '$expression'")
            }
        }
    }
    
    private fun visitValueArguments(valueArguments: AprlValueArguments) {
        valueArguments.valueArguments.forEach(::visitValueArgument)
    }
    
    private fun visitValueArgument(valueArgument: AprlValueArgument) {
        visitExpressionOptimization(valueArgument.expression.toTree())
        // TODO: consider case that a JVM type is expected, but APRL type is passed
    }
    
    private fun visitUnspecificWrapperInitialization(wrappedType: Class<*>, wrapperType: Class<out Wrapper<*>>) {
        val representedTypeDescriptor = wrappedType.primitiveDescriptorOrNull() ?: wrappedType.descriptor
        val funcDescriptor = "($representedTypeDescriptor)${wrapperType.descriptor}"
        visitMethodInsn(INVOKESTATIC, wrapperType.internalName, "valueOf", funcDescriptor, false)
        types.add(wrapperType)
    }
    
    private fun <T: Any> visitExplicitWrapperInitialization(value: T?, wrapperType: Class<out T>) {
        if (value != null) {
            visitLdcInsn(value)
        } else {
            visitInsn(ACONST_NULL)
        }
        val representedType = (value?.javaClass ?: Any::class.java).let { it.primitiveDescriptorOrNull() ?: it.descriptor }
        visitMethodInsn(INVOKESTATIC, wrapperType.internalName, "valueOf", "($representedType)${wrapperType.descriptor}", false)
        types.add(wrapperType)
    }
    
    private fun wrapOrUnwrap(from: Class<*>, to: Class<*>) {
        if (to.isAprlAssignableFrom(from) && !to.isAssignableFrom(from)) {
            if (Wrapper::class.java.isAssignableFrom(from)) {
                visitMethodInsn(
                    INVOKEVIRTUAL,
                    from.internalName,
                    "__value__",
                    "()${from.aprlToPrimitiveType()!!.descriptor}",
                    false
                )
            } else if (Wrapper::class.java.isAssignableFrom(to)) {
                @Suppress("UNCHECKED_CAST")
                visitUnspecificWrapperInitialization(from, to as Class<out Wrapper<*>>)
            }
        }
    }
    
    private fun visitImplicitConversion(expectedType: Class<*>, expressionString: String, expressionPosition: PositionRange) {
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
            visitMethodInsn(INVOKEVIRTUAL, types.last().internalName, conversionFunctionName, "()${bestConversionFunctionMatch.returnType.descriptor}", false)
            types.pollLast()
            types.add(bestConversionFunctionMatch.returnType)
            WARNING("Implicit conversion from '${types.last.simpleName}' to '${bestConversionFunctionMatch.returnType.simpleName}'", expressionPosition)
        }
    }
    
    private fun visitImplicitConversion(expectedType: Class<*>, expression: ExpressionTree) {
        visitImplicitConversion(expectedType, expression.toString(), expression.positionRange)
    }
    
    private fun visitImplicitConversion(expectedType: Class<*>, expression: AprlNode<*>) {
        visitImplicitConversion(expectedType, expression.toString(), expression.context.positionRange)
    }
    
    private fun visitExpressionOptimization(expressionTree: ExpressionTree, implicitConversion: Class<*>? = null) {
        val beforeOptimization = expressionTree.deepCopy()
        expressionTree.optimize()
        if (expressionTree.childCount != beforeOptimization.childCount && "$expressionTree" != "$beforeOptimization") {
            WARNING("Expression '$beforeOptimization' can be evaluated to '$expressionTree'", beforeOptimization.positionRange)
        }
        visitExpression(expressionTree)
        if (implicitConversion != null && !implicitConversion.isAssignableFrom(types.last())) {
            visitImplicitConversion(implicitConversion, beforeOptimization)
        }
    }
    
    private fun visitExpressionOrDefaultValue(expression: AprlExpression?, type: Class<*>) {
        val expressionTree = expression?.toTree()
        if (expressionTree != null) {
            visitExpressionOptimization(expressionTree)
        } else {
            if (Wrapper::class.java.isAssignableFrom(type)) {
                visitExplicitWrapperInitialization(type.defaultValue, type)
            } else {
                visitInsn(ACONST_NULL)
            }
        }
    }
    
    private fun visitVariableDeclaration(declaration: AprlVariableDeclaration) {
        var variableType = declaration.typeAnnotation?.javaType
        visitExpressionOrDefaultValue(declaration.expression, variableType ?: Any::class.java)
        variableType = variableType ?: types.lastOrNull() ?: return
        val index: Int
        val accessibleLocalVariables = getAllAccessibleLocalVariables()
        if (declaration.identifier in accessibleLocalVariables.keys) {
            index = accessibleLocalVariables[declaration.identifier]!!.index
            val originalDeclaration = accessibleLocalVariables[declaration.identifier]!!.originalDeclaration
            val errorMessage = run {
                val originalSignature = "${originalDeclaration.variableClassifier} ${originalDeclaration.identifier}: ${accessibleLocalVariables[declaration.identifier]!!.type.simpleName}"
                val redeclaredSignature = "${declaration.variableClassifier} ${declaration.identifier}: ${variableType.simpleName}"
                "Conflicting declarations: $originalSignature, $redeclaredSignature"
            }
            ERROR(errorMessage, declaration.context.simpleIdentifier().positionRange)
            ERROR(errorMessage, originalDeclaration.context.simpleIdentifier().positionRange)
        } else {
            if (declaration.identifier in arguments.map { it.name }) {
                val originalDeclaration = arguments.first { it.name == declaration.identifier }
                WARNING("${declaration.variableClassifier} ${declaration.identifier} shadows name of parameter ${originalDeclaration.name}", declaration.context.simpleIdentifier().positionRange)
            }
            index = accessibleLocalVariables.values.map { it.index }.nextOrMissing(arguments.size)
            val isMutable = declaration.variableClassifier != VariableClassifier.VAL
            currentLocalScope.localVariables[declaration.identifier] = LocalVariable(index, isMutable, variableType, declaration.expression != null, declaration)
        }
        if (!variableType.isAssignableFrom(types.lastOrNull() ?: variableType)) {
            // no direct assignment possible => conversion required
            visitImplicitConversion(variableType, declaration.expression!!)
        }
        visitVarInsn(ASTORE, index)
    }
    
    private fun visitVariableAssignment(assignment: AprlVariableAssignment) {
        val expressionTree = assignment.expression.toTree()
        expressionTree.optimize()
        val accessibleLocalVariables = getAllAccessibleLocalVariables()
        when (assignment.identifier) {
            in accessibleLocalVariables.keys -> {
                val localVariable = accessibleLocalVariables[assignment.identifier]!!
                if (!localVariable.isMutable) {
                    // Variable cannot be reassigned
                    ERROR("'${assignment.identifier}' is immutable", assignment.context.simpleIdentifier().positionRange)
                }
                visitExpressionOptimization(expressionTree)
                if (types.firstOrNull()?.let { localVariable.type.isAssignableFrom(it) } != true) {
                    visitImplicitConversion(localVariable.type, assignment.expression)
                }
                visitVarInsn(ASTORE, localVariable.index)
            }
            in arguments.map { it.name } -> {
                ERROR("Parameter '${assignment.identifier}' cannot be reassigned", assignment.context.simpleIdentifier().positionRange)
            }
            else -> {
                ERROR("Unresolved reference '${assignment.identifier}'", assignment.context.simpleIdentifier().positionRange)
            }
        }
    }
    
    private fun visitConditionalStatement(conditionalStatement: AprlConditionalStatement) {
        val ifLabels = conditionalStatement.ifStatements.map { Label() }
        val elseLabel = conditionalStatement.elseStatement?.let { Label() }
        val endLabel = Label()
        
        for ((i, ifLabel) in ifLabels.withIndex()) {
            visitLabel(ifLabel)
            val ifStatement = conditionalStatement.ifStatements[i]
            visitExpressionOptimization(ifStatement.expression.toTree())
            if (aprl.lang.Boolean::class.java.isAssignableFrom(types.last())) {
                visitMethodInsn(INVOKEVIRTUAL, "aprl/lang/Boolean", "__value__", "()Z", false)
            } else if (!Boolean::class.java.isAssignableFrom(types.last())) {
                visitImplicitConversion(aprl.lang.Boolean::class.java, ifStatement.expression)
                visitMethodInsn(INVOKEVIRTUAL, "aprl/lang/Boolean", "__value__", "()Z", false)
            }
            when (ifStatement.conditionalKeyword) {
                ConditionalKeyword.IF -> {
                    visitJumpInsn(IFEQ, ifLabels.getOrNull(i + 1) ?: elseLabel ?: endLabel)
                }
                ConditionalKeyword.UNLESS -> {
                    visitJumpInsn(IFNE, ifLabels.getOrNull(i + 1) ?: elseLabel ?: endLabel)
                }
            }
            enterLocalScope()
            ifStatement.statements.forEach(::visitLocalStatement)
            exitLocalScope()
            visitJumpInsn(GOTO, endLabel)
        }
        
        if (conditionalStatement.elseStatement != null) {
            visitLabel(elseLabel)
            enterLocalScope()
            conditionalStatement.elseStatement!!.statements.forEach(::visitLocalStatement)
            exitLocalScope()
        }
        visitLabel(endLabel)
    }
    
    private fun visitReturnStatement(returnStatement: AprlReturnStatement) {
        if (returnType != Void::class.java) {
            if (returnStatement.expression == null) {
                ERROR("Return value of type '${returnType.simpleName}' expected", returnStatement.context.RETURN().symbol.positionRange)
                visitInsn(ACONST_NULL)
            } else {
                visitExpressionOptimization(returnStatement.expression!!.toTree(), returnType)
            }
            visitInsn(ARETURN)
        } else {
            if (returnStatement.expression != null) {
                ERROR("Void function should not return a value", returnStatement.expression!!.context.positionRange)
            }
            visitInsn(RETURN)
        }
    }
    
    private fun visitLocalStatement(statement: AprlLocalStatement) {
        if (currentLocalScope.hasDefinitelyReturned) {
            ERROR("Unreachable code", statement.context.positionRange)
            return
        }
        when (statement) {
            is AprlVariableDeclaration -> {
                visitVariableDeclaration(statement)
            }
            is AprlVariableAssignment -> {
                visitVariableAssignment(statement)
            }
            is AprlConditionalStatement -> {
                visitConditionalStatement(statement)
            }
            is AprlReturnStatement -> {
                visitReturnStatement(statement)
            }
        }
        if (statement.isDefinitiveReturnStatement()) {
            currentLocalScope.hasDefinitelyReturned = true
        }
    }
    
    private fun visitFunctionBody(functionBody: AprlFunctionBody) {
        functionBody.statements.forEach(::visitLocalStatement)
        if (!currentLocalScope.hasDefinitelyReturned) {
            if (returnType == Void::class.java) {
                visitInsn(RETURN)
            } else {
                ERROR("Missing return statement", functionBody.context.RCURLY().symbol.positionRange)
            }
        }
    }
    
    private fun visitArgument(argument: AprlValueParameter) {
        arguments.add(argument)
    }
    
    private fun visitArguments(arguments: List<AprlValueParameter>) {
        arguments.forEach(::visitArgument)
        this.arguments.duplicates { it.name }.forEach {
            val errorMessage = "Conflicting declarations: ${it.joinToString(", p", "P") { param -> "arameter ${param.name}: ${param.type}" }}"
            for (redeclaration in it) {
                ERROR(errorMessage, redeclaration.context.simpleIdentifier().positionRange)
            }
        }
    }
    
    private fun visitReturnType(returnType: AprlTypeReference?) {
        this.returnType = returnType?.javaType ?: Void::class.java
    }
    
    fun visitFunctionDeclaration(functionDeclaration: AprlFunctionDeclaration) {
        visitCode()
        visitArguments(functionDeclaration.valueParameters)
        visitReturnType(functionDeclaration.returnType)
        visitFunctionBody(functionDeclaration.functionBody)
        visitMaxs(4) // TODO: calculate max stack size
        visitEnd()
    }
    
}
