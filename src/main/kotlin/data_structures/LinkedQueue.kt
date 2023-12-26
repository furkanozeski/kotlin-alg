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
            node.next = last?.next
            last?.next = node
        }

    }
}