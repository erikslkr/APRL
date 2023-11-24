package aprl.ir.expressions

import aprl.grammar.AprlParser
import aprl.grammar.AprlParser.MultiplicativeExpressionContext
import aprl.ir.AprlNode
import aprl.ir.operators.AprlMultiplicativeOperator
import aprl.ir.operators.AprlOverloadableOperator
import aprl.util.ExpressionTree

data class AprlMultiplicativeExpression(
    var multiplicativeExpression: AprlMultiplicativeExpression?,
    var multiplicativeOperator: AprlMultiplicativeOperator?,
    var exponentialExpression: AprlExponentialExpression?,
    override val context: MultiplicativeExpressionContext
) : AprlNode<MultiplicativeExpressionContext> {
    
    override fun toString(): String {
        if (multiplicativeOperator == null) {
            return "$exponentialExpression"
        }
        return "$multiplicativeExpression $multiplicativeOperator $exponentialExpression"
    }
    
    fun toTree(): ExpressionTree {
        return ExpressionTree(multiplicativeExpression?.toTree(), exponentialExpression?.toTree(), multiplicativeOperator)
    }
    
}
