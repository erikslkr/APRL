package aprl.ir.expressions

import aprl.grammar.AprlParser.ComparisonExpressionContext
import aprl.ir.AprlNode
import aprl.ir.operators.AprlComparisonOperator
import aprl.util.ExpressionTree

data class AprlComparisonExpression(
    override val context: ComparisonExpressionContext
) : AprlNode<ComparisonExpressionContext> {
    
    var bitwiseExpression: AprlBitwiseExpression? = null
    var comparisonExpression: AprlComparisonExpression? = null
    var comparisonOperator: AprlComparisonOperator? = null
    
    override fun toString(): String {
        if (comparisonOperator == null) {
            return "$bitwiseExpression"
        }
        return "$bitwiseExpression $comparisonOperator $comparisonExpression"
    }
    
    fun toTree(): ExpressionTree {
        return ExpressionTree(bitwiseExpression?.toTree(), comparisonExpression?.toTree(), comparisonOperator)
    }
    
}
