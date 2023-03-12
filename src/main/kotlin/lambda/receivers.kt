package lambda

import java.lang.StringBuilder

fun main() {
    // println(countTo100With())
    println(countTo100Apply())
}

fun countTo100With(): String {
    // with function: When we use with function, we pass an instance and lambda to the function and within the lambda, you don't have to refer to the instance when you want to call one of its member functions, we can call member functions directly without invoking them using the instance.
    val numbers = StringBuilder()
    val output = with(numbers) {
        for (i in 1..10) {
            // calling member function for numbers instance
            append("$i ")
        }
        append("END")
        toString() // with returns the value of statement at then end
    }
    println(output.javaClass)
    return output
}

fun countTo100Apply(): String {
    // apply function: When we use apply function, lambda always returns the instance we invoked apply on
    val numbers = StringBuilder()
    val output = numbers.apply {
        // this lambda would always return the instance we invoked apply on
        for (i in 1..10) {
            // calling member function for numbers instance
            append("$i ")
        }
        append("END")
    }
    println(output.javaClass)
    return numbers.toString()
}
