package aprl.ir.expressions

import aprl.grammar.AprlParser.ComparisonExpressionContext
import aprl.grammar.AprlParser.ComparisonOperatorContext
import aprl.ir.AprlNode
import aprl.ir.operators.AprlComparisonOperator
import aprl.ir.operators.AprlOperator
import aprl.util.ExpressionTree
import java.lang.IllegalStateException

data class AprlComparisonExpression(
    var bitwiseExpression: AprlBitwiseExpression?,
    var comparisonOperator: AprlComparisonOperator?,
    var comparisonExpression: AprlComparisonExpression?,
    override val context: ComparisonExpressionContext
) : AprlNode<ComparisonExpressionContext> {

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
