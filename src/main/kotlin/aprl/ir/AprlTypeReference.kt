package aprl.ir

import aprl.grammar.AprlParser.TypeReferenceContext
import aprl.reflect.ParameterizedTypeImpl
import java.lang.reflect.Type
import java.util.ArrayList

class AprlTypeReference(
    override val context: TypeReferenceContext
) : AprlNode<TypeReferenceContext> {
    
    var identifier: AprlIdentifier? = null
    var listTypeReference: AprlTypeReference? = null
    
    fun getJavaType(): Type {
        return if (identifier != null) {
            try {
                // TODO: check if class should be available in APRL (e.g. primitive types, JVM wrapper types, etc should probably be prohibited)
                Class.forName(identifier!!.identifiers.joinToString("."))
            } catch (ex: ClassNotFoundException) {
                // TODO: check imports
                Any::class.java
            }
        } else if (listTypeReference != null) {
            ParameterizedTypeImpl(ArrayList::class.java, null, listOf(listTypeReference!!.getJavaType()))
        } else {
            Any::class.java
        }
    }
    
    override fun toString(): String {
        return identifier.toString()
    }
    
}
