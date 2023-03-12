package collection

fun main() {
    // immutable list
    val strings = listOf("spring", "summer", "fall", "winter")
    println(strings.javaClass)
    // class java.util.Arrays$ArrayList
    // In Java - We can add/remove but we can MODIFY the elements in list
    // In Kotlin - No function to MODIFY the list

    val emptyList = emptyList<String>()
    println(emptyList.javaClass) // class kotlin.collections.EmptyList

    val notNullList = listOfNotNull("hello", null, "bye")
    println(notNullList) // [hello, bye]

    // mutable list
    val arrayList = arrayListOf(1, 2, 4)
    println(arrayList.javaClass) // class java.util.ArrayList
    arrayList.add(8)

    val mutableList = mutableListOf(1, 2, 3)
    println(mutableList.javaClass) // class java.util.ArrayList

    // convert array to list
    val array = arrayOf("a", "b", "c")
    println(array.javaClass)
    val list = array.toList()
    println(list.javaClass)
    println(list)

    mutableList[1] = 1
    // To sum up, use mutableListOf for mutable list and listOf for immutable list
}
