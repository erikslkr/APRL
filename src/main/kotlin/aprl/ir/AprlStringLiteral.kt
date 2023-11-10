package aprl.ir

import aprl.lang.String

class AprlStringLiteral(
    override val value: kotlin.String
) : AprlLiteral<kotlin.String> {

    override val internalType: Class<String> = String::class.java

    override fun toString(): kotlin.String {
        return "\"$value\""
    }

}