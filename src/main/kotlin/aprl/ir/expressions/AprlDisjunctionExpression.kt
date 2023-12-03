package aprl.ir.expressions

import aprl.grammar.AprlParser.DisjunctionExpressionContext
import aprl.ir.AprlNode
import aprl.ir.operators.AprlDisjunctionOperator
import aprl.util.ExpressionTree

data class AprlDisjunctionExpression(
    var conjunctionExpression: AprlConjunctionExpression?,
    var disjunctionOperator: AprlDisjunctionOperator?,
    var disjunctionExpression: AprlDisjunctionExpression?,
    override val context: DisjunctionExpressionContext
) : AprlNode<DisjunctionExpressionContext> {

    override fun toString(): String {
        if (disjunctionExpression == null) {
            return "$conjunctionExpression"
        }
        return "$conjunctionExpression || $disjunctionExpression"
    }

    fun toTree(): ExpressionTree {
        return ExpressionTree(conjunctionExpression?.toTree(), disjunctionExpression?.toTree(), disjunctionOperator)
    }

}
