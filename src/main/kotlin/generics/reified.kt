package generics

import java.math.BigDecimal

fun main() {
    val mixedList: List<Any> = listOf("string", 1, BigDecimal(22.5), "fall", BigDecimal(-400.5))
    // We are telling getElementsOfType to return a list of String
    // Else compiler should show - Not enough information to infer type variable T
    val bigDecimalOnly = getElementsOfType<BigDecimal>(mixedList)
    println(bigDecimalOnly)
}

inline fun <reified T> getElementsOfType(list: List<Any>): List<T> {
    val newList: MutableList<T> = mutableListOf()
    for (element in list) {
        // Cannot check for instance of erased type: T
        if (element is T) {
            newList.add(element)
        }
    }
    return newList
}
