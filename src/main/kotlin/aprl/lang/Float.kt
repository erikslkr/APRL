@file:Suppress("FunctionName")

package aprl.lang

import kotlin.math.pow

data class Float(
    override val value: Double
) : Wrapper<Double>() {
    
    @Verbatim
    @OperatorFunction
    fun __plus__(other: Float): Float {
        return Float(value + other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __plus__(other: Int): Float {
        return Float(value + other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __minus__(other: Float): Float {
        return Float(value - other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __minus__(other: Int): Float {
        return Float(value - other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __multiply__(other: Float): Float {
        return Float(value * other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __multiply__(other: Int): Float {
        return Float(value * other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __divide__(other: Float): Float {
        return Float(value / other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __divide__(other: Int): Float {
        return Float(value / other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __floordiv__(other: Float): Int {
        return Int((value / other.value).toLong())
    }
    
    @Verbatim
    @OperatorFunction
    fun __floordiv__(other: Int): Int {
        return Int((value / other.value).toLong())
    }
    
    @Verbatim
    @OperatorFunction
    fun __mod__(other: Float): Float {
        return Float(value % other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __mod__(other: Int): Float {
        return Float(value % other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __pow__(other: Float): Float {
        return Float(value.pow(other.value))
    }
    
    @Verbatim
    @OperatorFunction
    fun __pow__(other: Int): Float {
        return Float(value.pow(other.value.toDouble()))
    }
    

}