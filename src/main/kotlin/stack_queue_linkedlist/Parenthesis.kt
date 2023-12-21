package stack_queue_linkedlist

class Parenthesis {
    private val listOfParenthesis = mutableListOf<String>()
    private var n: Int = 0


    fun push(item: String) {
        n++
        listOfParenthesis.plusAssign(item)
    }

    fun pop(): String {
        if (!isEmpty()) {
            return listOfParenthesis[--n]
        }

        throw NullPointerException()
    }

    fun isEmpty(): Boolean {
        return n == 0
    }

    fun peek(): String {
        return listOfParenthesis[n - 1]
    }

    fun size(): Int {
        return n
    }

    fun clear() {
        listOfParenthesis.clear()
        n = 0
    }

    fun printAll() {
        for (parenthesis in listOfParenthesis) {
            println(parenthesis)
        }
    }

}