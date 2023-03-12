package inheritence

// Printer is public and final by default
// open --> Adding open keyword in class signature means that class is extendable (not final)
open class Printer(val modelName: String) {
    // Iteration 1: Printer class has an empty primary constructor for demonstration
    // Iteration 2: Added modelName as parameter
}

class LaserPrinter(name: String) : Printer(name) {
}

abstract class AbstractPrinter(val modelName: String) {
    abstract fun print() // abstract functions have no body

    // By default any function is also public and final
    // Therefore for it to be overriden by child class, we have to make it open
    open fun printJustModelName() {
        println(modelName)
    }
}

open class Printer1(name: String) : AbstractPrinter(name) {
    override fun print() {
        println("The model name of this printer is: $modelName")
    }

    final override fun printJustModelName() {
        println("----------")
        super.printJustModelName()
        println("----------")
    }
}

class SpecialPrinter1(name: String) : Printer1(name) {
    override fun print() {
        println("The model name of this printer is: $modelName")
    }
}

fun main() {
    val printer = LaserPrinter("m1")
    println(printer.modelName)
    // println(printer.name)
    val printer1 = Printer1("p1")
    printer1.print()
    printer1.printJustModelName()
}

open class Something {

    var param: String

    constructor(param: String) {
        this.param = param
    }
}

class SomethingElse : Something("abc") {
}

// data classes are closed type, they cannot be extended/sub-classed.
data class DataClass(val name: String) : Printer("a") {}
