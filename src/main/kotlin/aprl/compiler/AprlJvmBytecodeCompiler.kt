package aprl.compiler

import aprl.grammar.AprlParser.VisibilityModifierContext
import aprl.ir.*
import aprl.util.AprlFunctionVisitor
import aprl.util.descriptor
import aprl.util.duplicates
import aprl.util.positionRange
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type

class AprlJvmBytecodeCompiler(private val settings: AprlCompilerSettings) {
    
    private lateinit var source: AprlFile
    
    fun compile(ir: AprlFile): ByteArray {
        this.source = ir
        val classWriter = ClassWriter(ClassWriter.COMPUTE_FRAMES)
        classWriter.visit(
            V1_8,
            ACC_PUBLIC + ACC_FINAL,
            ir.name!!,
            null,
            "java/lang/Object",
            emptyArray()
        )
        for (functionDeclaration in ir.globalStatements.filterIsInstance<AprlFunctionDeclaration>()) {
            val argumentsDescriptor = functionDeclaration.valueParameters.joinToString("") {
                it.type.getJavaType().descriptor
            }
            val returnTypeDescriptor = functionDeclaration.returnType?.getJavaType()?.descriptor ?: "V"
            val function = classWriter.visitMethod(
                visitModifiers(functionDeclaration.modifiers, AprlModifier.ModifierTarget.FUNCTION) + ACC_STATIC + ACC_FINAL,
                functionDeclaration.name,
                "($argumentsDescriptor)$returnTypeDescriptor",
                null,
                null
            )
            val functionVisitor = AprlFunctionVisitor(function, ir)
            functionVisitor.visitFunctionDeclaration(functionDeclaration)
        }
        for (variableDeclaration in ir.globalStatements.filterIsInstance<AprlVariableDeclaration>()) {
            // TODO: global variables (fields)
        }
        classWriter.visitEnd()
        return classWriter.toByteArray()
    }
    
    @Suppress("SameParameterValue")
    private fun visitModifiers(modifiers: List<AprlModifier<*>>, modifierTarget: AprlModifier.ModifierTarget): Int {
        for (duplicateSet in modifiers.duplicates()) {
            for (duplicate in duplicateSet.drop(1)) {
                ERROR("Repeated '$duplicate'", duplicate.context.positionRange)
            }
        }
        val appliedModifiers = mutableListOf<AprlModifier<*>>()
        val uniqueModifiers = modifiers.toSet().toList()
        for (modifier in uniqueModifiers) {
            val incompatible = appliedModifiers.filter { !modifier.isCompatible(it) }
            if (incompatible.isNotEmpty()) {
                ERROR("Modifier '$modifier' is incompatible with ${incompatible.joinToString(" ", "'", "'")}", modifier.context.positionRange)
            } else if (!modifier.isCompatible(modifierTarget)) {
                ERROR("Modifier '$modifier' cannot be applied to '$modifierTarget'", modifier.context.positionRange)
            } else {
                appliedModifiers.add(modifier)
            }
        }
        var accessFlags = appliedModifiers.sumOf { it.opcode }
        if (appliedModifiers.none { it is AprlVisibilityModifier }) {
            accessFlags += ACC_PUBLIC
        }
        return accessFlags
    }
    
}
