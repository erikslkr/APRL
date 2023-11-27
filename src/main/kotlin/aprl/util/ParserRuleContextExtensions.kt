package aprl.util

import aprl.compiler.PositionRange
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token

val ParserRuleContext.positionRange: PositionRange
    get() = (start.line to start.charPositionInLine + 1) to (stop.line to stop.charPositionInLine + 1)

val Token.positionRange: PositionRange
    get() = (line to charPositionInLine) to (line to charPositionInLine + text.length)
