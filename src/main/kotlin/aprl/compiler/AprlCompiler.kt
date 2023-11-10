package aprl.compiler

import java.io.File
import java.io.FileOutputStream

object AprlCompiler {
    
    enum class CommandLineFlag {
        DIRECTORY
    }
    
    const val VERSION = 0.1
    
    private val settings = AprlCompilerSettings()
    
    private lateinit var inFile: File
    private lateinit var outFile: File
    
    @JvmStatic
    fun main(args: Array<String>) {
        var helpFlag = false
        var versionFlag = false
        var currentFlag: CommandLineFlag? = null
        
        var inputFileName: String? = null
        var outDirectory: File? = null
        
        for (arg in args) {
            if (arg.startsWith("-")) {
                when (arg) {
                    "-h", "--h", "-help", "--help" -> {
                        helpFlag = true
                    }
                    "-v", "-version" -> {
                        versionFlag = true
                    }
                    "-d", "-dir", "-directory" -> {
                        currentFlag = CommandLineFlag.DIRECTORY
                    }
                    else -> {
                        println("Unknown flag: $arg")
                        println("Use --help to list all available options")
                        return
                    }
                }
            } else {
                when (currentFlag) {
                    CommandLineFlag.DIRECTORY -> {
                        outDirectory = File(arg)
                        if (outDirectory.exists() && !outDirectory.isDirectory) {
                            println("Specified output path is not a directory: '$arg'")
                            return
                        }
                        if (!outDirectory.exists() && !outDirectory.mkdirs()) {
                            println("Failed to create output directory: '${outDirectory.absolutePath}'")
                            return
                        }
                        currentFlag = null
                    }
                    else -> {
                        inputFileName = arg
                    }
                }
            }
        }
        
        if (helpFlag || inputFileName == null) {
            help()
        }
        
        inFile = File(inputFileName ?: return)
        
        if (!inFile.exists()) {
            println("No such file: '${inFile.absolutePath}'")
            return
        }
        if (!inFile.absolutePath.endsWith(".aprl")) {
            println("Source file is not an APRL file: '${inFile.absolutePath}' (file extension should be .aprl)")
            return
        }
        
        outFile = if (outDirectory == null) {
            val dir = inFile.absolutePath.replaceAfterLast(File.separator, "")
            File("${dir}${inFile.nameWithoutExtension}.class")
        } else {
            File("${outDirectory.absolutePath}${File.separator}${inFile.nameWithoutExtension}.class")
        }
        
        if (versionFlag) {
            println("APRL Version: $VERSION")
        }
        
        compile()
    }
    
    private fun compile() {
        val sourceCode = inFile.readText()
        val ir = AprlIRCompiler(settings).compile(sourceCode)
        ir.name = inFile.nameWithoutExtension
        val bytecode = AprlJvmBytecodeCompiler(settings).compile(ir)
        try {
            val outputStream = FileOutputStream(outFile)
            outputStream.write(bytecode)
            outputStream.close()
        } catch (ex: Exception) {
            println("Error generating class file '${outFile.absolutePath}'")
        }
    }
    
    private fun help() {
        println("""
            Usage: aprl [options] <source file>
            
            Available options:
                -h -help --h --help
                        Shows this help dialogue
                -d <Directory>
                        Writes generated class files to the specified directory
        """.trimIndent())
    }
    
}
