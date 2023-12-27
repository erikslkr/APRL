package aprl.ir

import org.antlr.v4.runtime.ParserRuleContext

sealed interface AprlLocalStatement {
    
    val context: ParserRuleContext
    override fun toString(): String

    fun isDefinitiveReturnStatement(): Boolean

}
