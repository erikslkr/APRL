package aprl.ir

interface AprlLiteral<T> : AprlEvaluable {
    val value: T
    val internalType: Class<*>

    override fun toString(): String
}
