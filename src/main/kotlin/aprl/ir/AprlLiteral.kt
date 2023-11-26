package aprl.ir

import aprl.grammar.AprlParser.LiteralContext
import org.antlr.v4.runtime.ParserRuleContext

interface AprlLiteral<T> : AprlNode<LiteralContext> {
    val value: T
    val internalType: Class<*>
    
    override fun toString(): String
}
