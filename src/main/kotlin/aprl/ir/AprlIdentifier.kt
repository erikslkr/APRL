package aprl.ir

data class AprlIdentifier(
    val identifiers: MutableList<String> = mutableListOf()
) : AprlEvaluable {
    override fun toString(): String {
        return identifiers.joinToString(".")
    }
}
