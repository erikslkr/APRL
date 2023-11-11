@file:Suppress("FunctionName")

package aprl.lang

data class String(
    override val value: kotlin.String
) : Wrapper<kotlin.String>() {
    
    @Verbatim
    @OperatorFunction
    fun __plus__(other: String): String {
        return String(value + other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __plus__(other: Char): String {
        return String(value + other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __plus__(other: Int): String {
        return String(value + other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __plus__(other: Float): String {
        return String(value + other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __multiply__(other: Int): String {
        return String(value.repeat(other.value.toInt()))
    }

}
