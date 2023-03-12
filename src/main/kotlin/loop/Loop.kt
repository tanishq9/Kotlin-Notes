package loop

fun main() {
    // testRanges()
    // testForLoopUsingRanges()
    val seasons = arrayOf("spring", "summer", "winter", "fall")
    for (season in seasons) {
        println(season)
    }

    val notASeason = "whatever" !in seasons
    println(notASeason)

    for (index in seasons.indices) {
        println("${seasons[index]} is season number $index")
    }

    seasons.forEach { it -> println(it) } // forEach takes a Consumer functional interface
    seasons.forEachIndexed { index, value -> println("$value is season number $index") }
}

fun testForLoopUsingRanges() {
    val range = 1..5
    for (i in range) {
        // println(i)
    }

    val stepRange = 3..12 step 3
    for (i in stepRange) {
        // println(i)
    }

    // for (int i = 1; i <= 10; i += 2)
    for (i in 1..10 step 2) {
        // println(i)
    }

    for (i in 20 downTo 10 step 2) {
        // println(i)
    }

    // 10 is exclusive in below range
    for (i in 1 until 10) {
        println(i)
    }
}

fun testRanges() {
    // for loop uses ranges in kotlin
    // range is an interval that has a start and end value
    val range = 1..5 // 1 and 5 are inclusive
    val charRange = 'a'..'z'
    val stringRange = "ABC".."XYZ"

    println(3 in range) // true
    println('q' in charRange) // true
    println("CCC" in stringRange) // true
    println("CCCCCC" in stringRange) // true
    println("ZZZ" in stringRange) // false

    val r = 5..1
    println(5 in r) // false
    // backward range works like below
    val backwardRange = 5 downTo 1
    println(5 in backwardRange) // true


    // for range having step (by default step value is 1)
    val stepRange = 3..15 step 3
    stepRange.forEach { println(it) }

    // reverse range
    val reverseRange = stepRange.reversed()
    reverseRange.forEach { println(it) }
}
