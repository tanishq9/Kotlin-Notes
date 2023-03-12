package `object`

class SomeClass {
    // Anything inside companion object can be accessed without needing an instance of class
    // Equivalent to static member var and functions in Java
    companion object {
        private var privateVar = 6
        fun accessPrivateVar() = println("I am accessing private var $privateVar")

        init {
            println("Inside static block")
        }
    }
}

class OtherClass {
    // We can give companion object a name
    companion object CompanionDemo {
        private var privateVar = 6
        fun accessPrivateVar() = println("I am accessing private var $privateVar")
    }
}

// Example of factory design pattern in kotlin class using companion object
class AnotherClass private constructor(val someString: String) {
    // companion object can act as a factory
    // classes implementing factory pattern should have private constructor
    companion object {
        private var privateVar = 6
        fun accessPrivateVar() = println("I am accessing private var $privateVar")

        fun justAssign(str: String) = AnotherClass(str)
        fun upperOrLower(str: String, lowerCase: Boolean): AnotherClass {
            return if (lowerCase) {
                AnotherClass(str.lowercase())
            } else {
                AnotherClass(str.uppercase())
            }
        }
    }
}

fun main() {
    SomeClass.accessPrivateVar()
    SomeClass.Companion.accessPrivateVar()

    OtherClass.accessPrivateVar()
    OtherClass.CompanionDemo.accessPrivateVar()

    val anotherClass = AnotherClass.justAssign("str")
    println(anotherClass.someString)
}
