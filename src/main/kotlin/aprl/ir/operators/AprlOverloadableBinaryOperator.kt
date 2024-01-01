package aprl.ir.operators

import aprl.ir.operators.AprlAdditiveOperator.*
import aprl.ir.operators.AprlMultiplicativeOperator.*
import aprl.ir.operators.AprlExponentialOperator.*
import aprl.ir.operators.AprlBitwiseOperator.*
import aprl.grammar.AprlParser.*
import aprl.lang.Wrapper
import org.antlr.v4.runtime.ParserRuleContext

interface AprlOverloadableBinaryOperator<T: ParserRuleContext> : AprlOperator<T> {
    
    val functionName: String
    
    fun applyOrNull(lhs: Any, rhs: Any): Any? {
        return try {
            val method = lhs.javaClass.getMethod(functionName, rhs.javaClass)
            (method.invoke(lhs, rhs) as? Wrapper<*>)?.value
        } catch (ex: ReflectiveOperationException) {
            null
        }
    }
    
    companion object {
        fun fromAssignmentOperator(ctx: AssignmentOperatorContext): AprlOverloadableBinaryOperator<*>? {
            return when {
                ctx.PLUS_EQUAL() != null -> AprlPlusOperator(AdditiveOperatorContext(ctx.getParent(), ctx.invokingState))
                ctx.MINUS_EQUAL() != null -> AprlMinusOperator(AdditiveOperatorContext(ctx.getParent(), ctx.invokingState))
                ctx.ASTERISK_EQUAL() != null -> AprlMultiplyOperator(MultiplicativeOperatorContext(ctx.getParent(), ctx.invokingState))
                ctx.SLASH_EQUAL() != null -> AprlDivideOperator(MultiplicativeOperatorContext(ctx.getParent(), ctx.invokingState))
                ctx.DOUBLE_SLASH_EQUAL() != null -> AprlFloordivOperator(MultiplicativeOperatorContext(ctx.getParent(), ctx.invokingState))
                ctx.PERCENT_EQUAL() != null -> AprlModuloOperator(MultiplicativeOperatorContext(ctx.getParent(), ctx.invokingState))
                ctx.DOUBLE_ASTERISK_EQUAL() != null -> AprlPowerOperator(ExponentialOperatorContext(ctx.getParent(), ctx.invokingState))
                ctx.AND_EQUAL() != null -> AprlAndOperator(BitwiseOperatorContext(ctx.getParent(), ctx.invokingState))
                ctx.OR_EQUAL() != null -> AprlOrOperator(BitwiseOperatorContext(ctx.getParent(), ctx.invokingState))
                ctx.XOR_EQUAL() != null -> AprlXorOperator(BitwiseOperatorContext(ctx.getParent(), ctx.invokingState))
                ctx.SHL_EQUAL() != null -> AprlShlOperator(BitwiseOperatorContext(ctx.getParent(), ctx.invokingState))
                ctx.SHR_EQUAL() != null -> AprlShrOperator(BitwiseOperatorContext(ctx.getParent(), ctx.invokingState))
                ctx.USHR_EQUAL() != null -> AprlUshrOperator(BitwiseOperatorContext(ctx.getParent(), ctx.invokingState))
                else -> null
            }
        }
    }
    
}
