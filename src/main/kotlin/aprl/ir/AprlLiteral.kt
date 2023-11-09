package aprl.ir

interface AprlLiteral<T: Number> {
    val value: T
    val internalType: Class<out aprl.lang.Number>
}
