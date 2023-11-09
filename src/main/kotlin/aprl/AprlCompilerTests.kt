package aprl

import java.io.FileOutputStream

fun main() {
    val input = """
        val a = 0 & 1
    """.trimIndent()
    val inputFileName = "Output"
    val settings = AprlCompilerSettings(
        printIR = false,
        inspectAST = false
    )
    val irCompiler = AprlIRCompiler(settings)
    val ir = irCompiler.compile(input)
    ir.name = inputFileName
    // TODO: set ir.name to name of input file
    val bytecodeCompiler = AprlJvmBytecodeCompiler(settings)
    val bytecode = bytecodeCompiler.compile(ir)
    try {
        val outputStream = FileOutputStream("E:/test/${inputFileName}.class")
        outputStream.write(bytecode)
        outputStream.close()
    } catch (ex: Exception) {
        println("Error generating class file 'E:/test/${inputFileName}.class'")
    }
}
