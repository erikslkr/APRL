package aprl.ir.operators

import aprl.lang.Wrapper
import org.antlr.v4.runtime.ParserRuleContext

interface AprlOverloadableUnaryOperator<T: ParserRuleContext> : AprlOperator<T> {
    val functionName: String
    
    fun applyOrNull(operand: Any): Any? {
        return try {
            val method = operand.javaClass.getMethod(functionName)
            (method.invoke(operand) as? Wrapper<*>)?.value
        } catch (ex: NoSuchMethodException) {
            null
        }
    }
}
