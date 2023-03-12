// Use $var to refer variables inside string in Kotlin
// Use \ to escape characters in string in some cases
// Use ${expression} for writing expressions in string
// When we have to escape a bunch of characters in string then we can use triple quoted string in Kotlin
// Triple quoted string can also be used for multi-line strings

fun main() {
    var money = 5
    println("$money$")
    println("$")
    val num: Float = 10f
    val den: Float = 20f
    println("${num / den}")

    val string = """C:\Documents\Code"""
    println(string)
}
