package aprl.ir

import aprl.grammar.AprlParser
import aprl.util.ExpressionTree
import kotlin.math.pow

data class AprlExponentialExpression(
    var exponentialExpression: AprlExponentialExpression?,
    val exponentialOperator: AprlExponentialOperator?,
    var atomicExpression: AprlAtomicExpression?
) : AprlEvaluable {
    override fun toString(): String {
        if (exponentialOperator == null) {
            return "$atomicExpression"
        }
        return "$exponentialExpression $exponentialOperator $atomicExpression"
    }
    
    fun toTree(): ExpressionTree {
        return ExpressionTree(exponentialExpression?.toTree(), atomicExpression?.toTree(), exponentialOperator)
    }
}

enum class AprlExponentialOperator(
    override val functionName: String,
    override val operatorSymbol: String
) : AprlOperator {
    DOUBLE_ASTERISK("__pow__", "**");
    
    override fun applyOrNull(lhs: Number, rhs: Number): Number {
        return if (lhs is Double || rhs is Double) {
            when (this) {
                DOUBLE_ASTERISK -> lhs.toDouble().pow(rhs.toDouble())
            }
        } else {
            when (this) {
                DOUBLE_ASTERISK -> lhs.toDouble().pow(rhs.toDouble()).toInt()
            }
        }
    }
    
    companion object {
        fun fromNode(ctx: AprlParser.ExponentialOperatorContext): AprlExponentialOperator {
            return if (ctx.DOUBLE_ASTERISK() != null) {
                DOUBLE_ASTERISK
            } else {
                throw IllegalStateException("Expected ExponentialOperatorContext to be DOUBLE_ASTERISK (**), found '${ctx.text}'")
            }
        }
    }
}
