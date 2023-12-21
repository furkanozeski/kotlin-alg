package data_structures

class LinkedList {

    private var first: Node? = null

    private var second: Node? = null

    private var size = 0


    private inner class Node(var item: String? = null, var next: Node? = null, var prev: Node? = null)

    fun push(item: String) {
        val last = second

        second = Node(item)

        if (isEmpty()) {
            first = second
        } else {
            last?.next = second
            second?.prev = last
            last?.prev = null
        }

        size++
    }

    fun pop(): String? {
        val item = first?.item
        first = first?.next
        if (isEmpty()) {
            second = null
        }
        size--
        return item
    }

    fun popLast(): String? {
        val item = second?.prev?.next?.item
        second?.prev?.next = null
        second = second?.prev


        return item
    }


    fun isEmpty() = first == null
    fun isTailEmpty() = second == null
}