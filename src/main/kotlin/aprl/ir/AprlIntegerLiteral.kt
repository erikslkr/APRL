package aprl.ir

import aprl.lang.Int

data class AprlIntegerLiteral(
    override val value: kotlin.Int // TODO: change Int to Long
) : AprlLiteral<kotlin.Int> {
    
    override val internalType: Class<Int> = Int::class.java
    
    override fun toString(): String {
        return "$value"
    }
    
}
