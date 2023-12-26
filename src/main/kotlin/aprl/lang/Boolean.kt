@file:Suppress("FunctionName")

package aprl.lang

data class Boolean(
    override val value: kotlin.Boolean
) : Wrapper<kotlin.Boolean>() {
    
    @Verbatim
    @OperatorFunction
    fun __not__(): Boolean {
        return Boolean(!value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __inverse__(): Boolean {
        return Boolean(!value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __and__(other: Boolean): Boolean {
        return Boolean(value && other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __or__(other: Boolean): Boolean {
        return Boolean(value || other.value)
    }
    
    @Verbatim
    @OperatorFunction
    fun __xor__(other: Boolean): Boolean {
        return Boolean(value xor other.value)
    }
    
    companion object {
        @JvmStatic
        fun valueOf(value: kotlin.Boolean): Boolean {
            return Boolean(value)
        }
    }
    
}
