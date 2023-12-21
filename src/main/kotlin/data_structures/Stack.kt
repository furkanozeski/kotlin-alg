package data_structures

class Stack {
    private val listOfStrings = mutableListOf<String>()
    private var n: Int = 0


    fun push(item: String) {
        n++
        listOfStrings.plusAssign(item)
    }

    fun pop(): String {
        if (!isEmpty()) {
            return listOfStrings[--n]
        }

        throw NullPointerException()
    }

    fun isEmpty(): Boolean {
        return n == 0
    }

    fun peek(): String {
        return listOfStrings[n - 1]
    }

    fun size(): Int {
        return n
    }

    fun clear() {
        listOfStrings.clear()
        n = 0
    }

    fun printAll() {
        for (parenthesis in listOfStrings) {
            println(parenthesis)
        }
    }

    operator fun iterator(): Iterator<String> = IterateIt()

    private inner class IterateIt : Iterator<String> {
        var curr = listOfStrings

        var currSize = 0
        override fun hasNext() = curr.size != currSize

        override fun next(): String = listOfStrings[currSize++]

    }

}