package aprl.compiler

data class AprlCompilerSettings(
    var printIR: Boolean = false,
    var inspectAST: Boolean = false,
    var warnings: AprlWarningsLevel = AprlWarningsLevel.ALL
)
