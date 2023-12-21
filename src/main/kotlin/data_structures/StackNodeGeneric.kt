package data_structures

class StackNodeGeneric<T>  {

    private var currentNode: Node? = null
    private var size = 0

    inner class Node(val element: T, var next: Node?)

    fun push(element: T) {
        val previousNode = currentNode
        currentNode = Node(element, previousNode)
        size++
    }

    fun pop(): T? {
        val element = currentNode?.element
        currentNode = currentNode?.next
        --size
        return element
    }

    fun remove() {
        size = 0
        currentNode = null
    }

    fun size() = size

    operator fun iterator(): Iterator<T> = IterateIt()

    private inner class IterateIt : Iterator<T> {
        var curr = currentNode
        override fun hasNext() = curr != null

        override fun next(): T {
            val item = curr?.element
            curr = curr?.next

            return item!!
        }

    }
}