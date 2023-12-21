import stack_queue_linkedlist.CustomQueue

fun main() {
    val k = 9
    val input= "0123456789"

    val queue = CustomQueue<String>()

    for (i in input) {
        queue.enqueue(i.toString())
    }
//
//    printKthItem(k, queue)


}

fun printKthItem(k: Int, queue: CustomQueue<String>) {
    var lastKth = 0

    for (i in queue) {
        lastKth += 1
        if (k == queue.size() - (lastKth - 1)) {
            println(i)
        }
    }
}


