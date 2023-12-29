package aprl.ir

import aprl.grammar.AprlParser.ConditionalStatementContext

class AprlConditionalStatement(
    override val context: ConditionalStatementContext
) : AprlNode<ConditionalStatementContext>, AprlLocalStatement {
    
    val ifStatements = mutableListOf<AprlIfStatement>()
    var elseStatement: AprlElseStatement? = null
    
    override fun toString(): String {
        return "${ifStatements.first()} ${ifStatements.drop(1).joinToString(" ") { "else $it" }}${elseStatement?.let { " $it" } ?: ""}"
    }
    
    override fun isDefinitiveReturnStatement(): Boolean {
        return ifStatements.all { it.isDefinitiveReturnStatement() } && elseStatement?.isDefinitiveReturnStatement() != false
    }
    
}
