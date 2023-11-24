package aprl.util

import aprl.compiler.PositionRange
import org.antlr.v4.runtime.ParserRuleContext

val ParserRuleContext.positionRange: PositionRange
    get() = (start.line to start.charPositionInLine + 1) to (stop.line to stop.charPositionInLine + 1)
