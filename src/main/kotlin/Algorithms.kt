import java.util.*
import kotlin.math.abs

// 1.1.5
fun isBetween(a: Double, b: Double) {
    if (a in 0.0..1.0 && b in 0.0..1.0) {
        print("true")
    } else {
        print("false")
    }
}

// 1.1.11
fun booleanArr(arr: Array<BooleanArray>) {
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (arr[i][j]) {
                print("*")
            } else {
                print(" ")
            }
        }
        println()
    }
}

// 1.1.13
fun transpose(arr: Array<Array<Int>>): Array<Array<Int>> {
    val copyArr = arr.copyOf()

    for (i in copyArr.indices) {
        for (j in (i + 1)..<copyArr[i].size) {
            val temp = copyArr[i][j]
            copyArr[i][j] = copyArr[j][i]
            copyArr[j][i] = temp
        }
    }

    return copyArr
}

// 1.1.15
fun histogram(a: IntArray, m: Int): IntArray {
    val newArr = IntArray(size = m) { 0 }

//    for (i in a.indices) {
//        for (j in (i + 1)..<a.size) {
//            if (a[i] == a[j]) {
//                val index = (i) % (newArr.size)
//                newArr[index]++
//            }
//        }
//    }
    for (i in a.indices) {
        newArr[a[i]]++
    }

    return newArr
}


// 1.1.20
fun factorial(n: Int): Int {
    if (n < 1) return 1;

    return factorial(n - 1) * n
}

// 1.1.21
fun table(args: Array<String>) {
    var names = arrayOf<String>()
    var numbers = arrayOf<Int>()

    for (i in args.indices) {
        if (i % 3 == 0) {
            names = names.plus(args[i])
            continue
        }
        numbers = numbers.plus(args[i].toInt())
    }

    var avg: Double
    print("Name   | Score   | Score   | AVG   \n")
    for (name in names) {
        print(name)
        for (number in 0..numbers.size) {
            if (number > 0 && number % 2 == 0) {
                avg = numbers[number - 2].toDouble() / numbers[number - 1].toDouble()
                numbers = numbers.drop(number).toTypedArray()
                print("\t $avg")
                break
            }
            print("\t ${numbers[number]} ")
        }
        println()
    }
}

// 1.1.22
fun binarySearch(key: Int, arr: Array<Int>, lo: Int, hi: Int, depth: Int): Int {
//    println("lo: $lo, hi: $hi, depth: $depth")
    if (lo > hi) return -1
    val mid = lo + (hi - lo) / 2
    return if (key > arr[mid]) binarySearch(key, arr, mid + 1, hi, depth + 1)
    else if (key < arr[mid]) binarySearch(key, arr, lo, mid - 1, depth + 1)
    else mid
}

// 1.1.24
fun gcd(p: Int, q: Int): Int {
    if (q == 0) return p
    val r = p.rem(q)
    return gcd(q, r)
}

// 1.1.28
fun deduplicate(arr: Array<Int>): Array<Int> {
    var duplicateCount = 0
    for (i in arr.indices) {
        val value = binarySearch(arr[i], arr, i + 1, arr.size - 1, 0)

        if (value != -1) {
            duplicateCount++
            arr[value] = 0
            arr.sort()
        }
    }

    val newArr = Array<Int>(arr.size - duplicateCount) { 0 }

    for (i in arr.indices) {
        val index = (i - duplicateCount + newArr.size) % newArr.size
        newArr[index] = arr[i]

    }

    return newArr
}

fun deduplicate2(arr: Array<Int>): Array<Int> {
    var index = 0
    val newArr = Array(arr.size) { 0 }
    newArr[0] = arr[0]

    for (i in 1..<arr.size) {
        if (arr[i] != newArr[index]) {
            index++
            newArr[index] = arr[i]
        }
    }

    return newArr.copyOfRange(0, ++index)
}

fun deduplicate3(arr: Array<Int>): Array<Int> {
    var duplicateCount = 0
    for (i in 0..<arr.size - 1) {
        if (arr[i] == arr[i + 1]) {
            arr[i] = 0
            duplicateCount++
        }

    }


    arr.sort()

    val newArr = Array(arr.size - duplicateCount) { 0 }

    for (i in arr.indices) {
        val index = abs((i - duplicateCount + newArr.size) % newArr.size)
        newArr[index] = arr[i]

    }

    return newArr
}

// 1.1.29
fun rank(key: Int, arr: Array<Int>): Array<Int> {
    val index = binarySearch(key, arr, 0, arr.size - 1, 0)
    return if (index > 0) {
        arr.copyOfRange(0, index)
    } else {
        arrayOf()
    }
}

fun count(key: Int, arr: Array<Int>): Int {
    val index = binarySearch(key, arr, 0, arr.size - 1, 0)
    val sameValues = mutableListOf<Int>()
    for (i in arr.indices) {
        if (arr[i] == arr[index]) {
            sameValues.plusAssign(arr[i])
        }
    }
    return sameValues.count()
}

// 1.1.30
fun arrays(): Array<Array<Boolean>> {
    val demo = arrayOf(
        arrayOf(true, true, true, true),
        arrayOf(true, true, true, true),
        arrayOf(true, true, true, true),
        arrayOf(true, true, true, true),
    )

    for (i in demo.indices) {
        for (j in demo[i].indices) {
            demo[i][j] = gcd(i, j) == 1
        }
    }

    return demo
}


fun stairWayToTheHeaven(num: Int) {
    val halfWay = num / 2
    for (i in 0..num) {

        if (i < halfWay) {
            print("${repeatString(" ", i)}$${repeatString(" ", (halfWay - i) * 2)}#\n")
        } else {
            print("${repeatString(" ", (num - i))}#${repeatString(" ", (i - halfWay) * 2)}$\n")
        }
    }

}

fun repeatString(str: String, numberOf: Int): String {
    if (numberOf == 1) {
        return str
    }

    if (numberOf <= 0) {
        return ""
    }

    return (str + repeatString(str, numberOf - 1))
}


fun isPowerOfTwo(n: Int): Boolean {

    return n > 0 && n.and(n - 1) == 0
}

fun guessNumber1(n: Int): Int {
//    println(guessNumber2(2126753390))
    var lo = 0
    var hi = n

    var res = 0
    while (lo <= hi) {
        val mid = lo + (hi - lo) / 2
        val result = guess(mid)

        when (result) {
            -1 -> {
                hi = mid - 1
            }

            1 -> {
                lo = mid + 1
            }

            else -> {
                res = mid
                break
            }
        }

    }

    return res
}


fun guessNumber2(n: Int): Int {
    var mid = n / 2
    val result = guess(mid)
    return when (result) {
        -1 -> {
            guessNumber2(n - (mid / 2))
        }

        1 -> {
            mid += 1
            guessNumber2(n + (mid / 2))
        }

        else -> {
            mid
        }
    }
}

fun guess(mid: Int): Int {
    val pick = 10
//    val pick = 1702766719
    if (pick == mid) {
        return 0
    } else if (pick > mid) {
        return 1
    }

    return -1
}


class NumArray(nums: IntArray) {
    private val numbers = nums
    fun sumRange(left: Int, right: Int): Int {
        var sum = 0
        for (i in left..right) {
            sum += numbers[i]
        }

        return sum
    }
}


class MyStack() {
    private val mutableList = mutableListOf<Int>()
    private var n = 0
    private var top = 0

    fun push(x: Int) {
        mutableList.plusAssign(x)
        n += 1
    }

    fun pop(): Int {
        val result = mutableList.removeAt(n - 1)
        n -= 1
        return result
    }

    fun top(): Int {
        top = mutableList[n - 1]
        return top
    }

    fun empty(): Boolean {
        return n == 0
    }

}

fun reverseWords(s: String): String {
    val sB = StringBuilder()
    for (i in s.split(' ').reversed()) {
        if (i != "") {
            sB.append("$i ")
        }
    }
    return sB.toString().trim(' ')
}


fun dijkstra(args: Array<String>) {
    val ops = mutableListOf<String>()
    val values = mutableListOf<Int>()
    for (value in args) {
        if (value == "(") ;
        else if (value == "*") ops.plusAssign("*")
        else if (value == "/") ops.plusAssign("/")
        else if (value == "+") ops.plusAssign("+")
        else if (value == "-") ops.plusAssign("-")
        else if (value == ")") {
            val op = ops.removeLast()
            var v = values.removeLast()
            if (op == "*") v *= values.removeLast()
            else if (op == "/") v /= values.removeLast()
            else if (op == "+") v += values.removeLast()
            else if (op == "-") v -= values.removeLast()
            values.plusAssign(v)
        } else {
            values.plusAssign(value.toInt())
        }
    }
    println(values.toString())
}


class FixedStackOfString(cap: Int) {
    private var n: Int = 0
    private val capacity = cap
    private val arrayOfStrings = Array(capacity) { "" }

    fun push(item: String) {
        if (!isFull()) {
            arrayOfStrings[n++] = item
        } else {
            throw ArrayStoreException()
        }
    }


    fun pop(): String {
        if (!isEmpty()) {
            return arrayOfStrings[--n]
        }

        throw IndexOutOfBoundsException()
    }

    fun size(): Int {
        return n
    }

    fun isEmpty(): Boolean {
        return n == 0
    }

    fun isFull(): Boolean {
        return arrayOfStrings.size != capacity
    }
}


fun infixToPostfix(value: String): String {
    val numbers = Stack<Int>()
    val ops = Stack<Char>()
    val expression = Stack<String>()
    for (i in value) {
        if (i == '(') {
            continue
        } else if (
            i == '+' ||
            i == '*' ||
            i == '/' ||
            i == '-'
        ) {
            ops.push(i)
        } else if (i == ')') {
            val op = ops.pop()
            val num1 = numbers.pop()
            val num2 = numbers.pop()

            if (num2 != null && num1 != null) {
                expression.push(
                    "$op$num1$num2"
                )
            }
        } else {
            numbers.push(i.digitToInt())
        }
    }

    if (ops.size != 0) {
        val exp1 = expression.pop()
        val exp2 = expression.pop()
        val exp3 = expression.pop()
        val op1 = ops.pop()
        val op2 = ops.pop()
        expression.removeAll(arrayOf(exp1, exp2).toSet())
        expression.push("$op1($exp1)($op2($exp2)($exp3))")
    }
    val stringBuilder = StringBuilder()
    for (i in expression) {
        stringBuilder.append(i)
    }

    return stringBuilder.toString()
}

fun evaluatePostfix(value: String): Double {
    val numbers = Stack<Double>()
    val ops = Stack<Char>()

    for (i in value) {
        if (i == '(') {
            continue
        } else if (
            i == '+' ||
            i == '*' ||
            i == '/' ||
            i == '-'
        ) {
            ops.push(i)
        } else if (i == ')') {
            val op = ops.pop()
            val num1 = numbers.pop()
            val num2 = numbers.pop()
            numbers.push(eval(op.toString(), num1, num2))

        } else {
            numbers.push(i.digitToInt().toDouble())
        }
    }

    return if (ops.isNotEmpty() && numbers.isNotEmpty()) {
        val op = ops.pop()
        val num1 = numbers.pop()
        val num2 = numbers.pop()
        numbers.removeAll(arrayOf(num1, num2).toSet())
        numbers.push(eval(op.toString(), num1, num2))
        numbers.pop()
    } else {
        0.0
    }
}

fun eval(op: String, a: Double, b: Double): Double {
    return when (op) {
        "+" -> {
            (a + b).toDouble()
        }

        "-" -> {
            (a - b).toDouble()
        }

        "/" -> {
            (a / b).toDouble()
        }

        "*" -> {
            (a * b).toDouble()
        }

        else -> {
            0.toDouble()
        }
    }
}