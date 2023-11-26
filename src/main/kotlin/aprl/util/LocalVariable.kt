package aprl.util

import aprl.ir.AprlVariableDeclaration

typealias LocalVariables = MutableMap<String, LocalVariable>

fun emptyLocalVariables(): LocalVariables = mutableMapOf()

data class LocalVariable(
    val index: Int,
    val isMutable: Boolean,
    val type: Class<*>,
    var initialized: Boolean,
    val originalDeclaration: AprlVariableDeclaration
)
