package aprl.ir

import aprl.grammar.AprlParser.FunctionDeclarationContext
import aprl.jvm.JvmMethod

data class AprlFunctionDeclaration(
    override val context: FunctionDeclarationContext
) : AprlGlobalStatement, AprlNode<FunctionDeclarationContext> {
    
    lateinit var name: String
    val valueParameters = mutableListOf<AprlValueParameter>()
    var returnType: AprlTypeReference? = null
    lateinit var functionBody: AprlFunctionBody
    
    override fun toString(): String {
        return "function $name(${valueParameters.joinToString(", ")}) -> $returnType $functionBody"
    }
    
    fun asJvmMethod(ownerInternalName: String): JvmMethod {
        val parameterTypes = valueParameters.map { it.type?.javaType ?: Any::class.java }
        val parameterNames = valueParameters.map { it.name!! }
        val returnType = returnType?.javaType ?: Void::class.java
        return JvmMethod(name, ownerInternalName, parameterTypes, parameterNames, returnType)
    }
    
}
