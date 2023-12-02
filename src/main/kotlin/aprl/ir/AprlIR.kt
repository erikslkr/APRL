package aprl.ir

data class AprlIR(
    var name: String? = null,
    val globalStatements: MutableList<AprlGlobalStatement> = mutableListOf()
) {
    override fun toString(): String {
        return globalStatements.joinToString("\r\n")
    }
}
