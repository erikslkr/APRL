package aprl.ir.operators

import aprl.grammar.AprlParser.AdditiveOperatorContext

sealed class AprlAdditiveOperator(
    override val functionName: String,
    override val operatorSymbol: String
) : AprlOverloadableBinaryOperator<AdditiveOperatorContext> {
    
    class AprlPlusOperator(
        override val context: AdditiveOperatorContext
    ) : AprlAdditiveOperator("__plus__", "+")
    
    class AprlMinusOperator(
        override val context: AdditiveOperatorContext
    ) : AprlAdditiveOperator("__minus__", "-")
    
    final override fun toString(): String {
        return operatorSymbol
    }
    
    companion object {
        fun fromNode(ctx: AdditiveOperatorContext): AprlAdditiveOperator {
            return when {
                ctx.PLUS() != null -> {
                    AprlPlusOperator(ctx)
                }
                ctx.MINUS() != null -> {
                    AprlMinusOperator(ctx)
                }
                else -> {
                    throw IllegalStateException("Expected AdditiveOperatorContext to be PLUS (+) or MINUS (-), found '${ctx.text}'")
                }
            }
        }
    }
    
}
