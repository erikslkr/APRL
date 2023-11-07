package aprl.util

open class BinaryTree<T>(
    var firstChild: BinaryTree<T>? = null,
    var secondChild: BinaryTree<T>? = null,
    var content: T?
) {
    enum class TraversalOrder {
        PREORDER,
        INORDER,
        POSTORDER
    }
    
    fun traverse(order: TraversalOrder = TraversalOrder.INORDER, action: (T) -> Unit) {
        when (order) {
            TraversalOrder.PREORDER -> {
                content?.let { action(it) }
                firstChild?.traverse(order, action)
                secondChild?.traverse(order, action)
            }
            TraversalOrder.INORDER -> {
                firstChild?.traverse(order, action)
                content?.let { action(it) }
                secondChild?.traverse(order, action)
            }
            TraversalOrder.POSTORDER -> {
                firstChild?.traverse(order, action)
                secondChild?.traverse(order, action)
                content?.let { action(it) }
            }
        }
    }
    
    fun toList(): List<T> {
        val list = mutableListOf<T>()
        traverse { list.add(it) }
        return list
    }
    
    companion object {
        fun <T> leaf(content: T): BinaryTree<T> {
            return BinaryTree(null, null, content)
        }
    }
}

