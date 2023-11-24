package aprl.ir

import org.antlr.v4.runtime.ParserRuleContext

interface AprlNode<T: ParserRuleContext> {
    val context: T
}
