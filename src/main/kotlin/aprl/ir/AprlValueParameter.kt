package aprl.ir

import aprl.grammar.AprlParser.ValueParameterContext

class AprlValueParameter(
    override val context: ValueParameterContext
) : AprlNode<ValueParameterContext> {
    
    lateinit var name: String
    lateinit var type: AprlTypeReference
    
    override fun toString(): String {
        return "$name: $type"
    }
    
}
