package aprl.compiler

import aprl.ir.AprlIR
import aprl.ir.AprlVariableAssignment
import aprl.ir.AprlVariableDeclaration
import aprl.util.emptyLocalVariables
import aprl.util.visitAprlVariableAssignment
import aprl.util.visitAprlVariableDeclaration
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes

class AprlJvmBytecodeCompiler(private val settings: AprlCompilerSettings) {
    
    private lateinit var source: AprlIR
    
    fun compile(ir: AprlIR): ByteArray {
        this.source = ir
        val classWriter = ClassWriter(0)
        classWriter.visit(
            Opcodes.V1_8,
            Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL,
            ir.name!!,
            null,
            "java/lang/Object",
            emptyArray()
        )
        val mainMethod = classWriter.visitMethod(
            Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC + Opcodes.ACC_FINAL,
            "main",
            "([Ljava/lang/String;)V",
            null,
            null
        )
        mainMethod.visitCode()
        val localVariables = emptyLocalVariables()
        for (statement in ir.statements) {
            when (statement) {
                is AprlVariableDeclaration -> {
                    mainMethod.visitAprlVariableDeclaration(statement, localVariables)
                }
                is AprlVariableAssignment -> {
                    mainMethod.visitAprlVariableAssignment(statement, localVariables)
                }
            }
        }
        for ((index, _) in localVariables.values) {
            mainMethod.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
            mainMethod.visitVarInsn(Opcodes.ILOAD, index)
            mainMethod.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false)
        }
        mainMethod.visitInsn(Opcodes.RETURN)
        mainMethod.visitMaxs(3, localVariables.size)
        mainMethod.visitEnd()
        classWriter.visitEnd()
        return classWriter.toByteArray()
    }
    
}