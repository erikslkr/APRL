package aprl.ir.expressions

import aprl.grammar.AprlParser.ExponentialExpressionContext
import aprl.ir.AprlNode
import aprl.ir.operators.AprlExponentialOperator
import aprl.util.ExpressionTree

class AprlExponentialExpression(
    private val exponentialOperator: AprlExponentialOperator?,
    override val context: ExponentialExpressionContext
) : AprlNode<ExponentialExpressionContext> {
    
    var exponentialExpression: AprlExponentialExpression? = null
    var unaryPostfixedExpression: AprlUnaryPostfixedExpression? = null
    
    override fun toString(): String {
        if (exponentialOperator == null) {
            return "$unaryPostfixedExpression"
        }
        return "$exponentialExpression $exponentialOperator $unaryPostfixedExpression"
    }
    
    fun toTree(): ExpressionTree {
        return ExpressionTree(exponentialExpression?.toTree(), unaryPostfixedExpression?.toTree(), exponentialOperator)
    }
    
}
