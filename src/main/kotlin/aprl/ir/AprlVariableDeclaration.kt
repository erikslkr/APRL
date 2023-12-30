package aprl.ir

import aprl.grammar.AprlParser
import aprl.grammar.AprlParser.VariableDeclarationContext

data class AprlVariableDeclaration(
    val variableClassifier: VariableClassifier,
    override val context: VariableDeclarationContext
) : AprlGlobalStatement, AprlLocalStatement, AprlNode<VariableDeclarationContext> {
    
    lateinit var identifier: String
    var typeAnnotation: AprlTypeReference? = null
    var expression: AprlExpression? = null
    
    override fun toString(): String {
        return if (typeAnnotation == null) {
            "$variableClassifier $identifier = $expression"
        } else if (expression == null) {
            "$variableClassifier $identifier: $typeAnnotation"
        } else {
            "$variableClassifier $identifier: $typeAnnotation = $expression"
        }
    }

    override fun isDefinitiveReturnStatement(): Boolean {
        return false
    }
    
}

enum class VariableClassifier {
    VAL,
    VAR;
    
    override fun toString(): String {
        return super.toString().lowercase()
    }
    
    companion object {
        fun fromNode(ctx: AprlParser.VariableClassifierContext): VariableClassifier {
            return if (ctx.VAL() != null) {
                VAL
            } else if (ctx.VAR() != null) {
                VAR
            } else {
                throw IllegalStateException("Expected VariableClassifierContext to be VAL ('val') or VAR ('var'), found '${ctx.text}'")
            }
        }
    }
}
