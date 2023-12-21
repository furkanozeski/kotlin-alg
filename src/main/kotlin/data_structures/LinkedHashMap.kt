package data_structures

class LinkedHashMap {
    private var head: Node? = null

    private var size = 0

    inner class Node(val item: HashMap<String, String>, val next: Node?)

    fun isEmpty(): Boolean = head == null

    fun size() = size

    fun push(element: HashMap<String, String>) {
        val old = head
        head = Node(element, old)
        size++
    }

    fun pop(): HashMap<String, String>? {
        val element = head?.item
        head = head?.next
        size--

        return element
    }

    operator fun iterator(): Iterator<HashMap<String, String>> {
        return CustomLinkedHasMapIterator()
    }

    inner class CustomLinkedHasMapIterator() : Iterator<HashMap<String, String>> {
        override fun hasNext() = head != null

        override fun next(): HashMap<String, String> {
            val item = head?.item

            head = head?.next

            return item!!
        }

    }
}