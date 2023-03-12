import java.math.BigDecimal

fun main() {
    // Initialising array
    val names = arrayOf("A", "B", "C")
    println(names)

    val longs = arrayOf<Long>(1, 2, 3)
    println(longs)

    // Initialising array using lambda expression
    val evenNumbers = Array(10) { i -> i * 2 }
    for (num in evenNumbers) {
        println(num)
    }

    // Creating a mixed array
    val mixedArray = arrayOf("hello", 22, BigDecimal(10.5), 'a')
    for (element in mixedArray) {
        println(element)
    }

    // Using primitive type array
    val intArr = IntArray(5) // by default all values are 0

    // Using generic type array
    val genericIntArr = Array<Int>(5) { 0 } // generic type array have to be initialised

    // If values are not known at init time
    val nullArr = arrayOfNulls<Int>(10)

    for (nullElement in nullArr) {
        print(nullElement)
    }
}
