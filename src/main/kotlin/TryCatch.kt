import java.lang.IllegalArgumentException

fun main() {
    println(getNumber("10"))
    println(getNumber("abc"))

    getNumber("abc") ?: throw IllegalArgumentException("Not a valid number.")
}

fun getNumber(str: String): Int? {
    return try {
        str.toInt()
    } catch (exception: Exception) {
        // throw exception
        // 0
        null
    }
}
