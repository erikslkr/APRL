package aprl.ir.expressions

import aprl.grammar.AprlParser
import aprl.grammar.AprlParser.BitwiseExpressionContext
import aprl.ir.AprlNode
import aprl.ir.operators.AprlBitwiseOperator
import aprl.ir.operators.AprlOverloadableOperator
import aprl.util.ExpressionTree

data class AprlBitwiseExpression(
    var bitwiseExpression: AprlBitwiseExpression?,
    var bitwiseOperator: AprlBitwiseOperator?,
    var additiveExpression: AprlAdditiveExpression?,
    override val context: BitwiseExpressionContext
) : AprlNode<BitwiseExpressionContext> {
    
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
