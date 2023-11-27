package aprl.ir

import aprl.grammar.AprlParser.FunctionDeclarationContext
import aprl.util.emptyLocalVariables

data class AprlFunctionDeclaration(
    var name: String?,
    val arguments: MutableList<AprlFunctionArgument>,
    var returnType: AprlTypeReference?,
    var functionBody: AprlFunctionBody?,
    override val context: FunctionDeclarationContext
) : AprlGlobalStatement, AprlNode<FunctionDeclarationContext> {
    
    override fun toString(): String {
        return "function $name(${arguments.joinToString(", ")}) -> $returnType $functionBody"
    }
    
}
