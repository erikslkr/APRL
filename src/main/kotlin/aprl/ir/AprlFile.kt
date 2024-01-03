package aprl.ir

import aprl.reflect.JvmMethod
import java.lang.reflect.Method
import java.lang.reflect.Modifier

class AprlFile(
    var name: String? = null,
    val globalStatements: MutableList<AprlGlobalStatement> = mutableListOf()
) {
    
    override fun toString(): String {
        return globalStatements.joinToString("\r\n")
    }
    
    val jvmInternalName: String
        get() {
            // TODO: prepend package to name
            return name!!
        }
    
    fun findStaticFunctions(identifier: AprlIdentifier): List<JvmMethod> {
        if (identifier.identifiers.size == 1) {
            val allDeclaredFunctions: List<JvmMethod> = globalStatements.filterIsInstance(AprlFunctionDeclaration::class.java).map { it.asJvmMethod(jvmInternalName) }
            val declaredNamedFunctions = allDeclaredFunctions.filter { it.name == identifier.toString() }
            
            val allInheritedFunctions: List<Method> = Object::class.java.methods.asList() // TODO: replace with actual supertype
            val inheritedNamedFunctions = allInheritedFunctions.filter { it.name == identifier.toString() }
            
            val allImportedFunctions: List<Method> = listOf() // TODO: find imported functions
            
            return declaredNamedFunctions +
                    inheritedNamedFunctions.map { JvmMethod.fromMethod(it) }
        } else {
            val owner = identifier.identifiers.dropLast(1).joinToString(".")
            // TODO: check for `owner` in imports
            // TODO: unresolved reference
            val functionName = identifier.identifiers.last().toString()
            val ownerClass = ClassLoader.getSystemClassLoader().loadClass(owner)
            return ownerClass.methods.filter { it.name == functionName && Modifier.isStatic(it.modifiers) }.map(JvmMethod::fromMethod)
        }
    }
    
}
