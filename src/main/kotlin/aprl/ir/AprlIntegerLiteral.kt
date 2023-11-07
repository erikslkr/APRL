package aprl.ir

data class AprlIntegerLiteral(
    val value: Int
) : AprlEvaluable {
    override fun toString(): String {
        return "$value"
    }
}
