package aprl.ir

import aprl.grammar.AprlParser

data class AprlVariableDeclaration(
    val variableClassifier: VariableClassifier,
    var variableAssignment: AprlVariableAssignment?
) : AprlStatement {
    override fun toString(): String {
        return "$variableClassifier $variableAssignment"
    }
}

enum class VariableClassifier {
    VAL,
    VAR;
    
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
