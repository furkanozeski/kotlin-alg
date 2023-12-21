package data_structures

class ResizableArrayQueueOfStrings(capacity: Int) {

    private var arrayOfStrings: Array<String?> = Array(size = capacity) { "" }

    private var size = 0

    fun enqueue(item: String) {
        if (size == arrayOfStrings.size) {
            resize(2 * arrayOfStrings.size)
        }
        arrayOfStrings[size++] = item
    }

    fun dequeue(): String? {
        val item = arrayOfStrings[--size]
        arrayOfStrings[size] = null
        if (size == arrayOfStrings.size / 4) {
            resize(2 / arrayOfStrings.size)
        }

        return item
    }

    fun peek(): String? {
        return if (!isEmpty()) {
            arrayOfStrings[size - 1]!!
        } else {
            null
        }
    }


    fun isEmpty() = size == 0

    fun isFull() = arrayOfStrings.size == size


    private fun resize(maxCap: Int) {
        val temp: Array<String?> = Array(size = maxCap) { "" }
        for (i in arrayOfStrings.indices) {
            temp[i] = arrayOfStrings[i]
        }

        arrayOfStrings = temp
    }

    operator fun iterator(): Iterator<String?> = ArrayQueueIterator()

    private inner class ArrayQueueIterator(): Iterator<String?> {
        val currentArr = arrayOfStrings.clone()
        var currentSize = 0
        override fun hasNext(): Boolean = currentArr.size != currentSize

        override fun next(): String? =  currentArr[currentSize++]

    }
}