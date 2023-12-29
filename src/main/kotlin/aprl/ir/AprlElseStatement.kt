package aprl.ir

import aprl.grammar.AprlParser.ElseStatementContext

class AprlElseStatement(
    override val context: ElseStatementContext
) : AprlNode<ElseStatementContext> {
    
    lateinit var statements: List<AprlLocalStatement>
    
    override fun toString(): String {
        return "else {\n${statements.joinToString("\n").prependIndent()}}"
    }
    
    fun isDefinitiveReturnStatement(): Boolean {
        return statements.any { it.isDefinitiveReturnStatement() }
    }
    
}
