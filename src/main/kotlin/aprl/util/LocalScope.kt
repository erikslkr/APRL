package aprl.util

class LocalScope(val parent: LocalScope? = null) {
    val localVariables = emptyLocalVariables()
    var hasDefinitelyReturned = false
    
    val depth: Int
        get() {
            var parent = parent
            var depth = 0
            while (parent != null) {
                depth++
                parent = parent.parent
            }
            return depth
        }
}
