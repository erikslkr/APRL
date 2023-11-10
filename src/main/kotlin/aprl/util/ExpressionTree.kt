package aprl.util

import aprl.compiler.ERROR
import aprl.compiler.WARNING
import aprl.ir.*

class ExpressionTree(
    firstChild: ExpressionTree? = null,
    secondChild: ExpressionTree? = null,
    content: AprlEvaluable?
) : BinaryTree<AprlEvaluable>(firstChild, secondChild, content) {
    
    private fun cauterize(content: AprlEvaluable?) {
        firstChild = null
        secondChild = null
        this.content = content
    }
    
    fun optimize() {
        (firstChild as? ExpressionTree)?.optimize()
        (secondChild as? ExpressionTree)?.optimize()
        if (content is AprlOperator) {
            val lhs = firstChild?.content
            val rhs = secondChild?.content
            val expressionString = "<EXPRESSION>" // TODO: get *ORIGINAL* expression as string
            val lhsString = "<LHS>" // TODO: get *ORIGINAL* lhs as string
            val rhsString = "<RHS>" // TODO: get *ORIGINAL* rhs as string
            if (rhs is AprlLiteral<*>) {
                if (lhs is AprlLiteral<*>) {
                    // lhs: constant, rhs: constant
                    /*when (val evaluated = (content as AprlOperator).applyOrNull(lhs.value, rhs.value)) {
                        is Int -> {
                            cauterize(AprlIntegerLiteral(evaluated.toInt()))
                        }
                        is Double -> {
                            cauterize(AprlFloatLiteral(evaluated.toDouble()))
                        }
                        else -> {
                            return
                        }
                    }*/
                    WARNING("Constant expression '$expressionString' can be evaluated to '${(content as AprlLiteral<*>).value}'")
                } else {
                    // lhs: non-constant, rhs: constant
                    when (content) {
                        is AprlBitwiseOperator -> {
                            if (rhs.value == 0 && lhs is AprlIntegerLiteral) {
                                when (content) {
                                    AprlBitwiseOperator.AND -> {
                                        cauterize(AprlIntegerLiteral(0))
                                        WARNING("Result of '$expressionString' is always '0'")
                                    }
                                    else -> {
                                        cauterize(lhs)
                                        WARNING("Result of '$expressionString' is always '$lhsString'")
                                    }
                                }
                            }
                        }
                        is AprlAdditiveOperator -> {
                            if (rhs.value == 0 || rhs.value == 0.0) {
                                cauterize(lhs)
                                WARNING("Result of '$expressionString' is always '$lhsString'")
                            }
                        }
                        is AprlMultiplicativeOperator -> {
                            if (rhs.value == 0 || rhs.value == 0.0) {
                                when (content) {
                                    AprlMultiplicativeOperator.MODULO, AprlMultiplicativeOperator.DIVIDE -> {
                                        ERROR("Division by zero")
                                    }
                                    AprlMultiplicativeOperator.MULTIPLY -> {
                                        if (rhs.value == 0.0) {
                                            cauterize(AprlFloatLiteral(0.0))
                                            WARNING("Result of '$expressionString' is always '0.0'")
                                        } else {
                                            cauterize(AprlIntegerLiteral(0))
                                            WARNING("Result of '$expressionString' is always '0'")
                                        }
                                    }
                                }
                            } else if (rhs.value == 1 || rhs.value == 1.0) {
                                when (content) {
                                    AprlMultiplicativeOperator.MODULO -> {
                                        if (rhs.value == 1.0) {
                                            cauterize(AprlFloatLiteral(0.0))
                                            WARNING("Result of '$expressionString' is always '0.0'")
                                        } else {
                                            cauterize(AprlIntegerLiteral(0))
                                            WARNING("Result of '$expressionString' is always '0'")
                                        }
                                    }
                                    AprlMultiplicativeOperator.MULTIPLY, AprlMultiplicativeOperator.DIVIDE -> {
                                        cauterize(lhs)
                                        WARNING("Result of '$expressionString' is always '$lhsString'")
                                    }
                                }
                            } else if (rhs is AprlIntegerLiteral && rhs.value > 0 && rhs.value and (rhs.value - 1) == 0) { // check if rhs.value is a power of 2
                                var rhsValue = rhs.value
                                var exp = 0
                                while (rhsValue and 1 == 0) {
                                    // shift the value as far right as possible and count the steps in order to determine exp
                                    rhsValue = rhsValue shr 1
                                    exp++
                                }
                                when (content) {
                                    AprlMultiplicativeOperator.MULTIPLY -> {
                                        // replace multiplication by 2**n with left shift by n
                                        secondChild!!.content = AprlIntegerLiteral(exp)
                                        content = AprlBitwiseOperator.SHL
                                    }
                                    AprlMultiplicativeOperator.DIVIDE -> {
                                        // replace division by 2**n with right shift by n
                                        secondChild!!.content = AprlIntegerLiteral(exp)
                                        content = AprlBitwiseOperator.SHR
                                    }
                                }
                            }
                        }
                        is AprlExponentialOperator -> {
                            if (rhs.value == 0 || rhs.value == 0.0) {
                                cauterize(AprlIntegerLiteral(1))
                                WARNING("Result of '$expressionString' is always '1'")
                            }
                        }
                    }
                }
            } else if (lhs is AprlLiteral<*>) {
                // lhs: constant, rhs: non-constant
                when (content) {
                    is AprlBitwiseOperator -> {
                        if (lhs.value == 0) {
                            when (content) {
                                AprlBitwiseOperator.AND -> {
                                    cauterize(AprlIntegerLiteral(0))
                                    WARNING("Result of '$expressionString' is always '0'")
                                }
                                else -> {
                                    cauterize(rhs)
                                    WARNING("Result of '$expressionString' is always '$rhsString'")
                                }
                            }
                        }
                    }
                    is AprlAdditiveOperator -> {
                        if (lhs.value == 0 || lhs.value == 0.0) {
                            cauterize(rhs)
                            WARNING("Result of '$expressionString' is always '$rhsString'")
                        }
                    }
                    is AprlMultiplicativeOperator -> {
                        if (lhs.value == 0 || lhs.value == 0.0) {
                            cauterize(AprlIntegerLiteral(0))
                            WARNING("Result of '$expressionString' is always '0'")
                        } else if (lhs.value == 1) {
                            when (content) {
                                AprlMultiplicativeOperator.MULTIPLY -> {
                                    cauterize(rhs)
                                    WARNING("Result of '$expressionString' is always '$rhsString'")
                                }
                            }
                        } else if (content == AprlMultiplicativeOperator.MULTIPLY && lhs is AprlIntegerLiteral && lhs.value > 0 && lhs.value and (lhs.value - 1) == 0) { // check if lhs.value is a power of 2
                            var lhsValue = lhs.value
                            var exp = 0
                            while (lhsValue and 1 == 0) {
                                // shift the value as far right as possible and count the steps in order to determine exp
                                lhsValue = lhsValue shr 1
                                exp++
                            }
                            // replace multiplication by 2**n with left shift by n
                            firstChild!!.content = rhs
                            secondChild!!.content = AprlIntegerLiteral(exp)
                            content = AprlBitwiseOperator.SHL
                        }
                    }
                    is AprlExponentialOperator -> {
                        if (lhs.value == 1) {
                            cauterize(AprlIntegerLiteral(1))
                            WARNING("Result of '$expressionString' is always '1'")
                        }
                    }
                }
            }
        } else if (content == null) {
            if (firstChild == null) {
                content = secondChild!!.content
                firstChild = secondChild!!.firstChild
                secondChild = secondChild!!.secondChild
            } else if (secondChild == null) {
                content = firstChild!!.content
                firstChild = firstChild!!.firstChild
                secondChild = firstChild!!.secondChild
            }
        }
    }
    
    companion object {
        fun leaf(content: AprlEvaluable): ExpressionTree {
            return ExpressionTree(null, null, content)
        }
    }
    
}
