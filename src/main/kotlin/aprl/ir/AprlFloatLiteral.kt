package aprl.ir

import aprl.lang.Float

data class AprlFloatLiteral(
    override val value: Double
) : AprlLiteral<Double> {
    
    override val internalType: Class<Float> = Float::class.java
    
    override fun toString(): String {
        return value.toString()
    }
    
}
