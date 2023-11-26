package aprl.ir

import aprl.grammar.AprlParser
import aprl.lang.String

class AprlStringLiteral(
    override val value: kotlin.String,
    override val context: AprlParser.LiteralContext
) : AprlLiteral<kotlin.String> {

    override val internalType: Class<String> = String::class.java

    override fun toString(): kotlin.String {
        return "\"$value\""
    }

}