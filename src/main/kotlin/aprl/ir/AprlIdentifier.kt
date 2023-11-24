package aprl.ir

import aprl.grammar.AprlParser.IdentifierContext

data class AprlIdentifier(
    val identifiers: MutableList<String> = mutableListOf(),
    override val context: IdentifierContext
) : AprlNode<IdentifierContext> {
    
    override fun toString(): String {
        return identifiers.joinToString(".")
    }
    
}
