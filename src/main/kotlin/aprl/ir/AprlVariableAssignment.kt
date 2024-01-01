package aprl.ir

import aprl.grammar.AprlParser.VariableAssignmentContext
import aprl.ir.operators.AprlOverloadableBinaryOperator

class AprlVariableAssignment(
    val assignmentOperator: AprlOverloadableBinaryOperator<*>?,
    override val context: VariableAssignmentContext
) : AprlLocalStatement, AprlNode<VariableAssignmentContext> {
    
    lateinit var identifier: String
    lateinit var expression: AprlExpression
    
    override fun toString(): String {
        return "$identifier $assignmentOperator= $expression"
    }
    
    fun fullExpressionString(): String {
        return "$identifier $assignmentOperator $expression"
    }
    
    override fun isDefinitiveReturnStatement(): Boolean {
        return false
    }
    
}
