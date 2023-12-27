package data_structures

open class LinkedList<T> {

    var head: Node? = null

    var tail: Node? = null

    private var size = 0


    inner class Node(var item: T? = null, var next: Node? = null, var prev: Node? = null)

    fun enqueue(item: T) {
        val last = tail

        tail = Node(item)

        if (isEmpty()) {
            head = tail
        } else {
            last?.next = tail
            tail?.prev = last
            last?.prev = null
        }
    }

    fun push(item: T) {
        head = Node(item, head)

        if (tail == null) {
            tail = head
        }
    }

    fun pop(): T? {
        val item = head?.item
        var currentHead = head
        head = head?.next
        currentHead = null
        if (isEmpty()) {
            tail = null
        }
        size--
        return item
    }

    fun frontToBack() {
        tail?.next = head
        tail = head
        head = head?.next
        tail?.next = null
    }

    fun popLast(): T? {
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
            if (i?.equals(node.item) == true && currentNode?.equals(node) == true) {
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
            if (i?.equals(first.item) == true && current?.equals(first) == true) {
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

    fun remove(linkedList: LinkedList<T>, key: String) {
        if (linkedList.isEmpty()) {
            return
        }

        var current = linkedList.head

        for (i in linkedList) {
            var next = current?.next

            if (next?.item?.equals(key) == true) {
                next = next.next
            }

            current?.next = next
            current = current?.next
        }
    }

    fun isEmpty() = head == null

    fun isTailEmpty() = tail == null

    fun printAll() {
        for (i in this) {
            println(i)
        }
    }

    fun max(node: Node): Int {
        if (isEmpty()) return 0
        if (head!! != node) return 0
        if (head!!.item !is Int && node.item !is Int) return 0

        var maxValue = head?.item as Int

        for (i in this) {
            val value = i as Int
            if (maxValue < value) {
                maxValue = value
            }
        }

        return maxValue
    }


    fun maxRec(node: Node?): Int {
        return maxRecursive(node, node?.item as Int)
    }


    fun reversed(x: Node?): Node? {
        var first = head
        var reverse: Node? = null
        while (first != null) {
            val second = first.next
            first.next = reverse
            reverse = first
            first = second
        }
        head = reverse
        return reverse
    }

    private tailrec fun maxRecursive(node: Node?, number: Int): Int {
        if (node == null) return number
        if (node.item == null) return number
        if (node.next?.item == null) return number

        val next = node.next
        val nodeNumber = (node.next?.item as Int)

        return if (number < nodeNumber) {
            maxRecursive(next, nodeNumber)

        } else if (number > nodeNumber) {
            maxRecursive(next, number)

        } else {
            number
        }
    }

    operator fun iterator(): Iterator<T?> = LinkedListIterator()


    private inner class LinkedListIterator : Iterator<T?> {
        var currentHead = head

        var currentSize = size

        override fun hasNext(): Boolean = currentHead != null

        override fun next(): T? {
            val item = currentHead?.item
            currentHead = currentHead?.next
            size--
            return item
        }
    }
}

fun <T : Any> LinkedList<T>.find(it: T): Boolean {
    var item = false

    for (i in this) {
        if (i == it) {
            item = true
        }
    }

    return item
}


