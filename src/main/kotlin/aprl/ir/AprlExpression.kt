package aprl.ir

import aprl.grammar.AprlParser.ExpressionContext
import aprl.ir.expressions.AprlDisjunctionExpression
import aprl.util.ExpressionTree

data class AprlExpression(
    var disjunctionExpression: AprlDisjunctionExpression?,
    override val context: ExpressionContext
) : AprlNode<ExpressionContext> {
    
    override fun toString(): String {
        return "$disjunctionExpression"
    }
    
    fun toTree(): ExpressionTree {
        return disjunctionExpression!!.toTree()
    }
    
}
