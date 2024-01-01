package aprl.ir

import aprl.grammar.AprlParser.VariableAssignmentContext

class AprlVariableAssignment(
    override val context: VariableAssignmentContext
) : AprlLocalStatement, AprlNode<VariableAssignmentContext> {
    
    lateinit var identifier: String
    lateinit var expression: AprlExpression
    
    override fun toString(): String {
        return "$identifier = $expression"
    }

    override fun isDefinitiveReturnStatement(): Boolean {
        return false
    }
    
}
