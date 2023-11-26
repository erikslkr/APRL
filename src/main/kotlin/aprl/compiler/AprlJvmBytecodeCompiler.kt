package aprl.compiler

import aprl.ir.AprlIR
import aprl.ir.AprlVariableAssignment
import aprl.ir.AprlVariableDeclaration
import aprl.util.emptyLocalVariables
import aprl.util.localVariables
import aprl.util.visitAprlVariableAssignment
import aprl.util.visitAprlVariableDeclaration
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes.*

class AprlJvmBytecodeCompiler(private val settings: AprlCompilerSettings) {
    
    private lateinit var source: AprlIR
    
    fun compile(ir: AprlIR): ByteArray {
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
        val mainMethod = classWriter.visitMethod(
            ACC_PUBLIC + ACC_STATIC + ACC_FINAL,
            "main",
            "([Ljava/lang/String;)V",
            null,
            null
        )
        mainMethod.visitCode()
        for (statement in ir.statements) {
            when (statement) {
                is AprlVariableDeclaration -> {
                    mainMethod.visitAprlVariableDeclaration(statement)
                }
                is AprlVariableAssignment -> {
                    mainMethod.visitAprlVariableAssignment(statement)
                }
            }
        }
        for (variable in localVariables.values) {
            mainMethod.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
            mainMethod.visitVarInsn(ALOAD, variable.index)
            mainMethod.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/Object;)V", false)
        }
        mainMethod.visitInsn(RETURN)
        mainMethod.visitMaxs(4, localVariables.size) // TODO: calculate max stack size
        mainMethod.visitEnd()
        classWriter.visitEnd()
        return classWriter.toByteArray()
    }
    
}
