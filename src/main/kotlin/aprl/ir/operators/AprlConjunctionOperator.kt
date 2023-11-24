package aprl.ir.operators

import aprl.grammar.AprlParser.ConjunctionOperatorContext

class AprlConjunctionOperator(
    override val context: ConjunctionOperatorContext
) : AprlOperator<ConjunctionOperatorContext> {
    
    override val operatorSymbol: String = "&&"
    
    override fun toString(): String {
        return operatorSymbol
    }
    
}
