import data_structures.ResizableArrayQueueOfStrings

fun main() {

    val value = "abcdefghijklmnopqrstuvwxtz"

    val stringQueue = ResizableArrayQueueOfStrings(10)

    for (i in value) {
        stringQueue.enqueue(i.toString())
    }

    for (i in stringQueue) {
        println("string queue value: $i")
    }

}



