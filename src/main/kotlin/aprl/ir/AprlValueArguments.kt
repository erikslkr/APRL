package aprl.ir

import aprl.grammar.AprlParser.ValueArgumentsContext

class AprlValueArguments(
    override val context: ValueArgumentsContext
) : AprlUnaryPostfix<ValueArgumentsContext> {
    
    val valueArguments = mutableListOf<AprlValueArgument>()
    
    override fun toString(): String {
        return valueArguments.joinToString(", ", "(", ")")
    }
    
}
