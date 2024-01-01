package aprl.ir

import aprl.grammar.AprlParser.ReturnStatementContext

class AprlReturnStatement(
    override val context: ReturnStatementContext
) : AprlLocalStatement, AprlNode<ReturnStatementContext> {
    
    var expression: AprlExpression? = null
    
    override fun toString(): String {
        return "return${expression?.let { " $it"}}"
    }

    override fun isDefinitiveReturnStatement(): Boolean {
        return true
    }
    
}
