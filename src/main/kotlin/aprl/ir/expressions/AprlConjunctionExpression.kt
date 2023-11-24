package aprl.ir.expressions

import aprl.grammar.AprlParser.ConjunctionExpressionContext
import aprl.ir.AprlNode
import aprl.ir.operators.AprlConjunctionOperator
import aprl.ir.operators.AprlOperator
import aprl.util.ExpressionTree

data class AprlConjunctionExpression(
    var comparisonExpression: AprlComparisonExpression?,
    var conjunctionOperator: AprlConjunctionOperator?,
    var conjunctionExpression: AprlConjunctionExpression?,
    override val context: ConjunctionExpressionContext
) : AprlNode<ConjunctionExpressionContext> {

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
