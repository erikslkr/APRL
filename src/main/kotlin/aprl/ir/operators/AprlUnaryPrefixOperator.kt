package aprl.ir.operators

import aprl.grammar.AprlParser.UnaryPrefixContext

sealed class AprlUnaryPrefixOperator(
    override val operatorSymbol: String,
    override val functionName: String
) : AprlOverloadableUnaryOperator<UnaryPrefixContext> {
    
    final override fun toString(): String {
        return operatorSymbol
    }
    
    class AprlNegateOperator(
        override val context: UnaryPrefixContext
    ) : AprlUnaryPrefixOperator("-", "__negate__")
    
    class AprlNotOperator(
        override val context: UnaryPrefixContext
    ) : AprlUnaryPrefixOperator("!", "__not__")
    
    class AprlInverseOperator(
        override val context: UnaryPrefixContext
    ) : AprlUnaryPrefixOperator("~", "__inverse__")
    
    companion object {
        fun fromNode(ctx: UnaryPrefixContext): AprlUnaryPrefixOperator {
            return when {
                ctx.MINUS() != null -> {
                    AprlNegateOperator(ctx)
                }
                ctx.EXCL() != null -> {
                    AprlNotOperator(ctx)
                }
                ctx.TILDE() != null -> {
                    AprlInverseOperator(ctx)
                }
                else -> {
                    throw IllegalStateException("UnaryPrefixContext was expected to be MINUS (-), EXCL (!) or TILDE (~), found '${ctx.text}'")
                }
            }
        }
    }
    
}
