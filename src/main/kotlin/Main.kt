import data_structures.Steque

var HIZ = 255

fun main(args: Array<String>) {
    val stringValue = "abcdefghijklmnopqrstuvwxtz"
    val steque = Steque<String>()

    steque.push("a")
    steque.enqueue("1")
    steque.enqueue("2")
    steque.push("b")
    steque.push("c")
    steque.enqueue("3")
    steque.push("d")
    steque.enqueue("4")


    steque.printAll()

}
