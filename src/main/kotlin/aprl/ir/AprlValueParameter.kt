package aprl.ir

import aprl.grammar.AprlParser.ValueParameterContext

data class AprlValueParameter(
    var name: String?,
    var type: AprlTypeReference?,
    override val context: ValueParameterContext
) : AprlNode<ValueParameterContext> {
    
    override fun toString(): String {
        return "$name: $type"
    }
    
}
