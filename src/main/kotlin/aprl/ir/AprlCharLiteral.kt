package aprl.ir

import aprl.grammar.AprlParser
import aprl.lang.Char

class AprlCharLiteral(
    override val value: kotlin.Char,
    override val context: AprlParser.LiteralContext
) : AprlLiteral<kotlin.Char> {

    override val internalType: Class<Char> = Char::class.java

    override fun toString(): String {
        return "'$value'"
    }

}
