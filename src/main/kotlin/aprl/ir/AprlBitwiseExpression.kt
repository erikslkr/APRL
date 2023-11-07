package aprl.ir

import aprl.grammar.AprlParser
import aprl.util.ExpressionTree

data class AprlBitwiseExpression(
    var bitwiseExpression: AprlBitwiseExpression?,
    var bitwiseOperator: AprlBitwiseOperator?,
    var additiveExpression: AprlAdditiveExpression?
) : AprlEvaluable {
    override fun toString(): String {
        if (bitwiseOperator == null) {
            return "$additiveExpression"
        }
        return "$bitwiseExpression $bitwiseOperator $additiveExpression"
    }
    
    fun toTree(): ExpressionTree {
        return ExpressionTree(bitwiseExpression?.toTree(), additiveExpression?.toTree(), bitwiseOperator)
    }
}

enum class AprlBitwiseOperator : AprlOperator {
    AND,
    OR,
    XOR,
    SHL,
    SHR,
    USHR;
    
    override fun apply(lhs: Int, rhs: Int): Int {
        return when (this) {
            AND -> lhs and rhs
            OR -> lhs or rhs
            XOR -> lhs xor rhs
            SHL -> lhs shl rhs
            SHR -> lhs shr rhs
            USHR -> lhs ushr rhs
        }
    }
    
    companion object {
        fun fromNode(ctx: AprlParser.BitwiseOperatorContext): AprlBitwiseOperator {
            return if (ctx.AND() != null) {
                AND
            } else if (ctx.OR() != null) {
                OR
            } else if (ctx.XOR() != null) {
                XOR
            } else if (ctx.SHL() != null) {
                SHL
            } else if (ctx.SHR() != null) {
                SHR
            } else if (ctx.USHR() != null) {
                USHR
            } else {
                throw IllegalStateException("Expected BitwiseOperatorContext to be AND (&), OR (|), XOR (^), SHL (<<), SHR (>>) or USHR (>>>), found '${ctx.text}'")
            }
        }
    }
}
