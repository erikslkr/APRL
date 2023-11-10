package aprl.ir

interface AprlOperator : AprlEvaluable {
    val functionName: String
    val operatorSymbol: String
    
    // TODO: Change parameters and return type to `Any` (operators should now be defined on all types, not only numbers anymore)
    fun applyOrNull(lhs: Number, rhs: Number): Number?
}
