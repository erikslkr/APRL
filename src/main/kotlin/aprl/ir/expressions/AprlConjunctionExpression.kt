package aprl.ir.expressions

import aprl.grammar.AprlParser.ConjunctionExpressionContext
import aprl.ir.AprlNode
import aprl.ir.operators.AprlConjunctionOperator
import aprl.util.ExpressionTree

data class AprlConjunctionExpression(
    override val context: ConjunctionExpressionContext
) : AprlNode<ConjunctionExpressionContext> {
    
    var comparisonExpression: AprlComparisonExpression? = null
    var conjunctionOperator: AprlConjunctionOperator? = null
    var conjunctionExpression: AprlConjunctionExpression? = null
    
    override fun toString(): String {
        if (conjunctionExpression == null) {
            return "$comparisonExpression"
        }
        return "$comparisonExpression && $conjunctionExpression"
    }
    
    fun toTree(): ExpressionTree {
        return ExpressionTree(comparisonExpression?.toTree(), conjunctionExpression?.toTree(), conjunctionOperator)
    }
    
}
