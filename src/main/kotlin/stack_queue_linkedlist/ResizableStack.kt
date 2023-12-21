package stack_queue_linkedlist

class ResizableStack {

    private var arrayOfStrings: Array<String?> = Array(size = 1) { "" }

    private var size = 0

    fun push(item: String) {
        if (size == arrayOfStrings.size) {
            resize(2 * arrayOfStrings.size)
        }
        arrayOfStrings[size++] = item
    }

    fun pop(): String {
        val item = arrayOfStrings[--size]
        arrayOfStrings[size] = null
        if (size > 0 && size == arrayOfStrings.size / 4) {
            resize(arrayOfStrings.size / 2)
        }
        return item!!
    }

    fun isEmpty() = size == 0

    fun size() = arrayOfStrings.size

    private fun resize(newLength: Int) {
        val temp: Array<String?> = Array(size = newLength) { "" }

        for (i in 0..<size) {
            temp[i] = arrayOfStrings[i]!!
        }

        arrayOfStrings = temp
    }
}