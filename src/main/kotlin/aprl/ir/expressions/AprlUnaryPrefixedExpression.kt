package aprl.ir.expressions

import aprl.grammar.AprlParser.UnaryPrefixedExpressionContext
import aprl.ir.AprlNode
import aprl.ir.operators.AprlUnaryPrefixOperator
import aprl.util.ExpressionTree

data class AprlUnaryPrefixedExpression(
    var unaryPrefix: AprlUnaryPrefixOperator?,
    override val context: UnaryPrefixedExpressionContext
) : AprlNode<UnaryPrefixedExpressionContext> {
    
    var exponentialExpression: AprlExponentialExpression? = null
    
    override fun toString(): String {
        if (unaryPrefix == null) {
            return "$exponentialExpression"
        }
        return "${unaryPrefix!!.operatorSymbol}$exponentialExpression"
    }
    
    fun toTree(): ExpressionTree {
        return ExpressionTree(exponentialExpression?.toTree(), null, unaryPrefix)
    }
    
}
