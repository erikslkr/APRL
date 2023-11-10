package aprl.ir

import aprl.lang.Boolean

class AprlBooleanLiteral(
    override val value: kotlin.Boolean
) : AprlLiteral<kotlin.Boolean> {
    
    override val internalType: Class<*> = Boolean::class.java
    
}
