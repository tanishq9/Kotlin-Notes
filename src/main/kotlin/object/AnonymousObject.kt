package `object`

interface SomeInterface {
    fun mustImplement(num: Int): String
}

fun wantsSomeInterface(si: SomeInterface) {
    println("Printing from wantsSomeInterface ${si.mustImplement(22)}")
}

fun main() {
    wantsSomeInterface(object : SomeInterface {
        override fun mustImplement(num: Int): String {
            return "This is from mustImplement: ${num * 100}"
        }
    })
}
