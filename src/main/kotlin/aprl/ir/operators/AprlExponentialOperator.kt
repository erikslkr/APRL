package aprl.ir.operators

import aprl.grammar.AprlParser.ExponentialOperatorContext

sealed class AprlExponentialOperator(
    override val functionName: String,
    override val operatorSymbol: String
) : AprlOverloadableBinaryOperator<ExponentialOperatorContext> {
    
    class AprlPowerOperator(
        override val context: ExponentialOperatorContext
    ) : AprlExponentialOperator("__pow__", "**")
    
    final override fun toString(): String {
        return operatorSymbol
    }
    
    companion object {
        fun fromNode(ctx: ExponentialOperatorContext): AprlExponentialOperator {
            return when {
                ctx.DOUBLE_ASTERISK() != null -> {
                    AprlPowerOperator(ctx)
                }
                else -> {
                    throw IllegalStateException("Expected ExponentialOperatorContext to be DOUBLE_ASTERISK (**), found '${ctx.text}'")
                }
            }
        }
    }
    
}
