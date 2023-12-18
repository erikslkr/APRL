package aprl.util

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token

val ParserRuleContext.positionRange: PositionRange
    get() = PositionRange(
        Position(start.line.toUInt(), start.charPositionInLine.toUInt() + 1U),
        Position(stop.line.toUInt(), stop.charPositionInLine.toUInt() + 1U)
    )

val Token.positionRange: PositionRange
    get() = PositionRange(
        Position(line.toUInt(), charPositionInLine.toUInt()),
        Position(line.toUInt(), charPositionInLine.toUInt() + text.length.toUInt())
    )
