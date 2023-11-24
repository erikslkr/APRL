package aprl.ir.operators

import aprl.grammar.AprlParser.ComparisonOperatorContext
import java.lang.IllegalStateException

sealed class AprlComparisonOperator(
    override val operatorSymbol: String
) : AprlOperator<ComparisonOperatorContext> {
    
    final override fun toString(): String {
        return operatorSymbol
    }
    
    class AprlLessThanOperator(
        override val context: ComparisonOperatorContext
    ) : AprlComparisonOperator("<")
    
    class AprlLessEqualOperator(
        override val context: ComparisonOperatorContext
    ) : AprlComparisonOperator("<=")
    
    class AprlGreaterThanOperator(
        override val context: ComparisonOperatorContext
    ) : AprlComparisonOperator(">")
    
    class AprlGreaterEqualOperator(
        override val context: ComparisonOperatorContext
    ) : AprlComparisonOperator(">=")
    
    class AprlEqualOperator(
        override val context: ComparisonOperatorContext
    ) : AprlComparisonOperator("==")
    
    class AprlNotEqualOperator(
        override val context: ComparisonOperatorContext
    ) : AprlComparisonOperator("!=")
    
    class AprlIdenticalOperator(
        override val context: ComparisonOperatorContext
    ) : AprlComparisonOperator("===")
    
    class AprlNotIdenticalOperator(
        override val context: ComparisonOperatorContext
    ) : AprlComparisonOperator("!==")
    
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
