package aprl.ir

import aprl.lang.Char

class AprlCharLiteral(
    override val value: kotlin.Char
) : AprlLiteral<kotlin.Char> {

    override val internalType: Class<Char> = Char::class.java

    override fun toString(): String {
        return "'$value'"
    }

}
