package data_structures


class ResizableStack {
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

    fun peek(): String? = arrayOfStrings[size - 1]

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