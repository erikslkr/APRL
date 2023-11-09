package aprl.util

typealias LocalVariables = MutableMap<String, LocalVariable>

fun emptyLocalVariables() = mutableMapOf<String, LocalVariable>()

data class LocalVariable(
    val index: Int,
    val isMutable: Boolean,
    val type: Class<*>
)
