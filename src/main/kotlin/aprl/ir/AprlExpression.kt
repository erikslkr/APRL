package aprl.ir

import aprl.grammar.AprlParser.ExpressionContext
import aprl.ir.expressions.AprlDisjunctionExpression
import aprl.util.ExpressionTree

class AprlExpression(
    override val context: ExpressionContext
) : AprlNode<ExpressionContext> {
    
    lateinit var disjunctionExpression: AprlDisjunctionExpression
    
    override fun toString(): String {
        return "$disjunctionExpression"
    }
    
    fun toTree(): ExpressionTree {
        return disjunctionExpression.toTree()
    }
    
}
