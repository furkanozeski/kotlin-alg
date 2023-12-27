package data_structures

class Deque<T> {

    private var head: Node? = null

    private var tail: Node? = null

    private var size: Int = 0


    fun pushLeft(item: T) {
        val oldHead = head
        head = Node(item, oldHead)

        size++
    }

    fun pushRight(item: T) {
        val oldTail = tail
        tail = Node(item, oldTail)

        size++
    }


    fun popLeft(): T? {
        val item = head?.item
        var currentHead = head
        head = head?.next
        currentHead = null
        if (isHeadEmpty()) {
            tail = null
        }
        return item
    }

    fun popRight(): T? {
        if (isTailEmpty()) return null;
        val item = tail?.item
        var currentHead = tail
        tail = tail?.next
        currentHead = null
        if (isTailEmpty()) {
            head = null
        }
        return item
    }

    private fun isHeadEmpty() = head == null

    private fun isTailEmpty() = tail == null

    fun isEmpty() = size == 0

    fun isNotEmpty() = size > 0

    fun printAll() {
        for (i in this) {
            println(i)
        }
    }

    inner class Node(var item: T? = null, var next: Node? = null)

    operator fun iterator(): Iterator<T?> = DequeIterator()

    private inner class DequeIterator() : Iterator<T?> {

        private var currentSize = size

        private var currentHead = head

        private var currentTail = tail

        override fun hasNext(): Boolean = currentSize > 0

        override fun next(): T? {
            val oldHead = currentHead
            val oldTail = currentTail
            val item = if (oldHead != null) {
                oldHead.item
            } else {
                oldTail?.item
            }

            if (oldHead != null) {
                currentHead = currentHead?.next
            } else {
                currentTail = currentTail?.next
            }

            currentSize--
            return item
        }

    }
}