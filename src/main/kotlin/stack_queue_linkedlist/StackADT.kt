package stack_queue_linkedlist

import kotlin.random.Random

class CustomStack<T> {

    private var currentNode: Node? = null
    private var size = 0

    inner class Node(val element: T, var next: Node?)

    fun push(element: T) {
        val previousNode = currentNode
        currentNode = Node(element, previousNode)
        size++
    }

    fun pop(): T? {
        val element = currentNode?.element
        currentNode = currentNode?.next
        --size
        return element
    }

    fun remove() {
        size = 0
        currentNode = null
    }

    fun size() = size

    operator fun iterator(): Iterator<T> = IterateIt()

    private inner class IterateIt : Iterator<T> {
        var curr = currentNode
        override fun hasNext() = curr != null

        override fun next(): T {
            val item = curr?.element
            curr = curr?.next

            return item!!
        }

    }
}

class CustomQueue<T> {
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

class CustomLinkedHashMap {

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

class StackADT {
    private var arrayOfStrings = Array<String?>(size = 1) { "" }

    private var size = 0

    fun isEmpty(): Boolean = size == 0

    fun isNotEmpty(): Boolean = size != 0

    fun size(): Int = size

    companion object {
        fun copy(obj: Array<String?>): Array<String> {
            var temp = Array(size = obj.size) { "" }

            for (i in obj.indices) {
                if (obj[i] != "") {
                    temp[i] = obj[i]!!
                }
            }

           temp = temp.takeWhile { it != "" }.toTypedArray()

            return temp
        }
    }

    fun push(item: String) {
        if (size == arrayOfStrings.size) {
            resize(2 * arrayOfStrings.size)
        }
        arrayOfStrings[size++] = item
    }

    fun pop(): String {
        val item = arrayOfStrings[--size]
        arrayOfStrings[size] = null
        if (size == arrayOfStrings.size / 4 && size > 0) {
            resize(2 / arrayOfStrings.size)
        }
        return item!!
    }

    fun getAll(): Array<String?> {
        return arrayOfStrings
    }

    private fun resize(maxCap: Int) {
        val temp: Array<String?> = Array(size = maxCap) { "" }

        for (i in arrayOfStrings.indices) {
            temp[i] = arrayOfStrings[i]
        }

        arrayOfStrings = temp
    }


    fun printAll() {
        for (i in arrayOfStrings.indices) {
            if (arrayOfStrings[i] != "") {
                println("$i: ${arrayOfStrings[i]}")
            }
        }
    }

}


fun copy() {
    val str = "abcdefghiujklmnoprsutyzqwx"
    var flag = str.length
    val myStack = StackADT()

    while (flag > 0) {
        val random = Random.nextInt(str.length - 1)

        myStack.push(str[random].toString())


        flag--
    }

    val allElement = myStack.getAll()
    val newStack = StackADT.copy(allElement)

    println("newStack: ${newStack.toList()}")
    println("allElement: ${allElement.toList()}")

}