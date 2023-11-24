package aprl.ir.operators

import aprl.ir.AprlNode
import org.antlr.v4.runtime.ParserRuleContext

interface AprlOperator<T: ParserRuleContext> : AprlNode<T> {
    val operatorSymbol: String
}
