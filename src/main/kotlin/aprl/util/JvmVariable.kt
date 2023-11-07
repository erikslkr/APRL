package aprl.util

/**
 * String: variable name
 * Int: index in local variable stack
 * Boolean: mutable (true) or immutable (false)
 */
typealias LocalVariables = MutableMap<String, Pair<Int, Boolean>>

fun emptyLocalVariables() = mutableMapOf<String, Pair<Int, Boolean>>()

data class JvmVariable(
    val name: String,
    val jvmIndex: Int
)
