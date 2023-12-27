import data_structures.Deque

var HIZ = 255

fun main(args: Array<String>) {
    val stringValue = "abcdefghijklmnopqrstuvwxtz"
    val deque = Deque<String>()
    deque.pushLeft("-1")
    deque.pushLeft("0")
    deque.pushRight("a")
    deque.pushLeft("1")
    deque.pushLeft("2")
    deque.pushRight("b")
    deque.pushRight("c")
    deque.pushLeft("3")
    deque.pushRight("d")
    deque.pushLeft("4")


    deque.printAll()

}
