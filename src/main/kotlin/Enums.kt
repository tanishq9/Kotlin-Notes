enum class ErrorType(val prop1: String, val prop2: String) {
    TYPE1("prop11", "prop12"),
    TYPE2("prop21", "prop22");

    fun print() {
        println("Hey $prop1 $prop2")
    }
}

// Just as in Java, we can declare properties and functions within an enum.
// fullName and numEmployees are properties of Enum
enum class Department(private val fullName: String, private val numEmployees: Int) {
    HR("Human Resources", 10),
    IT("Info Tech", 10),
    SALES("Sales", 20);

    fun getDeptInfo(): String {
        return "$fullName has $numEmployees employees"
    }

    fun getAllDeptInfo() {
        for (dept in Department.values()) {
            println(dept.fullName + ", " + dept.numEmployees)
        }
    }
}

fun main() {
    println(ErrorType.TYPE1)
    println(ErrorType.TYPE1.prop1)
    println(ErrorType.TYPE1.prop2)

    println(Department.IT.getDeptInfo())
    println(Department.IT.getAllDeptInfo())
}
