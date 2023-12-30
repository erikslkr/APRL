package aprl.ir.expressions

import aprl.grammar.AprlParser.MultiplicativeExpressionContext
import aprl.ir.AprlNode
import aprl.ir.operators.AprlMultiplicativeOperator
import aprl.util.ExpressionTree

data class AprlMultiplicativeExpression(
    var multiplicativeOperator: AprlMultiplicativeOperator?,
    override val context: MultiplicativeExpressionContext
) : AprlNode<MultiplicativeExpressionContext> {
    
    var multiplicativeExpression: AprlMultiplicativeExpression? = null
    var unaryPrefixedExpression: AprlUnaryPrefixedExpression? = null
    
    override fun toString(): String {
        if (multiplicativeOperator == null) {
            return "$unaryPrefixedExpression"
        }
        return "$multiplicativeExpression $multiplicativeOperator $unaryPrefixedExpression"
    }
    
    fun toTree(): ExpressionTree {
        return ExpressionTree(multiplicativeExpression?.toTree(), unaryPrefixedExpression?.toTree(), multiplicativeOperator)
    }
    
}
