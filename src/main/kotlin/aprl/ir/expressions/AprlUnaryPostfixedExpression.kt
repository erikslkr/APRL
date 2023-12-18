package aprl.ir.expressions

import aprl.grammar.AprlParser.UnaryPostfixedExpressionContext
import aprl.ir.AprlNode
import aprl.ir.AprlUnaryPostfix
import aprl.util.ExpressionTree

data class AprlUnaryPostfixedExpression(
    var unaryPostfix: AprlUnaryPostfix<*>?,
    var unaryPostfixedExpression: AprlUnaryPostfixedExpression?,
    var atomicExpression: AprlAtomicExpression?,
    override val context: UnaryPostfixedExpressionContext
) : AprlNode<UnaryPostfixedExpressionContext> {
    
    override fun toString(): String {
        if (unaryPostfix == null) {
            return "$atomicExpression"
        }
        return "$unaryPostfixedExpression $unaryPostfix"
    }
    
    fun toTree(): ExpressionTree {
        return ExpressionTree(unaryPostfixedExpression?.toTree() ?: atomicExpression?.toTree(), null, unaryPostfix)
    }
    
}
