package aprl.ir.operators

import aprl.grammar.AprlParser.ComparisonOperatorContext
import java.lang.IllegalStateException

sealed class AprlComparisonOperator(
    override val operatorSymbol: String,
    val isIntrinsic: Boolean
) : AprlOperator<ComparisonOperatorContext> {
    
    final override fun toString(): String {
        return operatorSymbol
    }
    
    class AprlLessThanOperator(
        override val context: ComparisonOperatorContext
    ) : AprlComparisonOperator("<", false)
    
    class AprlLessEqualOperator(
        override val context: ComparisonOperatorContext
    ) : AprlComparisonOperator("<=", false)
    
    class AprlGreaterThanOperator(
        override val context: ComparisonOperatorContext
    ) : AprlComparisonOperator(">", false)
    
    class AprlGreaterEqualOperator(
        override val context: ComparisonOperatorContext
    ) : AprlComparisonOperator(">=", false)
    
    class AprlEqualOperator(
        override val context: ComparisonOperatorContext
    ) : AprlComparisonOperator("==", true)
    
    class AprlNotEqualOperator(
        override val context: ComparisonOperatorContext
    ) : AprlComparisonOperator("!=", true)
    
    class AprlIdenticalOperator(
        override val context: ComparisonOperatorContext
    ) : AprlComparisonOperator("===", true)
    
    class AprlNotIdenticalOperator(
        override val context: ComparisonOperatorContext
    ) : AprlComparisonOperator("!==", true)
    
    companion object {
        fun fromNode(ctx: ComparisonOperatorContext): AprlComparisonOperator {
            return when {
                ctx.LANGLE() != null -> {
                    AprlLessThanOperator(ctx)
                }
                ctx.RANGLE() != null -> {
                    AprlGreaterThanOperator(ctx)
                }
                ctx.LANGLE_EQUAL() != null -> {
                    AprlLessEqualOperator(ctx)
                }
                ctx.RANGLE_EQUAL() != null -> {
                    AprlGreaterEqualOperator(ctx)
                }
                ctx.DOUBLE_EQUAL() != null -> {
                    AprlEqualOperator(ctx)
                }
                ctx.TRIPLE_EQUAL() != null -> {
                    AprlIdenticalOperator(ctx)
                }
                ctx.NOT_EQUAL() != null -> {
                    AprlNotEqualOperator(ctx)
                }
                ctx.NOT_DOUBLE_EQUAL() != null -> {
                    AprlNotIdenticalOperator(ctx)
                }
                else -> {
                    throw IllegalStateException("Expected ComparisonOperatorContext to be '<,' '>,' '<=,' '>=,' '==,' '!=,' '===' or '!==', found '${ctx.text}'")
                }
            }
        }
    }
    
}
