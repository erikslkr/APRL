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
    
    override fun applyOrNull(lhs: Number, rhs: Number): Number {
        if (lhs is Double || rhs is Double) {
            return when (this) {
                PLUS -> lhs.toDouble() + rhs.toDouble()
                MINUS -> lhs.toDouble() - rhs.toDouble()
            }
        }
        return when (this) {
            PLUS -> lhs.toInt() + rhs.toInt()
            MINUS -> lhs.toInt() - rhs.toInt()
        }
    }
    
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
