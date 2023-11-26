package aprl.ir

import aprl.grammar.AprlParser
import aprl.lang.Boolean

class AprlBooleanLiteral(
    override val value: kotlin.Boolean,
    override val context: AprlParser.LiteralContext
) : AprlLiteral<kotlin.Boolean> {
    
    override val internalType: Class<*> = Boolean::class.java

    override fun toString(): String {
        return value.toString()
    }

}
