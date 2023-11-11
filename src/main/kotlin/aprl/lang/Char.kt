@file:Suppress("FunctionName")

package aprl.lang

data class Char(
    override val value: kotlin.Char
) : Wrapper<kotlin.Char>() {
    
    @Verbatim
    @OperatorFunction
    fun __plus__(other: String): String {
        return String(value + other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __plus__(other: Char): String {
        return String(value.toString() + other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __plus__(other: Int): String {
        return String(value.toString() + other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __plus__(other: Float): String {
        return String(value.toString() + other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __multiply__(other: Int): String {
        return String(value.toString().repeat(other.value.toInt()))
    }

}