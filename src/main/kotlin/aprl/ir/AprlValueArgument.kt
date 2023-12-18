package aprl.ir

import aprl.grammar.AprlParser.ValueArgumentContext

data class AprlValueArgument(
    var expression: AprlExpression?,
    override val context: ValueArgumentContext
) : AprlNode<ValueArgumentContext> {
    
    override fun toString(): String {
        return expression.toString()
    }

}
