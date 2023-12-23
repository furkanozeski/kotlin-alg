import data_structures.LinkedList
import data_structures.find

fun main() {

    val value = "abcdefghijklmnopqrstuvwxtz"

    val linkedList = LinkedList()

    linkedList.push(value[0].toString()) //a
    linkedList.push(value[1].toString()) //b
    linkedList.push(value[2].toString()) //c
    linkedList.push(value[3].toString()) //d
    linkedList.push(value[4].toString()) //e
    linkedList.push(value[5].toString()) //f

    //delete
//    println("delete: ${linkedList.delete(7)}")
    //find
    println("find: ${linkedList.find("yu")}")
}





