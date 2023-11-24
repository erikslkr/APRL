package aprl.compiler

typealias Position = Pair<Int, Int>
typealias PositionRange = Pair<Position, Position>

@Suppress("FunctionName")
fun ERROR(message: String, position: PositionRange? = null) {
    // TODO: better error implementation
    val positionString = position?.first?.let { "${it.first}:${it.second}" } ?: "unknown position"
    println("${"\u001B[31m"}ERROR (at $positionString): $message ${"\u001B[0m"}")
}

@Suppress("FunctionName")
fun WARNING(message: String, position: PositionRange? = null) {
    // TODO: better warning implementation
    val positionString = position?.first?.let { "${it.first}:${it.second}" } ?: "unknown position"
    println("${"\u001B[33m"}WARNING (at $positionString): $message ${"\u001B[0m"}")
}
