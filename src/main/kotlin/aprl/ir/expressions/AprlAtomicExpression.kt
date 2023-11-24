package aprl.ir.expressions

import aprl.grammar.AprlParser.AtomicExpressionContext
import aprl.ir.AprlExpression
import aprl.ir.AprlIdentifier
import aprl.ir.AprlLiteral
import aprl.ir.AprlNode
import aprl.util.ExpressionTree

data class AprlAtomicExpression(
    var parenthesizedExpression: AprlExpression?,
    var identifier: AprlIdentifier?,
    var literal: AprlLiteral<*>?,
    override val context: AtomicExpressionContext
): AprlNode<AtomicExpressionContext> {
    
    override fun toString(): String {
        if (parenthesizedExpression != null) {
            return "($parenthesizedExpression)"
        } else if (identifier != null) {
            return "$identifier"
        } else if (literal != null) {
            return "$literal"
        }
        return "<INVALID_ATOMIC_EXPRESSION>"
    }
    
    fun toTree(): ExpressionTree {
        return parenthesizedExpression?.toTree() ?: ExpressionTree.leaf(identifier ?: literal!!)
    }
    
}
