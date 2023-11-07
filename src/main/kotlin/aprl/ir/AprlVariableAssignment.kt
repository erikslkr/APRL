package aprl.ir

data class AprlVariableAssignment(
    var identifier: String?,
    var expression: AprlExpression?
) : AprlStatement {
    override fun toString(): String {
        return "$identifier = $expression"
    }
}
