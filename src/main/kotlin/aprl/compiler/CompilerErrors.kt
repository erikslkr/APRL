package aprl.compiler

import aprl.util.PositionRange

@Suppress("FunctionName")
fun ERROR(message: String, position: PositionRange) {
    // TODO: better error implementation
    val positionString = position.fromPosition.let { "${it.line}:${it.column}" }
    println("${"\u001B[31m"}ERROR (at $positionString): $message ${"\u001B[0m"}")
}

@Suppress("FunctionName")
fun WARNING(message: String, position: PositionRange) {
    // TODO: better warning implementation
    val positionString = position.fromPosition.let { "${it.line}:${it.column}" }
    println("${"\u001B[33m"}WARNING (at $positionString): $message ${"\u001B[0m"}")
}
