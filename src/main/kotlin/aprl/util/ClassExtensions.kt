package aprl.util

import aprl.lang.Wrapper

val Class<*>.defaultValue: Any?
    get() = when (this) {
        aprl.lang.Int::class.java -> 0L
        aprl.lang.Float::class.java -> 0.0
        aprl.lang.Boolean::class.java -> false
        aprl.lang.Char::class.java -> 0.toChar()
        else -> null
    }
