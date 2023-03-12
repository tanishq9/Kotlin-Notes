package collection

import java.util.function.Predicate

fun main() {
    val ints = setOf(1, 2, 2, 3, 4)
    // We can use filter to get items from collection based on a predicate
    // predicate is a lambda expression i.e. a functional interface, can be passed as argument to functions or assigned to a variable

    val predicate = Predicate<Int> { input: Int -> input % 2 == 0 }

    println(predicate.test(10))

    println(
        // Predicate lambda
        ints.filter { it: Int ->
            it % 2 == 0
        }
    )

    // using map function to modify collection
    val list = mutableListOf(1, 2, 3, 4, 5)

    list[1] = 10

    println(
        // Function lambda
        list.map { it ->
            it + 10
        }
    )

    // exploring all, any, find, count and groupBy functions of collection
    val map = mapOf(
        3 to Car1("green", "toyota", 2015),
        1 to Car1("silver", "honda", 2010),
        2 to Car1("blue", "ford", 2012)
    )

    println(map.all { it.value.year > 2014 })
    println(map.any { it.value.year > 2014 })

    val listOfCars = map.values
    println(listOfCars.find { it.year > 2014 })
    println(listOfCars.groupBy { it.color })

    println(map)
    println(map.toSortedMap())

    println(listOfCars.sortedBy { it.year })
}

data class Car1(val color: String, val model: String, val year: Int)
