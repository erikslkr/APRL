package aprl.util

val Class<*>.defaultValue: Any?
    get() = when (this) {
        Int::class.java -> 0
        Long::class.java -> 0L
        Boolean::class.java -> false
        Float::class.java -> 0.0f
        Double::class.java -> 0.0
        Char::class.java -> 0.toChar()
        else -> null
    }
