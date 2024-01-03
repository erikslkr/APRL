package aprl.reflect

import aprl.util.descriptor
import aprl.util.simpleName
import java.lang.reflect.GenericArrayType
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.lang.reflect.TypeVariable
import java.lang.reflect.WildcardType
import org.objectweb.asm.Type as AsmType

data class JvmMethod(
    val name: String,
    val ownerInternalName: String,
    val parameterTypes: List<Type>,
    val parameterNames: List<String>,
    val returnType: Type
) {
    
    val descriptor: String
        get() {
            return "(${parameterTypes.joinToString("") { it.descriptor }})${returnType.descriptor}"
        }
    
    val simpleName: String
        get() {
            return "${ownerInternalName.replace("/", ".")}.$name(${parameterTypes.joinToString(", ") { it.simpleName }})"
        }
    
    companion object {
        fun fromMethod(method: Method): JvmMethod {
            return JvmMethod(
                method.name,
                AsmType.getType(method.declaringClass).internalName,
                method.parameterTypes.asList(),
                method.parameters.map { it.name },
                method.returnType
            )
        }
    }
    
}
