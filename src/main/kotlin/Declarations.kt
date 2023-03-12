// 1. Kotlin Standard Library - by default imported in every kotlin file
// 2. Kotlin uses type inference i.e. the compiler can figure out the type of variable based on the context in which we are using it, this is done at compile time
// 3. Kotlin is statically typed language i.e. the type of variable is figured out by the compiler at compile time
// 4. Every variable declaration begins with val or var - val means immutable variable and we cannot reassign value, similar to final keyword in java
// 5. val variable can be assigned only once in the block of code in which it is written, val variable value does not necessarily has to be mentioned while declaring the variable
// 6. var are used to declare mutable variables
// 7. The IDE underlines when a var variable is referred

fun main(array: Array<String>) {
    print("Hello World")
    useVal()
    useVar()
}

fun useVar() {
    var number: Int
    number = 5
    number = 10
    print(number)
}

fun useVal() {
    val number: Int
    number = 5
    // number = 10 - val cannot be reassigned
    print(number)

    val employee: Employee = Employee("ABC", 1)
    // employee.id = 2 -> cannot reassign id as val variables are immutable
    employee.name = "XYZ"
}

class Employee(var name: String, val id: Int)