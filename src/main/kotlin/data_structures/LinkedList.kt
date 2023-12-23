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
        size--
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
                size--
                break
            }
            currentNode = currentNode?.next
        }
        currentNode = null
    }

    fun insertAfter(first: Node?, second: Node?) {
        if (first == null || second == null) return

        var current = head

        for (i in this) {
            if (i.equals(first.item) && current?.equals(first) == true) {
                var oldCurrent = current
                second.next = current.next
                current.next = second
                oldCurrent = null
                size++

            }

            current = current?.next
        }
    }

    fun delete(k: Int) {
        if (isEmpty()) return
        if (size < 1) return


        var flag = 1
        var current = head
        for (i in this) {
            if (flag == k - 1 && current?.next != null) {
                current.next = current.next?.next
                size--
                break
            }
            flag++
            current = current?.next
        }

    }

    fun remove(linkedList: LinkedList, key: String) {
        if (isEmpty() || key == null) {
            return
        }

        var current = linkedList.head

        while (current != null) {
            var next = current.next // e

            if (next?.item == key) {
                next = next.next // f
                linkedList.size--
            }
            // e = f
            current.next = next

            // d = f
            current = current.next
        }
    }


    fun isEmpty() = head == null

    fun isTailEmpty() = tail == null

    fun printAll() {
        for (i in this) {
            println(i)
        }
    }

    operator fun iterator(): Iterator<String?> = LinkedListIterator()

    private inner class LinkedListIterator : Iterator<String?> {
        var currentHead = head

        var currentSize = size

        override fun hasNext(): Boolean = currentHead != null

        override fun next(): String? {
            val item = currentHead?.item
            currentHead = currentHead?.next
            size--
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

