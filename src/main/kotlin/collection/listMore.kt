package collection

fun main() {
    val strings = listOf("spring", "summer", "fall", "winter")

    // Exploring list function added specific for Kotlin

    println(strings.last())
    println(strings[0])
    println(strings.asReversed())
    println(strings)

    if (strings.size > 5) {
        println(strings[5])
    }

    // Alternate to above (specific kotlin)
    println(strings.getOrNull(5))
    println(strings.getOrElse(5) { it }) // returns 5

    val ints = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    println(ints.maxOrNull())

    println(strings.zip(ints)) // zip function creates Pair element using provided lists

    val mergedLists = listOf(strings, ints)
    println(mergedLists) // returns a list of lists

    val combinedList = strings + ints
    println(combinedList)
}
