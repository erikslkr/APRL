package aprl.ir

data class AprlIR(
    var name: String? = null,
    val statements: MutableList<AprlStatement> = mutableListOf()
) {
    override fun toString(): String {
        return statements.joinToString("\r\n")
    }
}
