package aprl.ir

import aprl.grammar.AprlParser.WhileStatementContext

class AprlWhileStatement(
    override val context: WhileStatementContext
) : AprlNode<WhileStatementContext>, AprlLocalStatement {
    
    lateinit var expression: AprlExpression
    lateinit var statements: List<AprlLocalStatement>
    
    override fun toString(): String {
        return "while $expression {\n${statements.joinToString("\n").prependIndent()}}"
    }
    
    override fun isDefinitiveReturnStatement(): Boolean {
        return false
    }
    
}
