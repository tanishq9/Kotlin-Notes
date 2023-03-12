package collection

fun main() {
    val immutableMap = mapOf(
        1 to Car("green", "toyota", 2010),
        2 to Car("silver", "honda", 2012),
        3 to Car("blue", "ford", 2015)
    )

    println(immutableMap.javaClass) // class java.util.LinkedHashMap
    println(immutableMap)

    val mutableMap = mutableMapOf(
        "My car" to Car("silver", "merc", 2022)
    )
    println(mutableMap.javaClass) // class java.util.LinkedHashMap
    println(mutableMap)
    mutableMap["new key"] = Car("a", "b", 1111)
    println(mutableMap)

    // Destructuring declaration, we take an instance and de-structure/distribute its public member values to different variables
    val pair = Pair(10, "ten")
    val (firstValue, secondValue) = pair
    println(firstValue) // 10
    println(secondValue) // ten

    // Iterating over map
    for (entry in mutableMap) {
        println(entry.key)
        println(entry.value)
    }

    // Iterating map using destructuring declaration
    // We are destructing a map entry into its key and value
    for ((key, value) in mutableMap) {
        println(key)
        println(value)
    }

    // Destructuring Car class
    val car = Car("blue", "Corvette", 1959)
    val (color, model, year) = car
    println(color)
    println(model)
    println(year)
}

class Car(val color: String, val model: String, val year: Int) {
    // We have to implement component functions to provide destructuring capability to class
    // This comes out-of-the-box for data classes
    operator fun component1() = color
    operator fun component2() = model
    operator fun component3() = year
}

// data class Car(val color: String, val model: String, val year: Int)
