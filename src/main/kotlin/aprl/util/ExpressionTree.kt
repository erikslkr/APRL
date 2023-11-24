package aprl.util

import aprl.compiler.AprlCompiler
import aprl.compiler.ERROR
import aprl.compiler.PositionRange
import aprl.grammar.AprlParser
import aprl.ir.*
import aprl.ir.operators.*
import aprl.lang.Wrapper

class ExpressionTree(
    firstChild: ExpressionTree? = null,
    secondChild: ExpressionTree? = null,
    content: AprlNode<*>?
) : BinaryTree<AprlNode<*>>(firstChild, secondChild, content) {
    
    val positionRange: PositionRange
        get() = toList().let { it.first().context.positionRange.first to it.last().context.positionRange.second }
    
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
        return ExpressionTree((firstChild as? ExpressionTree)?.deepCopy(), (secondChild as? ExpressionTree)?.deepCopy(), content)
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
    
    fun print(indent: Int = 3) {
        content?.let { println(" ".repeat(indent) + it) }
        (firstChild as? ExpressionTree)?.print(indent + 3)
        (secondChild as? ExpressionTree)?.print(indent + 3)
    }
    
    fun optimize() {
        // TODO: optimize and type-check: disjunctions, conjunctions and comparisons
        (firstChild as? ExpressionTree)?.optimize()
        (secondChild as? ExpressionTree)?.optimize()
        if (content is AprlOperator) {
            val lhs = firstChild?.content
            val rhs = secondChild?.content
            
            fun optimizeCommutativeCncExpression(constant: AprlLiteral<*>, nonConstant: ExpressionTree) {
                when (content) {
                    is AprlBitwiseOperator -> {
                        if (constant.value == 0L) {
                            when (content) {
                                is AprlBitwiseOperator.AprlAndOperator -> {
                                    cauterize(AprlIntegerLiteral(0))
                                }
                                else -> {
                                    cauterize(nonConstant)
                                }
                            }
                        }
                    }
                    is AprlAdditiveOperator -> {
                        if (constant.value == 0L || constant.value == 0.0) {
                            cauterize(nonConstant)
                        }
                    }
                    is AprlMultiplicativeOperator.AprlMultiplyOperator -> {
                        when (constant.value) {
                            0L -> {
                                cauterize(AprlIntegerLiteral(0))
                            }
                            0.0 -> {
                                cauterize(AprlFloatLiteral(0.0))
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
                        is Boolean -> AprlBooleanLiteral(evaluated)
                        is Long -> AprlIntegerLiteral(evaluated)
                        is Double -> AprlFloatLiteral(evaluated)
                        is Char -> AprlCharLiteral(evaluated)
                        is String -> AprlStringLiteral(evaluated)
                        else -> return
                    }
                    cauterize(literal)
                } else {
                    // lhs: non-constant, rhs: constant
                    when (content) {
                        is AprlMultiplicativeOperator.AprlModuloOperator -> {
                            when (rhs.value) {
                                1.0 -> {
                                    cauterize(AprlFloatLiteral(0.0))
                                }
                                1L -> {
                                    cauterize(AprlIntegerLiteral(0))
                                }
                                0.0, 0L -> {
                                    ERROR("Division by zero", content!!.context.getParent().positionRange)
                                }
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
                                cauterize(AprlIntegerLiteral(1))
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
                    cauterize(AprlIntegerLiteral(1))
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
