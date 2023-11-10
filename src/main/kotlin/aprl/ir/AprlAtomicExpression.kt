package aprl.ir

import aprl.util.ExpressionTree

data class AprlAtomicExpression(
    var parenthesizedExpression: AprlExpression?,
    var identifier: AprlIdentifier?,
    var literal: AprlLiteral<*>?
): AprlEvaluable {
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
