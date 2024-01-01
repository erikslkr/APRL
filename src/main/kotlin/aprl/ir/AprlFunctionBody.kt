package aprl.ir

import aprl.grammar.AprlParser.FunctionBodyContext

class AprlFunctionBody(
    override val context: FunctionBodyContext
) : AprlNode<FunctionBodyContext> {
    
    lateinit var statements: List<AprlLocalStatement>
    
    override fun toString(): String {
        return statements.joinToString("\n", "{\n", "\n}") {
            it.toString().prependIndent("    ")
        }
    }
    
}
