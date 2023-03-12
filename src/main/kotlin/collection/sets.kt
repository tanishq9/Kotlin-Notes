package collection

fun main() {
    val set = setOf(1, 2, 2, 3)
    println(set.javaClass)
    println(set)
    set.plusElement(4) // doesn't change existing set
    println(set)
    println(set.average())

    val mutableSet = mutableSetOf(1, 2, 2, 3)
    mutableSet.plus(10) // doesn't change existing mutable set
    println(mutableSet)
}
