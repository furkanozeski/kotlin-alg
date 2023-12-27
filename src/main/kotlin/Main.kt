import data_structures.LinkedList

var HIZ = 255

fun main(args: Array<String>) {
    val stringValue = "abcdefghijklmnopqrstuvwxtz"
    val linkedList = LinkedList<String>()

    for (i in stringValue) {
//        linkedList.enqueue(i.toString())
    }
    linkedList.enqueue("a")
    linkedList.enqueue("b")
    linkedList.enqueue("c")
    linkedList.enqueue("d")

    linkedList.pop()


//    val newList =linkedList.reversed(linkedList.head)
//    var curr = newList
//    while (curr != null) {
//
//        println("reversed: ${curr.item}")
//        curr = curr.next
//    }

    linkedList.printAll()
}
