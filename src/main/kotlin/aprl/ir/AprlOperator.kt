package aprl.ir

interface AprlOperator : AprlEvaluable {
    fun apply(lhs: Int, rhs: Int): Int
}
