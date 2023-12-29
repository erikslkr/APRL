@file:Suppress("FunctionName")

package aprl.lang

import kotlin.math.pow

data class Int(
    override val value: Long
) : Wrapper<Long>() {
    
    fun compareTo(other: Int): Int {
        return Int(value.compareTo(other.value).toLong())
    }
    
    fun compareTo(other: Float): Int {
        return Int(value.compareTo(other.value).toLong())
    }
    
    fun __int__(): kotlin.Int {
        return value.toInt()
    }
    
    @Verbatim
    @OperatorFunction
    fun __not__(): Int {
        return Int(value.inv())
    }
    
    @Verbatim
    @OperatorFunction
    fun __negate__(): Int {
        return Int(-value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __inverse__(): Int {
        return Int(value.inv())
    }
    
    @Verbatim
    @OperatorFunction
    fun __plus__(other: Int): Int {
        return Int(value + other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __plus__(other: Float): Float {
        return Float(value + other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __minus__(other: Int): Int {
        return Int(value - other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __minus__(other: Float): Float {
        return Float(value - other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __multiply__(other: Int): Int {
        return Int(value * other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __multiply__(other: Float): Float {
        return Float(value * other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __multiply__(other: String): String {
        return String(other.value.repeat(value.toInt()))
    }
    
    @Verbatim
    @OperatorFunction
    fun __divide__(other: Int): Float {
        return Float(value.toDouble() / other.value.toDouble())
    }
    
    @Verbatim
    @OperatorFunction
    fun __divide__(other: Float): Float {
        return Float(value.toDouble() / other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __floordiv__(other: Int): Int {
        return Int(value / other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __floordiv__(other: Float): Int {
        return Int((value.toDouble() / other.value).toLong())
    }
    
    @Verbatim
    @OperatorFunction
    fun __mod__(other: Int): Int {
        return Int(value % other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __mod__(other: Float): Float {
        return Float(value % other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __pow__(other: Int): Int {
        return Int(value.toDouble().pow(other.value.toDouble()).toLong())
    }
    
    @Verbatim
    @OperatorFunction
    fun __pow__(other: Float): Float {
        return Float(value.toDouble().pow(other.value))
    }
    
    @Verbatim
    @OperatorFunction
    fun __and__(other: Int): Int {
        return Int(value and other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __or__(other: Int): Int {
        return Int(value or other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __xor__(other: Int): Int {
        return Int(value xor other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __shl__(other: Int): Int {
        return Int(value shl other.value.toInt())
    }
    
    @Verbatim
    @OperatorFunction
    fun __shr__(other: Int): Int {
        return Int(value shr other.value.toInt())
    }
    
    @Verbatim
    @OperatorFunction
    fun __ushr__(other: Int): Int {
        return Int(value ushr other.value.toInt())
    }
    
}
