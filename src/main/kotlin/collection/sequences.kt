package collection

fun main() {
    println(
        listOf("Joe", "Mary", "Jane")
            .filter { println("filtering $it"); it[0] == 'J' }
            .map { println("mapping $it"); it.toUpperCase() }
    )

    // We can observe that each individual operation return a list
    // and each operation is completed fully before proceeding to the next one

    // We can use sequences, which are similar to stream in Java
    // Each operation is applied to every element before proceeding to next element
    // Only when a terminal operation is applied to sequence, the intermediate operations are evaluated

    println(
        listOf("Joe", "Mary", "Jane")
            .asSequence()
            .filter { println("filtering $it"); it[0] == 'J' }
            .map { println("mapping $it"); it.toUpperCase() }
            // above is not evaluated UNTIL a terminal operation is chained
            .toList()
    )
}
