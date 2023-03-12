fun main() {
    val emp = EmployeeDemo()
    println(emp)
    val emp1 = EmployeeDemo1("abc")
    println(emp1.name)
    val emp2 = EmployeeDemo2("abc")
    println(emp2.name)
    val emp3 = EmployeeDemo3("abc")
    println(emp3.name)
    val emp4 = EmployeeDemo4("abc", false)
    println(emp4.name)
    println(emp4.fullTime)
    val emp5 = EmployeeDemo5("abc", false)
    println(emp5.name)
    println(emp5.fullTime)
    val emp6 = EmployeeDemo6("abc")
    println(emp6.name)
    val emp7 = EmployeeDemo7("abc")
    println(emp7.getName())
    val emp8 = EmployeeDemo8("abc")
    println(emp8.name)

    println(MY_CONST)

    // Car is a data class
    val car1 = Car("blue", "Toyota")
    val car2 = Car("blue", "Toyota")
    println(car1) // toString()
    println(car1 == car2) // equals(), == for structural integrity
    val car3 = car1.copy()
    println(car3)
    println(car1 === car3) // equals(), === for referential integrity
    car3.color = "red"
}

// In Kotlin, we can have top-level constants similarly like we can have top-level functions unlike in Java.
val MY_CONST = 100

private class EmployeeDemo {
}

class EmployeeDemo1 constructor(name: String) {
    val name: String

    // init block is run when an instance is created and can be used in conjunction with primary constructor
    init {
        this.name = name
    }

    // val name: String = name --> This is fine as well
}

// In below way, we are declaring object property in the primary constructor
// Constructor takes a string argument and we are also declaring a property
class EmployeeDemo2 constructor(val name: String) {
}

// Even the constructor keyword in not required
class EmployeeDemo3(var name: String) {
}

// Even the constructor keyword in not required
class EmployeeDemo4(val name: String) {
    // secondary constructor
    // if a class has a primary constructor then all of the secondary constructors have to delegate to primary constructor
    // declaring a property in secondary constructor isn't allowed and hence we have to declare it separately like below

    var fullTime: Boolean = true

    constructor(name: String, fullTime: Boolean) : this(name) {
        this.fullTime = fullTime
    }
}

// We can assign default values in primary constructor
class EmployeeDemo5(val name: String, var fullTime: Boolean = true) {
}

// We can have no primary constructors as well i.e. no parenthesis after the class name
class EmployeeDemo6 {
    val name: String

    constructor(name: String) {
        this.name = name
    }
}

// In kotlin, the getters and setters generated automatically for the private fields are private as well.
class EmployeeDemo7(private val name: String) {
    fun getName() {
        name
    }
}

// Writing custom getter and setter for property
class EmployeeDemo8(name: String) {
    var name = name
        get() {
            println("Running custom get")
            return field
        }
        set(value) {
            println("Running custom set")
            field = value
        }
}

// data class - if main purpose of class is storing data/state information
data class Car(var color: String, val model: String)