package aprl.ir

import aprl.grammar.AprlParser.VisibilityModifierContext
import org.antlr.v4.runtime.ParserRuleContext
import org.objectweb.asm.Opcodes.*

sealed interface AprlModifier<T: ParserRuleContext> : AprlNode<T> {
    fun isCompatible(other: AprlModifier<*>): Boolean
    fun isCompatible(target: ModifierTarget): Boolean
    
    val opcode: Int
    
    enum class ModifierTarget(val string: String) {
        FUNCTION("function"),
        LOCAL_VARIABLE("local variable"),
        PROPERTY("property"),
        CLASS("class");
        
        override fun toString(): String {
            return string
        }
    }
}

sealed class AprlVisibilityModifier(
    val string: String,
    override val opcode: Int
) : AprlModifier<VisibilityModifierContext> {
    
    class AprlPrivateModifier(
        override val context: VisibilityModifierContext
    ) : AprlVisibilityModifier("private", ACC_PRIVATE)
    
    class AprlProtectedModifier(
        override val context: VisibilityModifierContext
    ) : AprlVisibilityModifier("protected", ACC_PROTECTED)
    
    class AprlInternalModifier(
        override val context: VisibilityModifierContext
    ) : AprlVisibilityModifier("internal", 0)
    
    class AprlPublicModifier(
        override val context: VisibilityModifierContext
    ) : AprlVisibilityModifier("public", ACC_PUBLIC)
    
    override fun isCompatible(other: AprlModifier<*>): Boolean {
        return other !is AprlVisibilityModifier
    }
    
    override fun isCompatible(target: AprlModifier.ModifierTarget): Boolean {
        return true
    }
    
    override fun toString(): String {
        return string
    }
    
    companion object {
        fun fromNode(ctx: VisibilityModifierContext): AprlVisibilityModifier {
            return when {
                ctx.PRIVATE() != null -> AprlPrivateModifier(ctx)
                ctx.PROTECTED() != null -> AprlProtectedModifier(ctx)
                ctx.INTERNAL() != null -> AprlInternalModifier(ctx)
                ctx.PUBLIC() != null -> AprlPublicModifier(ctx)
                else -> throw InternalError("Visibility modifier should be PRIVATE, PROTECTED, INTERNAL or PUBLIC, found '$ctx'")
            }
        }
    }
    
}
