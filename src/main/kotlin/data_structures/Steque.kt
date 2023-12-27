package data_structures

class Steque<T> {
    private var head: Node? = null

    private var tail: Node? = null

    private var size: Int = 0


    fun push(item: T) {
        val oldHead = head
        head = Node(item, oldHead)

        if (oldHead == null) {
            tail = head
        }

        size++
    }

    fun enqueue(item: T) {
        val node = Node(item, null)

        if (tail == null) {
            head = node
        }  else {
            tail?.next = node
        }

        tail = node
        size++
    }


    fun pop(): T? {
        if (isHeadEmpty()) return null;

        val item = head?.item
        var oldLeft = head
        head = head?.next
        oldLeft = null
        size--
        return item
    }

    fun printAll() {
        for (i in this) {
            println(i)
        }
    }


    private fun isHeadEmpty() = head == null

    fun isEmpty() = size == 0

    fun isNotEmpty() = size > 0

    inner class Node(var item: T? = null, var next: Node? = null)


    operator fun iterator(): Iterator<T?> = StequeIterator()


    private inner class StequeIterator: Iterator<T?> {

        var currentSize = size

        override fun hasNext(): Boolean = currentSize > 0

        override fun next(): T? {
            val item = head?.item
            head = head?.next
            currentSize--
            return item
        }
    }
}