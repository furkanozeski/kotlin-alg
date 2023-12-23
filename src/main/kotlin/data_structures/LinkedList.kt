package data_structures

open class LinkedList {

    var head: Node? = null

    var tail: Node? = null

    private var size = 0


    inner class Node(var item: String? = null, var next: Node? = null, var prev: Node? = null)

    fun push(item: String) {
        val last = tail

        tail = Node(item)

        if (isEmpty()) {
            head = tail
        } else {
            last?.next = tail
            tail?.prev = last
            last?.prev = null
        }

        size++
    }

    fun pop(): String? {
        val item = head?.item
        head = head?.next
        if (isEmpty()) {
            tail = null
        }
        size--
        return item
    }

    fun popLast(): String? {
        val item = tail?.prev?.next?.item
        tail?.prev?.next = null
        tail = tail?.prev

        return item
    }

    fun removeAfter(node: Node?) {
        if (isEmpty() && node == null) return
        if (node?.next == null) return

        var currentNode = head
        var oldNode = node


        for (i in this) {
            if (i.equals(node.item) && currentNode?.equals(node) == true) {
                currentNode.next = node.next?.next
                oldNode = null
                size --
                break
            }
            currentNode = currentNode?.next
        }
    }

    fun isEmpty() = head == null

    fun isTailEmpty() = tail == null

    fun delete(k: Int): String? {
        var item: String? = null
        var flag = 0
        for (i in this) {
            flag++

            if (k == flag) {
                item = i
            }
        }

        return item
    }

    fun printAll() {
        for (i in this) {
            println(i)
        }
    }

    operator fun iterator(): Iterator<String?> = LinkedListIterator()

    private inner class LinkedListIterator : Iterator<String?> {
        var currentHead = head
        override fun hasNext(): Boolean = currentHead != null

        override fun next(): String? {
            val item = currentHead?.item
            currentHead = currentHead?.next
            return item
        }
    }
}

fun LinkedList.find(it: String): Boolean {
    var item = false

    for (i in this) {
        if (i == it) {
            item = true
        }
    }

    return item
}

