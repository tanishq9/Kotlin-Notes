package generics

import java.math.BigDecimal

fun main() {
    val bdList = mutableListOf(
        BigDecimal(33.45),
        BigDecimal(3.9),
        BigDecimal(10)
    )
    // println(bdList)
    println(printCollection(bdList))
    println(bdList.javaClass)
    bdList.print()

    printCollection(bdList)
}

// T is called type parameter
fun <T> printCollection(collection: List<T>): List<T> {
    for (item in collection) {
        println(item)
    }
    return collection
}

// Lets make extension function for above
fun <T> List<T>.print() {
    for (item in this) {
        println(item)
    }
}
