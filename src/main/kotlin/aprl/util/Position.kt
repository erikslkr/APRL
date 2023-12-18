package aprl.util

data class Position(
    val line: UInt,
    val column: UInt
) : Comparable<Position> {
    
    override fun compareTo(other: Position): Int {
        return if (line > other.line) {
            1
        } else if (line < other.line) {
            -1
        } else if (column > other.line) {
            1
        } else if (column < other.line) {
            -1
        } else {
            0
        }
    }
    
}
