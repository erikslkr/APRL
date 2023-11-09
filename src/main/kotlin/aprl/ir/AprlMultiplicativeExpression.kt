package aprl.ir

import aprl.grammar.AprlParser
import aprl.util.ExpressionTree

data class AprlMultiplicativeExpression(
    var multiplicativeExpression: AprlMultiplicativeExpression?,
    var multiplicativeOperator: AprlMultiplicativeOperator?,
    var exponentialExpression: AprlExponentialExpression?
) : AprlEvaluable {
    override fun toString(): String {
        if (multiplicativeOperator == null) {
            return "$exponentialExpression"
        }
        return "$multiplicativeExpression $multiplicativeOperator $exponentialExpression"
    }
    
    fun toTree(): ExpressionTree {
        return ExpressionTree(multiplicativeExpression?.toTree(), exponentialExpression?.toTree(), multiplicativeOperator)
    }
}

enum class AprlMultiplicativeOperator(
    override val functionName: String,
    override val operatorSymbol: String
) : AprlOperator {
    MULTIPLY("__multiply__", "*"),
    DIVIDE("__divide__", "/"),
    FLOORDIV("__floordiv__", "\\"),
    MODULO("__mod__", "%");
    
    override fun applyOrNull(lhs: Number, rhs: Number): Number {
        return if (lhs is Double || rhs is Double) {
            when (this) {
                MULTIPLY -> lhs.toDouble() * rhs.toDouble()
                DIVIDE -> lhs.toDouble() / rhs.toDouble()
                FLOORDIV -> (lhs.toDouble() / rhs.toDouble()).toInt()
                MODULO -> lhs.toDouble() % rhs.toDouble()
            }
        } else { // lhs: Int, rhs: Int
            when (this) {
                MULTIPLY -> lhs.toInt() * rhs.toInt()
                DIVIDE -> lhs.toDouble() / rhs.toDouble()
                FLOORDIV -> lhs.toInt() / rhs.toInt()
                MODULO -> lhs.toInt() % rhs.toInt()
            }
        }
    }
    
    companion object {
        fun fromNode(ctx: AprlParser.MultiplicativeOperatorContext): AprlMultiplicativeOperator {
            return if (ctx.ASTERISK() != null) {
                MULTIPLY
            } else if (ctx.SLASH() != null) {
                DIVIDE
            } else if (ctx.BACKSLASH() != null) {
                FLOORDIV
            } else if (ctx.PERCENT() != null) {
                MODULO
            } else {
                throw IllegalStateException("MultiplicativeOperatorContext was expected to be ASTERISK (*), SLASH (/) or PERCENT (%), found '${ctx.text}'")
            }
        }
    }
}
