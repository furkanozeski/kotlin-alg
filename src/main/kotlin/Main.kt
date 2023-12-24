import data_structures.LinkedList

fun main() {
    val value = "abcdefghijklmnopqrstuvwxtz"

    val linkedList = LinkedList()

    linkedList.push(value[0].toString()) //a
    linkedList.push(value[1].toString()) //b
    linkedList.push(value[2].toString()) //c
    linkedList.push(value[3].toString()) //d
    linkedList.push(value[4].toString()) //e
    linkedList.push(value[5].toString()) //f
    linkedList.push(value[4].toString()) //e
    linkedList.push(value[6].toString()) //g
    linkedList.push(value[4].toString()) //e

    linkedList.printAll()
}
