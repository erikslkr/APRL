package aprl.ir

import aprl.grammar.AprlParser.ReturnStatementContext

data class AprlReturnStatement(
    var expression: AprlExpression?,
    override val context: ReturnStatementContext
) : AprlLocalStatement, AprlNode<ReturnStatementContext> {
    
    override fun toString(): String {
        return "return${expression?.let { " $it"}}"
    }
    
}
