package data_structures

class LinkedQueue {

    private var last: Node? = null

    private var size: Int = 0

    private inner class Node(val item: String, var next: Node?)


    fun enqueue(item: String) {
        val node = Node(item, null)

        if (last == null) {
            last = node
            node.next = last
        } else {
            val oldLast = last
            node.next = last?.next
            last = node
            oldLast?.next = last
            last
        }

        size++
    }

    fun printAll() {
        for (i in this) {
            println(i)
        }
    }



    operator fun iterator(): Iterator<String> = CircularLinkedListIterator()


    private inner class CircularLinkedListIterator: Iterator<String> {
        var currentSize = size

        var currentNode = last

        override fun hasNext(): Boolean = currentSize >= 0

        override fun next(): String {
            val item = currentNode!!.item
            currentNode = currentNode?.next
            currentSize--
            return item
        }

    }
}