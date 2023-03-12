package `interface`

interface MyInterface {
    val number: Int
        get() = 50

    fun MyFunction(string: String): String
}

interface MySubInterface : MyInterface {
    fun MySubFunction(string: String): String
}

class Something : MySubInterface {

    override val number: Int = 80

    override fun MyFunction(string: String): String {
        println(number)
        TODO("Not yet implemented")
    }

    override fun MySubFunction(string: String): String {
        TODO("Not yet implemented")
    }
}
