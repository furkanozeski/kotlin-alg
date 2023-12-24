import data_structures.LinkedList

fun main() {
    val stringValue = "abcdefghijklmnopqrstuvwxtz"
    val linkedList = LinkedList<String>()

    linkedList.push(stringValue[0].toString()) //a
    linkedList.push(stringValue[1].toString()) //b
    linkedList.push(stringValue[2].toString()) //c
    linkedList.push(stringValue[3].toString()) //d
    linkedList.push(stringValue[4].toString()) //e
    linkedList.push(stringValue[5].toString()) //f
    linkedList.push(stringValue[4].toString()) //e
    linkedList.push(stringValue[6].toString()) //g
    linkedList.push(stringValue[4].toString()) //e


    val intLinkedList = LinkedList<Int>()

    intLinkedList.push(10)
    intLinkedList.push(9)
    intLinkedList.push(8)
    intLinkedList.push(11)
    intLinkedList.push(7)
    intLinkedList.push(6)



    println("max: ${intLinkedList.maxRec(intLinkedList.head)}")

}
