package lambda

fun main() {
    val employees = listOf(
        Employee("A", "B", 2020),
        Employee("T", "S", 2021),
        Employee("A", "G", 2022)
    )

    println(employees.minByOrNull { it.startYear }) // Function
    employees.forEach { println(it) } // Consumer
}

data class Employee(val firstName: String, val lastName: String, val startYear: Int)
