package aprl.ir

import aprl.grammar.AprlParser.IdentifierContext

data class AprlIdentifier(
    override val context: IdentifierContext
) : AprlNode<IdentifierContext> {
    
    val identifiers: MutableList<String> = mutableListOf()
    
    override fun toString(): String {
        return identifiers.joinToString(".")
    }
    
}
