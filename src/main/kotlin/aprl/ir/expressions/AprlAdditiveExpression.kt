package aprl.ir.expressions

import aprl.grammar.AprlParser.AdditiveExpressionContext
import aprl.ir.operators.AprlAdditiveOperator
import aprl.ir.AprlNode
import aprl.util.ExpressionTree

data class AprlAdditiveExpression(
    var additiveExpression: AprlAdditiveExpression?,
    var additiveOperator: AprlAdditiveOperator?,
    var multiplicativeExpression: AprlMultiplicativeExpression?,
    override val context: AdditiveExpressionContext
) : AprlNode<AdditiveExpressionContext> {
    
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
