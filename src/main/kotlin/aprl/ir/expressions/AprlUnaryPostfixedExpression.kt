package aprl.ir.expressions

import aprl.grammar.AprlParser.UnaryPostfixedExpressionContext
import aprl.ir.AprlNode
import aprl.ir.AprlUnaryPostfix
import aprl.util.ExpressionTree

class AprlUnaryPostfixedExpression(
    override val context: UnaryPostfixedExpressionContext
) : AprlNode<UnaryPostfixedExpressionContext> {
    
    var unaryPostfix: AprlUnaryPostfix<*>? = null
    var unaryPostfixedExpression: AprlUnaryPostfixedExpression? = null
    var atomicExpression: AprlAtomicExpression? = null
    
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
