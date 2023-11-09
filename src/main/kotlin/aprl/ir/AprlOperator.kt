package aprl.ir

interface AprlOperator : AprlEvaluable {
    val functionName: String
    val operatorSymbol: String
    
    fun applyOrNull(lhs: Number, rhs: Number): Number?
}
