fun main() {
    println(test1("test"))
    val car1 = Car("blue1", "toyota")
    val car2 = Car("blue2", "toyota")
    val car3 = Car("blue3", "toyota")
    // testVarArgs(str = "str", car1, car2, car3)
    val manyCars1 = arrayOf(car1, car2, car3)
    val manyCars2 = arrayOf(car1, car2, car3)
    val manyCars3 = arrayOf(car1, car2, car3)
    // testVarArgs(str = "str", *manyCars1, *manyCars2, *manyCars3, car1)

    println(Utils().upperFirstAndLast("uppercase"))

    println("str".upperFirstAndLast())
}

// When it comes to function parameters, we always have to include the datatype for parameters.
fun test1(arg: String): String {
    return "Argument is $arg"
}

fun testVarArgs(str: String, vararg cars: Car) {
    for (car in cars) {
        println(car)
    }
    println(str)
}

class Utils {
    fun upperFirstAndLast(str: String): String {
        val upperFirst = str.substring(0, 1).uppercase()
        val upperLast = str.substring(str.length - 1, str.length).uppercase()
        return upperFirst + str.substring(1, str.length - 1) + upperLast
    }
}

// Alternative to above
fun String.upperFirstAndLast(str: String): String {
    val upperFirst = str.substring(0, 1).uppercase()
    val upperLast = str.substring(str.length - 1, str.length).uppercase()
    return upperFirst + str.substring(1, str.length - 1) + upperLast
}

// receiver type (the type which we are pseudo extending) --> string
fun String.upperFirstAndLast(): String {
    // this is the string here
    val upperFirst = this.substring(0, 1).uppercase()
    val upperLast = this.substring(this.length - 1, this.length).uppercase()
    return upperFirst + this.substring(1, this.length - 1) + upperLast
}

fun String.upperFirstAndLastAnother(): String {
    // this is the string here
    val upperFirst = substring(0, 1).uppercase()
    val upperLast = substring(length - 1, length).uppercase()
    return upperFirst + substring(1, length - 1) + upperLast
}
