package aprl.ir.expressions

import aprl.grammar.AprlParser.AdditiveExpressionContext
import aprl.ir.operators.AprlAdditiveOperator
import aprl.ir.AprlNode
import aprl.util.ExpressionTree

class AprlAdditiveExpression(
    private val additiveOperator: AprlAdditiveOperator?,
    override val context: AdditiveExpressionContext
) : AprlNode<AdditiveExpressionContext> {
    
    var additiveExpression: AprlAdditiveExpression? = null
    var multiplicativeExpression: AprlMultiplicativeExpression? = null
    
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
