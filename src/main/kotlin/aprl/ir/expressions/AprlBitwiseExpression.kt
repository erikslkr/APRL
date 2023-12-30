package aprl.ir.expressions

import aprl.grammar.AprlParser.BitwiseExpressionContext
import aprl.ir.AprlNode
import aprl.ir.operators.AprlBitwiseOperator
import aprl.util.ExpressionTree

data class AprlBitwiseExpression(
    var bitwiseOperator: AprlBitwiseOperator?,
    override val context: BitwiseExpressionContext
) : AprlNode<BitwiseExpressionContext> {
    
    var bitwiseExpression: AprlBitwiseExpression? = null
    var additiveExpression: AprlAdditiveExpression? = null
    
    override fun toString(): String {
        if (bitwiseOperator == null) {
            return "$additiveExpression"
        }
        return "$bitwiseExpression $bitwiseOperator $additiveExpression"
    }
    
    fun toTree(): ExpressionTree {
        return ExpressionTree(bitwiseExpression?.toTree(), additiveExpression?.toTree(), bitwiseOperator)
    }
    
}
