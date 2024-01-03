package aprl.util

import aprl.ir.AprlVariableDeclaration
import java.lang.reflect.Type

typealias LocalVariables = MutableMap<String, LocalVariable>

fun emptyLocalVariables(): LocalVariables = mutableMapOf()

data class LocalVariable(
    val index: Int,
    val isMutable: Boolean,
    val type: Type,
    var initialized: Boolean,
    val originalDeclaration: AprlVariableDeclaration
)
