package aprl.ir

import aprl.grammar.AprlParser.ValueArgumentsContext

data class AprlValueArguments(
    val valueArguments: MutableList<AprlValueArgument>,
    override val context: ValueArgumentsContext
) : AprlUnaryPostfix<ValueArgumentsContext>
