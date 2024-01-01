package aprl.ir.expressions

import aprl.grammar.AprlParser.DisjunctionExpressionContext
import aprl.ir.AprlNode
import aprl.ir.operators.AprlDisjunctionOperator
import aprl.util.ExpressionTree

class AprlDisjunctionExpression(
    override val context: DisjunctionExpressionContext
) : AprlNode<DisjunctionExpressionContext> {
    
    var conjunctionExpression: AprlConjunctionExpression? = null
    var disjunctionOperator: AprlDisjunctionOperator? = null
    var disjunctionExpression: AprlDisjunctionExpression? = null
    
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
