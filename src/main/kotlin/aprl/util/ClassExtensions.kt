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

fun Class<*>.nonPrimitive(): Class<*> {
    return when (this) {
        Int::class.java -> java.lang.Integer::class.java
        Boolean::class.java -> java.lang.Boolean::class.java
        Long::class.java -> java.lang.Long::class.java
        Float::class.java -> java.lang.Float::class.java
        Double::class.java -> java.lang.Double::class.java
        Char::class.java -> java.lang.Character::class.java
        String::class.java -> java.lang.String::class.java
        else -> this
    }
}

fun Class<*>.aprlToJvmType(): Class<*> {
    return when (this) {
        aprl.lang.Boolean::class.java -> java.lang.Boolean::class.java
        aprl.lang.Char::class.java -> java.lang.Character::class.java
        aprl.lang.String::class.java -> java.lang.String::class.java
        aprl.lang.Float::class.java -> java.lang.Double::class.java
        aprl.lang.Int::class.java -> java.lang.Long::class.java
        else -> this
    }
}

fun Class<*>.jvmToAprlType(): Class<*> {
    return when (this) {
        Int::class.java, java.lang.Integer::class.java, Long::class.java, java.lang.Long::class.java -> aprl.lang.Int::class.java
        Float::class.java, java.lang.Float::class.java, Double::class.java, java.lang.Double::class.java -> aprl.lang.Float::class.java
        String::class.java, java.lang.String::class.java -> aprl.lang.String::class.java
        Char::class.java, java.lang.Character::class.java -> aprl.lang.Char::class.java
        Boolean::class.java, java.lang.Boolean::class.java -> aprl.lang.Boolean::class.java
        else -> this
    }
}
