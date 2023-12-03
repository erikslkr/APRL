package aprl.ir.operators

import aprl.grammar.AprlParser.MultiplicativeOperatorContext

sealed class AprlMultiplicativeOperator(
    override val functionName: String,
    override val operatorSymbol: String
) : AprlOverloadableBinaryOperator<MultiplicativeOperatorContext> {
    
    class AprlMultiplyOperator(
        override val context: MultiplicativeOperatorContext
    ) : AprlMultiplicativeOperator("__multiply__", "*")
    
    class AprlDivideOperator(
        override val context: MultiplicativeOperatorContext
    ) : AprlMultiplicativeOperator("__divide__", "/")
    
    class AprlFloordivOperator(
        override val context: MultiplicativeOperatorContext
    ) : AprlMultiplicativeOperator("__floordiv__", "\\")
    
    class AprlModuloOperator(
        override val context: MultiplicativeOperatorContext
    ) : AprlMultiplicativeOperator("__mod__", "%")
    
    final override fun toString(): String {
        return operatorSymbol
    }
    
    companion object {
        fun fromNode(ctx: MultiplicativeOperatorContext): AprlMultiplicativeOperator {
            return when {
                ctx.ASTERISK() != null -> {
                    AprlMultiplyOperator(ctx)
                }
                ctx.SLASH() != null -> {
                    AprlDivideOperator(ctx)
                }
                ctx.BACKSLASH() != null -> {
                    AprlFloordivOperator(ctx)
                }
                ctx.PERCENT() != null -> {
                    AprlModuloOperator(ctx)
                }
                else -> {
                    throw IllegalStateException("MultiplicativeOperatorContext was expected to be ASTERISK (*), SLASH (/) or PERCENT (%), found '${ctx.text}'")
                }
            }
        }
    }
    
}
