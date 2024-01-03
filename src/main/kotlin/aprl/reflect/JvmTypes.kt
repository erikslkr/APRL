package aprl.reflect

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

internal interface TypeImpl : Type {
    @Suppress("VIRTUAL_MEMBER_HIDDEN") // This is needed for cases when environment variable JDK_1_6 points to JDK 8+.
    fun getTypeName(): String
}

internal class ParameterizedTypeImpl(
    private val rawType: Class<*>,
    private val ownerType: Type?,
    typeArguments: List<Type>
) : ParameterizedType, TypeImpl {
    
    private val typeArguments = typeArguments.toTypedArray()
    
    override fun getRawType(): Type = rawType
    
    override fun getOwnerType(): Type? = ownerType
    
    override fun getActualTypeArguments(): Array<Type> = typeArguments
    
    override fun getTypeName(): String {
        return buildString {
            if (ownerType != null) {
                append(ownerType.typeName)
                append("$")
                append(rawType.simpleName)
            } else {
                append(rawType.typeName)
            }
            if (typeArguments.isNotEmpty()) {
                typeArguments.joinTo(this, prefix = "<", postfix = ">", transform = Type::getTypeName)
            }
        }
    }
    
    override fun equals(other: Any?): Boolean {
        return other is ParameterizedType
                && rawType == other.rawType
                && ownerType == other.ownerType
                && actualTypeArguments.contentEquals(other.actualTypeArguments)
    }
    
    override fun hashCode(): Int {
        return rawType.hashCode() xor ownerType.hashCode() xor actualTypeArguments.contentHashCode()
    }
    
    override fun toString(): String {
        return typeName
    }
    
}
