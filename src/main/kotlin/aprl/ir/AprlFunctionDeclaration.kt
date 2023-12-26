package aprl.ir

import aprl.grammar.AprlParser.FunctionDeclarationContext
import aprl.jvm.JvmMethod

data class AprlFunctionDeclaration(
    var name: String?,
    val valueParameters: MutableList<AprlValueParameter>,
    var returnType: AprlTypeReference?,
    var functionBody: AprlFunctionBody?,
    override val context: FunctionDeclarationContext
) : AprlGlobalStatement, AprlNode<FunctionDeclarationContext> {
    
    override fun toString(): String {
        return "function $name(${valueParameters.joinToString(", ")}) -> $returnType $functionBody"
    }
    
    fun asJvmMethod(ownerInternalName: String): JvmMethod {
        val parameterTypes = valueParameters.map { it.type?.javaType ?: Any::class.java }
        val parameterNames = valueParameters.map { it.name!! }
        val returnType = returnType?.javaType ?: Void::class.java
        return JvmMethod(name!!, ownerInternalName, parameterTypes, parameterNames, returnType)
    }
    
}
