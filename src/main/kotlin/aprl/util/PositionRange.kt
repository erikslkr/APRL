package aprl.util

data class PositionRange(
    val fromPosition: Position,
    val toPosition: Position
) {

    fun join(other: PositionRange): PositionRange {
        return PositionRange(minOf(fromPosition, other.fromPosition), minOf(toPosition, other.toPosition))
    }

}
