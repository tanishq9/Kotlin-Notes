fun main() {
    // if being used as expression
    // there is no ternary operator in kotlin
    val condition = false

    val num1 = if (condition) 50 else 592
    println(num1)

    val num2 = if (condition) {
        println("something")
        50
    } else {
        println("something else")
        592
    }
    println(num2)
}
