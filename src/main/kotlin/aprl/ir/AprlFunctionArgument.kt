package aprl.ir

import aprl.grammar.AprlParser.FunctionArgumentContext

data class AprlFunctionArgument(
    var name: String?,
    var type: AprlTypeReference?,
    override val context: FunctionArgumentContext
) : AprlNode<FunctionArgumentContext> {
    
    override fun toString(): String {
        return "$name: $type"
    }
    
}
