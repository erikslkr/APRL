package aprl.ir.operators

import aprl.grammar.AprlParser.BitwiseOperatorContext

sealed class AprlBitwiseOperator(
    override val functionName: String,
    override val operatorSymbol: String
) : AprlOverloadableBinaryOperator<BitwiseOperatorContext> {
    
    class AprlAndOperator(
        override val context: BitwiseOperatorContext
    ) : AprlBitwiseOperator("__and__", "&")
    
    class AprlOrOperator(
        override val context: BitwiseOperatorContext
    ) : AprlBitwiseOperator("__or__", "|")
    
    class AprlXorOperator(
        override val context: BitwiseOperatorContext
    ) : AprlBitwiseOperator("__xor__", "^")
    
    class AprlShlOperator(
        override val context: BitwiseOperatorContext
    ): AprlBitwiseOperator("__shl__", "<<")
    
    class AprlShrOperator(
        override val context: BitwiseOperatorContext
    ) : AprlBitwiseOperator("__shr__", ">>")
    
    class AprlUshrOperator(
        override val context: BitwiseOperatorContext
    ) : AprlBitwiseOperator("__ushr__", ">>>")
    
    final override fun toString(): String {
        return operatorSymbol
    }
    
    companion object {
        fun fromNode(ctx: BitwiseOperatorContext): AprlBitwiseOperator {
            return when {
                ctx.AND() != null -> {
                    AprlAndOperator(ctx)
                }
                ctx.OR() != null -> {
                    AprlOrOperator(ctx)
                }
                ctx.XOR() != null -> {
                    AprlXorOperator(ctx)
                }
                ctx.SHL() != null -> {
                    AprlShlOperator(ctx)
                }
                ctx.SHR() != null -> {
                    AprlShrOperator(ctx)
                }
                ctx.USHR() != null -> {
                    AprlUshrOperator(ctx)
                }
                else -> {
                    throw IllegalStateException("Expected BitwiseOperatorContext to be AND (&), OR (|), XOR (^), SHL (<<), SHR (>>) or USHR (>>>), found '${ctx.text}'")
                }
            }
        }
    }
    
}
