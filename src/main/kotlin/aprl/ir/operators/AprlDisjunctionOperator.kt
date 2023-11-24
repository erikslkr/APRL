package aprl.ir.operators

import aprl.grammar.AprlParser.DisjunctionOperatorContext

class AprlDisjunctionOperator(
    override val context: DisjunctionOperatorContext
) : AprlOperator<DisjunctionOperatorContext> {
    
    override val operatorSymbol: String = "||"
    
    override fun toString(): String {
        return operatorSymbol
    }
    
}
