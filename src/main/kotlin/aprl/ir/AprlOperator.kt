package aprl.ir

import aprl.lang.Wrapper

interface AprlOperator : AprlEvaluable {
    val functionName: String
    val operatorSymbol: String
    
    fun applyOrNull(lhs: Any, rhs: Any): Any? {
        return try {
            val method = lhs.javaClass.getMethod(functionName, rhs.javaClass)
            (method.invoke(lhs, rhs) as? Wrapper<*>)?.value
        } catch (ex: NoSuchMethodException) {
            null
        }
    }
}
