package aprl.util

import aprl.lang.Wrapper
import java.lang.reflect.*
import org.objectweb.asm.Type as AsmType

val Type.isInterface: Boolean
    get() {
        TODO("Type.isInterface")
    }

val Type.descriptor: String
    get() {
        return when (this) {
            is Class<*> -> {
                AsmType.getType(this).descriptor
            }
            is ParameterizedType -> {
                TODO("ParameterizedType.descriptor")
            }
            is TypeVariable<*> -> {
                TODO("TypeVariable.descriptor")
            }
            is WildcardType -> {
                TODO("WildcardType.descriptor")
            }
            is GenericArrayType -> {
                TODO("GenericArrayType.descriptor")
            }
            else -> {
                throw InternalError("'${this.javaClass}' not expected as subtype of 'java.lang.reflect.Type'")
            }
        }
    }

@Suppress("RecursivePropertyAccessor")
val Type.simpleName: String
    get() {
        return when (this) {
            is Class<*> -> {
                this.simpleName
            }
            is ParameterizedType -> {
                "${this.rawType.simpleName}<${this.actualTypeArguments.joinToString(", ") { it.simpleName }}>"
            }
            is TypeVariable<*> -> {
                "${this.name}${this.bounds.joinToString("&", ": ") { it.simpleName }}"
            }
            is WildcardType -> {
                TODO("WildcardType.simpleName")
            }
            is GenericArrayType -> {
                "{${this.genericComponentType.simpleName}}"
            }
            else -> {
                throw InternalError("'${this.javaClass}' not expected as subtype of 'java.lang.reflect.Type'")
            }
        }
    }

@Suppress("RecursivePropertyAccessor")
val Type.internalName: String
    get() {
        return when (this) {
            is Class<*> -> {
                AsmType.getType(this).internalName
            }
            is ParameterizedType -> {
                this.rawType.internalName
            }
            is TypeVariable<*> -> {
                TODO("TypeVariable<*>.internalName")
            }
            is WildcardType -> {
                TODO("WildcardType.internalName")
            }
            is GenericArrayType -> {
                TODO("GenericArrayType.internalName")
            }
            else -> {
                throw InternalError("'${this.javaClass}' not expected as subtype of 'java.lang.reflect.Type'")
            }
        }
    }

val Type.defaultValue: Any?
    get() {
        return when (this) {
            aprl.lang.Int::class.java -> 0L
            aprl.lang.Float::class.java -> 0.0
            aprl.lang.Boolean::class.java -> false
            aprl.lang.Char::class.java -> 0.toChar()
            else -> null
        }
    }

fun Type.primitiveDescriptorOrNull(): String? {
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

fun Type.nonPrimitive(): Type {
    return when (this) {
        Int::class.java -> java.lang.Integer::class.java
        Boolean::class.java -> java.lang.Boolean::class.java
        Long::class.java -> java.lang.Long::class.java
        Float::class.java -> java.lang.Float::class.java
        Double::class.java -> java.lang.Double::class.java
        Char::class.java -> java.lang.Character::class.java
        else -> this
    }
}

fun Type.aprlToJvmType(): Type {
    return when (this) {
        aprl.lang.Boolean::class.java -> java.lang.Boolean::class.java
        aprl.lang.Char::class.java -> java.lang.Character::class.java
        aprl.lang.String::class.java -> java.lang.String::class.java
        aprl.lang.Float::class.java -> java.lang.Double::class.java
        aprl.lang.Int::class.java -> java.lang.Long::class.java
        else -> this
    }
}

fun Type.aprlToPrimitiveTypeOrNull(): Type? {
    return when (this) {
        aprl.lang.Boolean::class.java -> Boolean::class.java
        aprl.lang.Char::class.java -> Character::class.java
        aprl.lang.String::class.java -> String::class.java
        aprl.lang.Float::class.java -> Double::class.java
        aprl.lang.Int::class.java -> Long::class.java
        else -> null
    }
}

fun Type.jvmToAprlType(): Type {
    return when (this) {
        Int::class.java, java.lang.Integer::class.java, Long::class.java, java.lang.Long::class.java -> aprl.lang.Int::class.java
        Float::class.java, java.lang.Float::class.java, Double::class.java, java.lang.Double::class.java -> aprl.lang.Float::class.java
        String::class.java, java.lang.String::class.java -> aprl.lang.String::class.java
        Char::class.java, java.lang.Character::class.java -> aprl.lang.Char::class.java
        Boolean::class.java, java.lang.Boolean::class.java -> aprl.lang.Boolean::class.java
        else -> this
    }
}

private fun Class<*>.isAprlAssignableFrom(other: Type): Boolean {
    return when (other) {
        is Class<*> -> {
            return if (this.isAssignableFrom(other)) {
                true
            } else if (Wrapper::class.java.isAssignableFrom(this)) {
                aprlToJvmType().isAprlAssignableFrom(other) || aprlToJvmType().isAprlAssignableFrom(other.jvmToAprlType())
            } else if (Wrapper::class.java.isAssignableFrom(other)) {
                isAprlAssignableFrom(other.aprlToJvmType()) || jvmToAprlType().isAprlAssignableFrom(other.aprlToJvmType())
            } else {
                false
            }
        }
        is ParameterizedType -> {
            TODO("Class<*> isAprlAssignableFrom ParameterizedType")
        }
        is TypeVariable<*> -> {
            TODO("Class<*> isAprlAssignableFrom TypeVariable<*>")
        }
        is WildcardType -> {
            TODO("Class<*> isAprlAssignableFrom WildcardType")
        }
        is GenericArrayType -> {
            TODO("Class<*> isAprlAssignableFrom GenericArrayType")
        }
        else -> {
            false
        }
    }
}

private fun ParameterizedType.isAprlAssignableFrom(other: Type): Boolean {
    return when (other) {
        is Class<*> -> {
            TODO("ParameterizedType isAprlAssignableFrom Class<*>")
        }
        is ParameterizedType -> {
            TODO("ParameterizedType isAprlAssignableFrom ParameterizedType")
        }
        is TypeVariable<*> -> {
            TODO("ParameterizedType isAprlAssignableFrom TypeVariable<*>")
        }
        is WildcardType -> {
            TODO("ParameterizedType isAprlAssignableFrom WildcardType")
        }
        is GenericArrayType -> {
            TODO("ParameterizedType isAprlAssignableFrom GenericArrayType")
        }
        else -> {
            false
        }
    }
}

private fun TypeVariable<*>.isAprlAssignableFrom(other: Type): Boolean {
    return when (other) {
        is Class<*> -> {
            TODO("TypeVariable<*> isAprlAssignableFrom Class<*>")
        }
        is ParameterizedType -> {
            TODO("TypeVariable<*> isAprlAssignableFrom ParameterizedType")
        }
        is TypeVariable<*> -> {
            TODO("TypeVariable<*> isAprlAssignableFrom TypeVariable<*>")
        }
        is WildcardType -> {
            TODO("TypeVariable<*> isAprlAssignableFrom WildcardType")
        }
        is GenericArrayType -> {
            TODO("TypeVariable<*> isAprlAssignableFrom GenericArrayType")
        }
        else -> {
            false
        }
    }
}

private fun WildcardType.isAprlAssignableFrom(other: Type): Boolean {
    return when (other) {
        is Class<*> -> {
            TODO("WildcardType isAprlAssignableFrom Class<*>")
        }
        is ParameterizedType -> {
            TODO("WildcardType isAprlAssignableFrom ParameterizedType")
        }
        is TypeVariable<*> -> {
            TODO("WildcardType isAprlAssignableFrom TypeVariable<*>")
        }
        is WildcardType -> {
            TODO("WildcardType isAprlAssignableFrom WildcardType")
        }
        is GenericArrayType -> {
            TODO("WildcardType isAprlAssignableFrom GenericArrayType")
        }
        else -> {
            false
        }
    }
}

private fun GenericArrayType.isAprlAssignableFrom(other: Type): Boolean {
    return when (other) {
        is Class<*> -> {
            TODO("GenericArrayType isAprlAssignableFrom Class<*>")
        }
        is ParameterizedType -> {
            TODO("GenericArrayType isAprlAssignableFrom ParameterizedType")
        }
        is TypeVariable<*> -> {
            TODO("GenericArrayType isAprlAssignableFrom TypeVariable<*>")
        }
        is WildcardType -> {
            TODO("GenericArrayType isAprlAssignableFrom WildcardType")
        }
        is GenericArrayType -> {
            this.genericComponentType.isAprlAssignableFrom(other.genericComponentType)
        }
        else -> {
            false
        }
    }
}

fun Type.isAprlAssignableFrom(other: Type): Boolean {
    return when (this) {
        is Class<*> -> this.isAprlAssignableFrom(other)
        is ParameterizedType -> this.isAprlAssignableFrom(other)
        is TypeVariable<*> -> this.isAprlAssignableFrom(other)
        is WildcardType -> this.isAprlAssignableFrom(other)
        is GenericArrayType -> this.isAprlAssignableFrom(other)
        else -> false
    }
}

fun Type.isJvmAssignableFrom(other: Type): Boolean {
    TODO("Type isJvmAssignableFrom Type")
}

fun Type.getMethods(): List<Method> {
    return when (this) {
        is Class<*> -> {
            this.methods.asList()
        }
        is ParameterizedType -> {
            TODO("ParameterizedType.getMethods()")
        }
        is TypeVariable<*> -> {
            this.bounds.flatMap { it.getMethods() }
        }
        is WildcardType -> {
            this.upperBounds.flatMap { it.getMethods() }
        }
        is GenericArrayType -> {
            TODO("GenericArrayType.getMethods()")
        }
        else -> {
            throw InternalError("'${this.javaClass}' not expected as subtype of 'java.lang.reflect.Type'")
        }
    }
}
