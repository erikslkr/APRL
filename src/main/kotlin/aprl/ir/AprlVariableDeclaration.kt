package aprl.ir

import aprl.grammar.AprlParser
import aprl.grammar.AprlParser.VariableDeclarationContext

data class AprlVariableDeclaration(
    val variableClassifier: VariableClassifier,
    var identifier: String?,
    var typeAnnotation: AprlTypeReference?,
    var expression: AprlExpression?,
    override val context: VariableDeclarationContext
) : AprlStatement, AprlNode<VariableDeclarationContext> {
    
    override fun toString(): String {
        return if (typeAnnotation == null) {
            "$variableClassifier $identifier = $expression"
        } else if (expression == null) {
            "$variableClassifier $identifier: $typeAnnotation"
        } else {
            "$variableClassifier $identifier: $typeAnnotation = $expression"
        }
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
