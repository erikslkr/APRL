package aprl.jvm

import org.objectweb.asm.Type
import java.lang.reflect.Method

data class JvmMethod(
    val name: String,
    val ownerInternalName: String,
    val parameterTypes: List<Class<*>>,
    val returnType: Class<*>
) {
    
    val descriptor: String
        get() {
            val returnType = Type.getType(returnType)
            val parameterTypes = parameterTypes.map { Type.getType(it) }
            return "(${parameterTypes.joinToString("") { it.descriptor }})${returnType.descriptor}"
        }
    
    val simpleName: String
        get() {
            return "$ownerInternalName.$name(${parameterTypes.joinToString(", ") { it.simpleName }})"
        }
    
    companion object {
        fun fromMethod(method: Method): JvmMethod {
            return JvmMethod(method.name, Type.getType(method.declaringClass).internalName, method.parameterTypes.asList(), method.returnType)
        }
    }
    
}
