package aprl.lang

abstract class Wrapper<T> {
    abstract val value: T
    
    companion object {
        fun <T> wrap(value: T): Wrapper<*> {
            return when (value) {
                is kotlin.Boolean -> Boolean(value)
                is kotlin.Long -> Int(value)
                is kotlin.Double -> Float(value)
                is kotlin.Char -> Char(value)
                is kotlin.String -> String(value)
                else -> object : Wrapper<T>() {
                    override val value: T  = value
                }
            }
        }
    }
}
