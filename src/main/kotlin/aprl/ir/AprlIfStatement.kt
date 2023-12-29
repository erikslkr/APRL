package aprl.ir

import aprl.grammar.AprlParser.IfStatementContext

class AprlIfStatement(
    val conditionalKeyword: ConditionalKeyword,
    override val context: IfStatementContext
) : AprlNode<IfStatementContext> {
    
    lateinit var expression: AprlExpression
    lateinit var statements: List<AprlLocalStatement>
    
    override fun toString(): String {
        return "if $expression {\n${statements.joinToString("\n").prependIndent()}}"
    }
    
    fun isDefinitiveReturnStatement(): Boolean {
        return statements.any { it.isDefinitiveReturnStatement() }
    }
    
}

enum class ConditionalKeyword {
    IF,
    UNLESS
}
