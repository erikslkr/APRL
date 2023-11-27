package aprl.ir

import aprl.grammar.AprlParser.FunctionBodyContext

data class AprlFunctionBody(
    val statements: MutableList<AprlLocalStatement>,
    override val context: FunctionBodyContext
) : AprlNode<FunctionBodyContext> {
    
    override fun toString(): String {
        return statements.joinToString("\n", "{\n", "\n}") {
            it.toString().prependIndent("    ")
        }
    }
    
}
