package data_structures

class Queue<T> {
    private var head: Node? = null

    private var tail: Node? = null

    private var size = 0

    inner class Node(val element: T, var next: Node?)

    private fun isEmpty() = head == null

    fun size() = size

    fun enqueue(element: T) {
        val last = tail
        tail = Node(element, null)

        if (isEmpty()) {
            head = tail
        } else {
            last?.next = tail
        }

        size++
    }


    fun dequeue(): T? {
        val item = head?.element
        head = head?.next
        if (isEmpty()) tail = null
        size--
        return item
    }

    operator fun iterator(): Iterator<T?> = CustomQueueIterator()


    private inner class CustomQueueIterator: Iterator<T?> {
        var currentHead = head
        var currentTail = tail
        override fun hasNext(): Boolean = currentHead != null

        override fun next(): T? {
            val item = currentHead?.element
            currentHead = currentHead?.next
            if (isEmpty()) currentTail = null

            return item
        }

    }
}