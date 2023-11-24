package aprl.ir

import aprl.grammar.AprlParser.TypeContext

data class AprlTypeReference(
    var identifier: AprlIdentifier?,
    override val context: TypeContext
) : AprlNode<TypeContext> {

    val javaType: Class<*> // TODO: implement AprlType.javaType properly
        get() = when (identifier!!.identifiers.joinToString(".")) {
            "Int" -> aprl.lang.Int::class.java
            "Float" -> aprl.lang.Float::class.java
            "Boolean" -> aprl.lang.Boolean::class.java
            "Char" -> aprl.lang.Char::class.java
            "String" -> aprl.lang.String::class.java
            else -> Any::class.java
        }

    override fun toString(): String {
        return identifier.toString()
    }

}
