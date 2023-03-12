fun main() {
    val value = 10;
    // when is also an expression in Kotlin like if
    val res = when (value) {
        1, 2, 3, 4, 5 -> println(5)
        10 -> println(10)
        15 -> println(15)
        in 100..120 -> println(100)
        is Int -> println("Integer")
        else -> println("Nope")
    }
    println(res)

    val res2 = when (value) {
        1, 2, 3, 4, 5 -> {
            println(5)
            5
        }
        10 -> {
            println(10)
            10
        }
        15 -> println(15)
        in 100..120 -> println(100)
        is Int -> println("Integer")
        else -> println("Nope")
    }
    println(res2)
    println(res2.javaClass)

    val num1 = 10
    val num2 = 20
    if (num1 < num2) {
        println("num2 is greater")
    } else if (num1 > num2) {
        println("num1 is greater")
    } else {
        println("num1 and num2 are equal")
    }

    // when can be used without a value and in that case it is an alternative to if-else
    when {
        num1 < num2 -> println("num2 is greater")
        num1 > num2 -> println("num1 is greater")
        num1 == num2 -> println("num1 and num2 are equal")
    }
}
