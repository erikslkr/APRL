package aprl.ir

data class AprlType(
    var identifier: AprlIdentifier?
) {

    val javaType: Class<*> // TODO: implement AprlType.javaType properly
        get() = when (identifier!!.identifiers.joinToString(".")) {
            "Int" -> aprl.lang.Int::class.java
            "Float" -> aprl.lang.Float::class.java
            "Boolean" -> aprl.lang.Boolean::class.java
            "Char" -> aprl.lang.Char::class.java
            "String" -> aprl.lang.String::class.java
            else -> Any::class.java
        }

}
