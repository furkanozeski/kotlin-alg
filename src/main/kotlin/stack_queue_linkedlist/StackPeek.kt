package stack_queue_linkedlist

class StackPeek {

    private var first: Node? = null

    private var size: Int = 0

    private inner class Node(val item: String?, val next: Node?)

    fun push(item: String) {
        val oldFirst = first
        first = Node(
            item = item,
            next = oldFirst
        )
        size++
    }

    fun pop(): String? {
        val item = first?.item
        first = first?.next
        size--
        return item
    }

    fun size() = size

    fun isEmpty() = size == 0

    fun peek(): String? {
        return first?.item
    }

    operator fun iterator(): Iterator<String?> {
        return StackIterator()
    }

    private inner class StackIterator() : Iterator<String?> {

        private var current = first

        override fun hasNext(): Boolean {
            return current != null
        }

        override fun next(): String? {
            val item = current?.item
            current = current?.next
            return item
        }

    }
}