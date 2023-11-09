package aprl.ir

import aprl.lang.Float
import aprl.lang.Number

data class AprlFloatLiteral(
    override val value: Double
) : AprlEvaluable, AprlLiteral<Double> {
    
    override val internalType: Class<out Number> = Float::class.java
    
    override fun toString(): String {
        return "$value"
    }
    
}
