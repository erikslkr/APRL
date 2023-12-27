package aprl.ir

import aprl.grammar.AprlParser.VariableAssignmentContext

data class AprlVariableAssignment(
    var identifier: String?,
    var expression: AprlExpression?,
    override val context: VariableAssignmentContext
) : AprlLocalStatement, AprlNode<VariableAssignmentContext> {
    
    override fun toString(): String {
        return "$identifier = $expression"
    }

    override fun isDefinitiveReturnStatement(): Boolean {
        return false
    }
    
}
