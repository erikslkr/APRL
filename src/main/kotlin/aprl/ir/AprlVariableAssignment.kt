package aprl.ir

import aprl.grammar.AprlParser.VariableAssignmentContext

data class AprlVariableAssignment(
    var identifier: String?,
    var expression: AprlExpression?,
    override val context: VariableAssignmentContext
) : AprlStatement, AprlNode<VariableAssignmentContext> {
    
    override fun toString(): String {
        return "$identifier = $expression"
    }
    
}
