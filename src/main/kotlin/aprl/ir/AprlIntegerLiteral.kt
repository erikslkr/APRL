package aprl.ir

import aprl.lang.Number

data class AprlIntegerLiteral(
    override val value: Int // TODO: change Int to Long
) : AprlEvaluable, AprlLiteral<Int> {
    
    override val internalType: Class<out Number> = aprl.lang.Int::class.java
    
    override fun toString(): String {
        return "$value"
    }
    
}
