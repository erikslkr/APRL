package aprl.ir.operators

import aprl.lang.Wrapper
import org.antlr.v4.runtime.ParserRuleContext

interface AprlOverloadableOperator<T: ParserRuleContext> : AprlOperator<T> {
    val functionName: String
    
    fun applyOrNull(lhs: Any, rhs: Any): Any? {
        return try {
            val method = lhs.javaClass.getMethod(functionName, rhs.javaClass)
            (method.invoke(lhs, rhs) as? Wrapper<*>)?.value
        } catch (ex: NoSuchMethodException) {
            null
        }
    }
}
