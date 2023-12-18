package aprl.compiler

import aprl.ir.AprlFunctionDeclaration
import aprl.ir.AprlFile
import aprl.ir.AprlVariableDeclaration
import aprl.util.AprlFunctionVisitor
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
        for (functionDeclaration in ir.globalStatements.filterIsInstance(AprlFunctionDeclaration::class.java)) {
            val argumentsDescriptor = functionDeclaration.valueParameters.joinToString("") {
                Type.getType(it.type!!.javaType).descriptor
            }
            val returnTypeDescriptor = functionDeclaration.returnType?.let { Type.getType(it.javaType).descriptor } ?: "V"
            val function = classWriter.visitMethod(
                ACC_PUBLIC + ACC_STATIC + ACC_FINAL,
                functionDeclaration.name!!,
                "($argumentsDescriptor)$returnTypeDescriptor",
                null,
                null
            )
            val functionVisitor = AprlFunctionVisitor(function, ir)
            functionVisitor.visitFunctionDeclaration(functionDeclaration)
        }
        for (variableDeclaration in ir.globalStatements.filterIsInstance(AprlVariableDeclaration::class.java)) {
            // TODO: global variables (fields)
        }
        classWriter.visitEnd()
        return classWriter.toByteArray()
    }
    
}
