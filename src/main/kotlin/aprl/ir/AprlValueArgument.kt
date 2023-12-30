package aprl.ir

import aprl.grammar.AprlParser.ValueArgumentContext

data class AprlValueArgument(
    override val context: ValueArgumentContext
) : AprlNode<ValueArgumentContext> {
    
    lateinit var expression: AprlExpression
    
    override fun toString(): String {
        return expression.toString()
    }
    
}
