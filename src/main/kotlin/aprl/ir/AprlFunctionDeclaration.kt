package aprl.ir

import aprl.grammar.AprlParser.FunctionDeclarationContext
import aprl.reflect.JvmMethod

class AprlFunctionDeclaration(
    override val context: FunctionDeclarationContext
) : AprlGlobalStatement, AprlNode<FunctionDeclarationContext> {
    
    val modifiers = mutableListOf<AprlModifier<*>>()
    val valueParameters = mutableListOf<AprlValueParameter>()
    
    lateinit var name: String
    lateinit var functionBody: AprlFunctionBody
    
    var returnType: AprlTypeReference? = null
    
    override fun toString(): String {
        return "function $name(${valueParameters.joinToString(", ")}) -> $returnType $functionBody"
    }
    
    fun asJvmMethod(ownerInternalName: String): JvmMethod {
        val parameterTypes = valueParameters.map { it.type.getJavaType() }
        val parameterNames = valueParameters.map { it.name }
        val returnType = returnType?.getJavaType() ?: Void::class.java
        return JvmMethod(name, ownerInternalName, parameterTypes, parameterNames, returnType)
    }
    
}
