package aprl.ir

import aprl.grammar.AprlParser.LiteralContext
import org.antlr.v4.runtime.ParserRuleContext

interface AprlLiteral<T> : AprlNode<LiteralContext> {
    val value: T
    val internalType: Class<*>
    
    override val context: LiteralContext
        get() = throw UnsupportedOperationException("Aprl literals do not implement 'context'")
    
    override fun toString(): String
}
