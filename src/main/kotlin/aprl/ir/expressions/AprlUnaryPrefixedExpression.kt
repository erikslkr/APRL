package aprl.ir.expressions

import aprl.grammar.AprlParser.UnaryPrefixedExpressionContext
import aprl.ir.AprlNode
import aprl.ir.operators.AprlUnaryPrefixOperator
import aprl.util.ExpressionTree

data class AprlUnaryPrefixedExpression(
    var unaryPrefix: AprlUnaryPrefixOperator?,
    var exponentialExpression: AprlExponentialExpression?,
    override val context: UnaryPrefixedExpressionContext
) : AprlNode<UnaryPrefixedExpressionContext> {
    
    override fun toString(): String {
        return "${unaryPrefix?.operatorSymbol ?: ""}$exponentialExpression"
    }
    
    fun toTree(): ExpressionTree {
        return ExpressionTree(exponentialExpression?.toTree(), null, unaryPrefix)
    }
    
}
