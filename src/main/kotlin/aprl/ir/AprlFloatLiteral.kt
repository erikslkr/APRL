package aprl.ir

import aprl.grammar.AprlParser
import aprl.lang.Float

data class AprlFloatLiteral(
    override val value: Double,
    override val context: AprlParser.LiteralContext
) : AprlLiteral<Double> {
    
    override val internalType: Class<Float> = Float::class.java
    
    override fun toString(): String {
        return value.toString()
    }
    
}
