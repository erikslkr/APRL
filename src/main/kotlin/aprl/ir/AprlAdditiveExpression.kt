package aprl.ir

import aprl.grammar.AprlParser
import aprl.util.ExpressionTree

data class AprlAdditiveExpression(
    var additiveExpression: AprlAdditiveExpression?,
    var additiveOperator: AprlAdditiveOperator?,
    var multiplicativeExpression: AprlMultiplicativeExpression?
) : AprlEvaluable {
    override fun toString(): String {
        if (additiveOperator == null) {
            return "$multiplicativeExpression"
        }
        return "$additiveExpression $additiveOperator $multiplicativeExpression"
    }
    
    fun toTree(): ExpressionTree {
        return ExpressionTree(additiveExpression?.toTree(), multiplicativeExpression?.toTree(), additiveOperator)
    }
}

enum class AprlAdditiveOperator(
    override val functionName: String,
    override val operatorSymbol: String
) : AprlOperator {
    PLUS("__plus__", "+"),
    MINUS("__minus__", "-");
    
    companion object {
        fun fromNode(ctx: AprlParser.AdditiveOperatorContext): AprlAdditiveOperator {
            return if (ctx.PLUS() != null) {
                PLUS
            } else if (ctx.MINUS() != null) {
                MINUS
            } else {
                throw IllegalStateException("Expected AdditiveOperatorContext to be PLUS (+) or MINUS (-), found '${ctx.text}'")
            }
        }
    }
}
