package `object`

import java.time.Year

object SingletonObject {

    private val currentYear = Year.now().value

    fun method1() {
        println("Method 1 $currentYear")
    }

    // only accessible in same module, not in other modules
    internal fun method2() {
        println("Method 2")
    }
}

fun main() {
    SingletonObject.method1()
    SingletonObject.method2()
}
