import data_structures.LinkedQueue


var HIZ = 255

fun main(args: Array<String>) {
    val stringValue = "abcdefghijklmnopqrstuvwxtz"

    val queue = LinkedQueue()

   for (i in stringValue) {
       queue.enqueue(i.toString())
   }
    queue.printAll()
}
