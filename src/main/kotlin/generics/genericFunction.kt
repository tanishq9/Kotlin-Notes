package generics

import java.lang.StringBuilder

fun main() {
    val ints = listOf(1, 2, 3, 4, 5)
    val shorts: List<Short> = listOf(10, 20, 30, 40, 50)
    val floats: List<Float> = listOf(100.3f, -459.3f)

    convertToInt(floats)
    floats.convertToInts()

    append(StringBuilder("str1"), StringBuilder("str2"))
}

// For 1 upper bound
fun <T : Number> convertToInt(collection: List<T>) {
    for (num in collection) {
        println(num.toInt())
    }
}

// Making extension function for above
fun <T : Number> List<T>.convertToInts() {
    for (num in this) {
        println(num.toInt())
    }
}

// For >1 upper bounds on generic type
fun <T> append(item1: T, item2: T)
    where T : CharSequence, T : Appendable {
    println(item1.append(item2))
}
