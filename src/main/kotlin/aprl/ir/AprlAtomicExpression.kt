package aprl.ir

import aprl.util.ExpressionTree

data class AprlAtomicExpression(
    var parenthesizedExpression: AprlExpression?,
    var identifier: AprlIdentifier?,
    val integerLiteral: AprlIntegerLiteral?,
    val floatLiteral: AprlFloatLiteral?
): AprlEvaluable {
    override fun toString(): String {
        if (parenthesizedExpression != null) {
            return "($parenthesizedExpression)"
        } else if (identifier != null) {
            return "$identifier"
        } else if (integerLiteral != null) {
            return "$integerLiteral"
        } else if (floatLiteral != null) {
            return "$floatLiteral"
        }
        return "<INVALID_ATOMIC_EXPRESSION>"
    }
    
    fun toTree(): ExpressionTree {
        return parenthesizedExpression?.toTree() ?: ExpressionTree.leaf(identifier ?: integerLiteral ?: floatLiteral!!)
    }
}
