package aprl.ir.expressions

import aprl.grammar.AprlParser.ExponentialExpressionContext
import aprl.ir.AprlNode
import aprl.ir.operators.AprlExponentialOperator
import aprl.util.ExpressionTree

data class AprlExponentialExpression(
    var exponentialExpression: AprlExponentialExpression?,
    val exponentialOperator: AprlExponentialOperator?,
    var atomicExpression: AprlAtomicExpression?,
    override val context: ExponentialExpressionContext
) : AprlNode<ExponentialExpressionContext> {
    
    override fun toString(): String {
        if (exponentialOperator == null) {
            return "$atomicExpression"
        }
        return "$exponentialExpression $exponentialOperator $atomicExpression"
    }
    
    fun toTree(): ExpressionTree {
        return ExpressionTree(exponentialExpression?.toTree(), atomicExpression?.toTree(), exponentialOperator)
    }
    
}
