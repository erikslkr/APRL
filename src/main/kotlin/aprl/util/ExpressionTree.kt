package aprl.util

import aprl.compiler.ERROR
import aprl.compiler.PositionRange
import aprl.grammar.AprlParser.LiteralContext
import aprl.ir.*
import aprl.ir.operators.*
import aprl.lang.Wrapper

class ExpressionTree(
    firstChild: ExpressionTree? = null,
    secondChild: ExpressionTree? = null,
    content: AprlNode<*>?
) : BinaryTree<AprlNode<*>>(firstChild, secondChild, content) {
    
    private val firstChildExpressionTree: ExpressionTree?
        get() = (firstChild as? ExpressionTree)
    
    private val secondChildExpressionTree: ExpressionTree?
        get() = (secondChild as? ExpressionTree)
    
    val positionRange: PositionRange
        get() {
            return toList().let { it.first().context.positionRange.first to it.last().context.positionRange.second }
        }
    
    private fun cauterize(literal: AprlLiteral<*>) {
        content = literal
        firstChild = null
        secondChild = null
    }
    
    private fun cauterize(expression: ExpressionTree) {
        content = expression.content
        expression.let {
            firstChild = it.firstChild
            secondChild = it.secondChild
        }
    }
    
    fun deepCopy(): ExpressionTree {
        return ExpressionTree(firstChildExpressionTree?.deepCopy(), secondChildExpressionTree?.deepCopy(), content)
    }
    
    fun flatSplit(predicate: (AprlNode<*>) -> Boolean): List<ExpressionTree> {
        val content = content ?: return emptyList()
        return if (predicate(content)) {
            val leftList = firstChildExpressionTree?.flatSplit(predicate) ?: emptyList()
            val rightList = secondChildExpressionTree?.flatSplit(predicate) ?: emptyList()
            leftList + rightList
        } else {
            listOf(this)
        }
    }
    
    fun flatSplitIncludingDelimiters(predicate: (AprlNode<*>) -> Boolean): List<Pair<AprlNode<*>?, ExpressionTree>> {
        val content = content ?: return emptyList()
        return if (predicate(content)) {
            val leftList = firstChildExpressionTree?.flatSplitIncludingDelimiters(predicate) ?: emptyList()
            val rightList = secondChildExpressionTree?.flatSplitIncludingDelimiters(predicate) ?: emptyList()
            leftList + (content to rightList.first().second) + rightList.drop(1)
        } else {
            listOf(null to this)
        }
    }
    
    val childCount: Int
        get() = ((firstChild as? ExpressionTree)?.childCount ?: 0) + ((secondChild as? ExpressionTree)?.childCount ?: 0) + (if (content == null) 0 else 1)
    
    override fun toString(): String {
        return if (content == null) {
            if (firstChild != null) {
                "$firstChild"
            } else if (secondChild != null) {
                "$secondChild"
            } else {
                "<UNKNOWN EXPRESSION>"
            }
        } else {
            if (firstChild != null && secondChild != null) {
                "$firstChild $content $secondChild"
            } else {
                "$content"
            }
        }
    }
    
    fun optimize() {
        // TODO: optimize and type-check: disjunctions, conjunctions and comparisons
        (firstChild as? ExpressionTree)?.optimize()
        (secondChild as? ExpressionTree)?.optimize()
        if (content is AprlOverloadableOperator) {
            val lhs = firstChild?.content
            val rhs = secondChild?.content
            
            val syntheticContext = content?.context?.let { LiteralContext(it.getParent(), it.invokingState) } ?: return
            
            fun optimizeCommutativeCncExpression(constant: AprlLiteral<*>, nonConstant: ExpressionTree) {
                when (content) {
                    is AprlBitwiseOperator -> {
                        if (constant.value == 0L) {
                            when (content) {
                                is AprlBitwiseOperator.AprlAndOperator -> {
                                    cauterize(AprlIntegerLiteral(0, syntheticContext))
                                }
                                else -> {
                                    cauterize(nonConstant)
                                }
                            }
                        }
                    }
                    is AprlAdditiveOperator.AprlPlusOperator -> {
                        if (constant.value == 0L || constant.value == 0.0) {
                            cauterize(nonConstant)
                        }
                    }
                    is AprlMultiplicativeOperator.AprlMultiplyOperator -> {
                        when (constant.value) {
                            0L -> {
                                cauterize(AprlIntegerLiteral(0, syntheticContext))
                            }
                            0.0 -> {
                                cauterize(AprlFloatLiteral(0.0, syntheticContext))
                            }
                            1L, 1.0 -> {
                                cauterize(nonConstant)
                            }
                        }
                    }
                }
            }
            
            if (rhs is AprlLiteral<*>) {
                if (lhs is AprlLiteral<*>) {
                    // lhs: constant, rhs: constant
                    val lhsWrapped = Wrapper.wrap(lhs.value)
                    val rhsWrapped = Wrapper.wrap(rhs.value)
                    
                    val literal = when (val evaluated = (content as AprlOverloadableOperator).applyOrNull(lhsWrapped, rhsWrapped)) {
                        is Boolean -> AprlBooleanLiteral(evaluated, syntheticContext)
                        is Long -> AprlIntegerLiteral(evaluated, syntheticContext)
                        is Double -> AprlFloatLiteral(evaluated, syntheticContext)
                        is Char -> AprlCharLiteral(evaluated, syntheticContext)
                        is String -> AprlStringLiteral(evaluated, syntheticContext)
                        else -> return
                    }
                    cauterize(literal)
                } else {
                    // lhs: non-constant, rhs: constant
                    when (content) {
                        is AprlMultiplicativeOperator.AprlModuloOperator -> {
                            when (rhs.value) {
                                1.0 -> {
                                    cauterize(AprlFloatLiteral(0.0, syntheticContext))
                                }
                                1L -> {
                                    cauterize(AprlIntegerLiteral(0, syntheticContext))
                                }
                                0.0, 0L -> {
                                    ERROR("Division by zero", content!!.context.getParent().positionRange)
                                }
                            }
                        }
                        is AprlAdditiveOperator.AprlMinusOperator -> {
                            if (rhs.value == 0 || rhs.value == 0.0) {
                                cauterize(firstChild!! as ExpressionTree)
                            }
                        }
                        is AprlMultiplicativeOperator.AprlDivideOperator -> {
                            when (rhs.value) {
                                1.0, 1L -> {
                                    cauterize(firstChild!! as ExpressionTree)
                                }
                                0.0, 0L -> {
                                    ERROR("Division by zero", content!!.context.getParent().positionRange)
                                }
                            }
                        }
                        is AprlExponentialOperator -> {
                            if (rhs.value == 0L || rhs.value == 0.0) {
                                cauterize(AprlIntegerLiteral(1, syntheticContext))
                            }
                        }
                        else -> {
                            optimizeCommutativeCncExpression(rhs, firstChild!! as ExpressionTree)
                        }
                    }
                }
            } else if (lhs is AprlLiteral<*>) {
                // lhs: constant, rhs: non-constant
                if (content is AprlExponentialOperator && lhs.value == 1L) {
                    cauterize(AprlIntegerLiteral(1, syntheticContext))
                } else {
                    optimizeCommutativeCncExpression(lhs, secondChild!! as ExpressionTree)
                }
            }
        } else if (content == null) {
            if (firstChild == null) {
                cauterize(secondChild!! as ExpressionTree)
            } else if (secondChild == null) {
                cauterize(firstChild!! as ExpressionTree)
            }
        }
    }
    
    companion object {
        fun leaf(content: AprlNode<*>): ExpressionTree {
            return ExpressionTree(null, null, content)
        }
    }
    
}
