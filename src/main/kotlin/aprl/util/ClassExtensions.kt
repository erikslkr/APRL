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

fun Class<*>.primitiveDescriptorOrNull(): String? {
    return when (this) {
        java.lang.Boolean::class.java, Boolean::class.java -> "Z"
        java.lang.Integer::class.java, Int::class.java -> "I"
        java.lang.Float::class.java, Float::class.java -> "F"
        java.lang.Long::class.java, Long::class.java -> "J"
        java.lang.Double::class.java, Double::class.java -> "D"
        java.lang.Character::class.java, Char::class.java -> "C"
        else -> null
    }
}
