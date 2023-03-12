import javax.print.attribute.SetOfIntegerSyntax

// typealias are an alias for an existing datatype, generally used for custom datatype
// typealias can only be declared at top level i.e. outside of functions and claas

typealias employees = Set<Employee>

fun main() {
    val employeesSet: employees = setOf(Employee("A", 1))
}

// Kotlin vs Java
// In Java, == sign is used for referential equality and .equals() is used for structural equality
// In Kotlin, == sign is treated same as .equals() i.e. both are used for checking structural equality
// We have to use === sign to check for referential equality in Kotlin
// We don't have | and & bitwise operators in Kotlin instead we spell them manually i.e. or, and, xor, etc.
// 