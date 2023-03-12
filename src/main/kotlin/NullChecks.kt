// We make a variable nullable by mentioning its datatype with ? during declaration
// Kotlin enforces null checking while in Java we ourselves have to make sure
// To call a method of a variable which could possibly give NPE, we have to use safe access operation

// Elvis operator (?:) is used when we do not want to assign null value to an expression

// Use !! to bypass mandatory safety check for operations on nullable variables, it would throw NPE if variable is null
// In some cases, we might want to throw NPE because our below code might only work for non-null values and we want to perform some exception handling as well
// !! is called as non null assertion, we are asserting a variable is non null and don't want to perform safety check

fun main() {
    val string: String? = null
    println(string)
    println(string?.toUpperCase())
    // println(string!!.toUpperCase()) // NPE would be t

    val stringValue = string?.toUpperCase() ?: "Substitute"
    println(stringValue)

    val anotherString: String? = "Not a null string"
    println(anotherString?.toUpperCase())

    println(string?.toUpperCase() ?: "string is null")

    // println(string!!.toUpperCase()) -> !! to bypass null safety check, ask for NPE to be thrown if string is null
}