package aprl.ir

import aprl.util.ExpressionTree

data class AprlExpression(
    var bitwiseExpression: AprlBitwiseExpression?
) : AprlEvaluable {
    override fun toString(): String {
        return "$bitwiseExpression"
    }
    
    fun toTree(): ExpressionTree {
        return bitwiseExpression!!.toTree()
    }
}
