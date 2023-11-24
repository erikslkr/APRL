package aprl.ir

import aprl.grammar.AprlParser.LiteralContext
import aprl.lang.Int

data class AprlIntegerLiteral(
    override val value: Long
) : AprlLiteral<Long> {
    
    override val internalType: Class<Int> = Int::class.java
    
    override fun toString(): String {
        return value.toString()
    }
    
}
