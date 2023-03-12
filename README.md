Code examples are captured with comments. Sharing rough notes taken.

### Init
- Kotlin compiler (Kotlinc) takes files with .kt extension as input and generates bytecode as .class files. 
- These .class files are equivalent to java .class files, and the JVM can run them.
- However, when running .kt applications, you need the kotlin runtime library, in addition to the JRE. 
- When distributing a kotlin application, you have to distribute the kotlin runtime library and the JRE otherwise the app won't run.
- Kotlin stdlib - https://kotlinlang.org/api/latest/jvm/stdlib/

### Variable Declarations
- Kotlin uses type inference - compiler can figure out the type of a variable based on the context in which you are using it, this is done at compile time and not at runtime.
- Kotlin is a therefore statically typed language i.e. the type of every expression is determined and known at the compile time.
- val is equivalent to final keyword in kotlin, val type variables cannot be re-assigned.
- var type variables are mutable.
- When a variable is immutable (using val), it doesn't mean that instance properties are immutable, it means you cannot assign another instance to the variable.

### Type Aliases
- Type alias are declared at the top level outside of any function or class. These are the custom data type.
```
typealias EmployeeSet = Set<Employee> 
```
- This EmployeeSet can be used as data type for any variable declared in this file.

### Exceptions
- We don't have throws keyword in Kotlin, every exception is unchecked.
- We don't have ternary operator in Kotlin, we can use if instead of that, which is an expression in Kotlin.
- The way we deal with static variables and functions is different in Kotlin.

### Equality comparison
- == is used for referential integrity in Java and .equals is used for structural integrity.
- But in Kotlin, == is used for structural integrity and === is used for referential integrity.

### Instance Of & Casting
- To check if object is an instance of a class we use is keyword.
- For casting, we use as keyword.

### Raw Strings
- We can use a triple quoted string in order to escape any special character in the string. When we have a bunch of stuff to escape and we want our string to look nicer, we can use this triple quoted string.

Note: If a function returns nothing then we can use Unit as return type in Kotlin. Unit is a singleton instance.

### Null References
- We make a variable nullable by mentioning its datatype with ? during declaration.
- ?. is safe access expression. This internally does the null check for us and if variable is non-null then we only further method is called.
    - If variable is null then the expression evaluates to null.
- Elvis operator (?:) is used to assign a default value when an expression evaluates to null.

### If, When and Try-Catch
- If is an expression in Kotlin, that is, it can be used to return a value on basis of condition.
- Switch fall-through Java: https://www.tutorialspoint.com/Java-fall-through-switch-statements
- when block's output can be assigned to a variable i.e. it can be used as an expression in Kotlin similar to if. We have to ensure we cover all exhaustive cases in when cases else we would have to provide default value.

```
val res = when (value) {
    1, 2, 3, 4, 5 -> println(5)
    10 -> println(10)
    in 100..120 -> println(100)
    is Int -> println("Integer")
    else -> println("Nope")
}
```
Notes:
- If we have bunch of if-else then we can use when instead to make the code concise.
- when can be used without a value and in that case it is an alternative to if-else

```
val num1 = 10
val num2 = 20
if (num1 < num2) {
    println("num2 is greater")
} else if (num1 > num2) {
    println("num1 is greater")
} else {
    println("num1 and num2 are equal")
}

when {
    num1 < num2 -> println("num2 is greater")
    num1 > num2 -> println("num1 is greater")
    num1 == num2 -> println("num1 and num2 are equal")
}
```

- try-catch block is also an expression in Kotlin.
- Kotlin doesn't distinguish between checked and unchecked exceptions hence we do not need to declare the exceptions that the function throws.
- finally block is not involved in evaluation of a expression in try-catch-finally block.

```
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
```

### Access Modifiers
- The default visibility for a class in Kotlin is public whereas in java the default visibility is package private.
- There is no requirement of having same class name as the filename in Kotlin therefore we can have as many public classes with as different names in 1 file whereas in Java we can have only one public class having name same as filename.
- We can make private class in Kotlin (top level) -- same is not allowed in Java.
- internal modifier is used to restrict access to same module in Kotlin.
- More here: https://kotlinlang.org/docs/visibility-modifiers.html
- By default all classes in Kotlin are public and final.
- When a class is declared with final keyword, it is called a final class. A final class cannot be extended(inherited).

### Extension function
- Extension function is used to add a capability to an existing class like adding an extension function to String class. `String.upperFirstandLast()`

### Constructors
- Kotlin has the notion of primary constructor and that constructor is declared outside the curly braces.
```
class EmployeeDemo1 constructor(name: String){
    val name: String
    // init block is run when an instance is created and can be used in conjunction with primary constructor
    init {
        this.name = name
    }
}
```
- We can declare other constructors as well in class like we can in Java, and they're called secondary constructors.
- In below way, we are declaring object property in the primary constructor.
```
// Constructor takes a string argument and we are also declaring a property
class EmployeeDemo2 constructor(val name: String) {}
// Even the constructor keyword in not required
class EmployeeDemo3(val name: String) {}
```
- Secondary constructor always calls primary constructor (if it exists)
```
// Even the constructor keyword in not required
class EmployeeDemo4(val name: String) {
    // secondary constructor
    // if a class has a primary constructor then all of the secondary constructors have to delegate to primary constructor
    // declaring a property in secondary constructor isn't allowed and hence we have to declare it separately like below
 
    private var fullTime: Boolean = true
 
    constructor(name: String, fullTime: Boolean) : this(name) {
        this.fullTime = fullTime
    }
}
```
- We can have no primary constructor as well
```
// We can have no primary constructors as well i.e. no parenthesis after the class name
class EmployeeDemo6 {
    val name: String
 
    constructor(name: String) {
        this.name = name
    }
}
```
Note:
- In java, if we want a private field to be changed, we can generate public getters and setters.
- In kotlin, the getters and setters generated automatically for the private fields are private as well.

### Constants & Data class
- In Kotlin, we can have top-level constants similarly like we can have top-level functions unlike in Java.
- data class - if the main purpose of class is storing data/state information
- data class comes with a nice toString() function, a custom implementation of equals and hashCode functions and a copy function. We can override these methods if required.
- The primary constructors parameters in data class need to have atleast 1 val/var parameter, all parameters can only be val/var in primary constructor, like we can have in regular class constructor.
- data class cannot be abstract, sealed or inner classes.
```
data class Car(var color: String, val model: String)
 
fun main(){
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
```

### Functions
- When it comes to function parameters, we always have to include the datatype for parameters.
- val/var is not allowed in type of argument, by default the variable value can't be changed (can be considered as val implicitly)
- Spread operator unpacks an array elements into individual elements/varargs, and is also used to combine multiple arrays into one of the same type.
- arrayOf(*array1, *array2, element)

### Inline Functions
- When an inline function is compiled, its body is directly substituted for the function call.
- Inlining is often done when a function has a lambda expression for a parameter because lambdas require the creation of a class and an object underneath so by inlining a function which takes a lambda, this overhead is not required.
- Not all functions can be inlined, it depends on how function parameters are being used.
- JVM automatically can inline functions as well if that would benefit the application even if we haven't asked for a function to be inlined.

### Inheritance
- Everything in Kotlin is by default public and final, be it function, class, class properties.
- Adding open keyword in class signature means that class is extendable (not final).
- abstract class and functions are open by default. abstract class can declare abstract methods which should be implemented by the base class.
- If we want any function in parent class to be overridden then we have to use open keyword for that function in parent class (similar to what we did at class level as by default everything is public and final in Kotlin). The method in child class will have to use override keyword in order to override that parent class open method.
- By default all overridden methods are implicitly open and the subclasses can override the overridden methods in parent class, to avoid that, we have to use final keyword for the override methods in parent class so that sub classes cannot override them further.
- every secondary constructor has to call the primary constructor (if it exists)
- data classes are closed type, they cannot be extended/sub-classed.

### Enums
- Just as in Java, we can declare properties and functions within an enum.
- We have to write semi-colon after the last enum value in enum class in Kotlin so as to declare functions in enum class.

```
enum class Department(private val fullName: String, private val numEmployees: Int) {
    HR("Human Resources", 10),
    IT("Info Tech", 10),
    SALES("Sales", 20);

    fun getDeptInfo(): String {
        return "$fullName has $numEmployees employees"
    }

    fun getAllDeptInfo() {
        for (dept in Department.values()) {
            println(dept.fullName + " ," + dept.numEmployees)
        }
    }
}

fun main() {
    println(Department.IT.getDeptInfo())
    println(Department.IT.getAllDeptInfo())
}
```

### Interfaces
- Interfaces are extendable by default and we needn't use open keyword for them.
- All variables and methods defined in interface are abstract by default in both Kotlin and Java.
- We can define concrete properties in interface by defining get() for that property

### Object Keyword
Use-cases of the object keyword:
- Singleton
- Companion object
- Object expressions

Re: Singleton
- Singleton design pattern is used when we want one and only one instance of a class during the running of application. A static method is there in class which provides this instance of singleton object.
- object keyword is used to create singleton objects in Kotlin. 
- We cannot instantiate an object class, we can use it methods and properties as static method and variables.

### Companion Objects
- static keyword doesn't exist in kotlin.
- We can create companion objects inside classes and access those without creating instance of the class.
- companion objects are declared inside a class, anything declared inside companion object is a class level property and an instance of class doesn't need to be created to call the methods declared inside companion object.
- Only one companion object is allowed per class.

- companion objects can also be used to implement factory pattern i.e. on basis of method called, the instance of the class would be returned.
- companion objects can call the private constructor of a class in which it is declared.
- classes implementing factory pattern should have private constructor.

```
// Example of factory design pattern in kt using companion object
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
```

### Anonymous Objects
- Object expressions are the anonymous object, so you use them where you use anonymous classes in Java.
- Object can also be used to create anonymous instances, example some function wants an interface as a parameter, so instead of implementing the interface, we can directly use object keyword to pass an implementation of interface during function call.
- A new instance of object implementing interface/extending class is created each time for the object expression.
```
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
```

### Looping
- for loop uses ranges in kotlin
- range is an interval that has a start and end value
```
fun main() {
    val range = 1..5 // 1 and 5 are inclusive
    val charRange = 'a'..'z'
    val stringRange = "ABC".."XYZ"
 
    println(3 in range) // true
    println('q' in charRange) // true
    println("CCC" in stringRange) // true
    println("CCCCCC" in stringRange) // true
    println("ZZZ" in stringRange) // false
 
    val r = 5..1
    println(5 in r) // false
    // backward range works like below
    val backwardRange = 5 downTo 1
    println(5 in backwardRange) // true
 
 
    // for range having step (by default step value is 1)
    val stepRange = 3..15 step 3
    stepRange.forEach { println(it) }
 
    // reverse range
    val reverseRange = stepRange.reversed()
    reverseRange.forEach { println(it) }
}
```
- Looping using Range
```
fun main() {
    val range = 1..5
    for (i in range) {
        // println(i)
    }
    val stepRange = 3..12 step 3
    for (i in stepRange) {
        // println(i)
    }
    // for (int i = 1; i <= 10; i += 2)
    for (i in 1..10 step 2) {
        // println(i)
    }
 
    for (i in 20 downTo 10 step 2) {
        // println(i)
    }
 
    // 10 is exclusive in below range
    for (i in 1 until 10) {
        println(i)
    }
}
```

### Lambda Expression
- When there is only 1 argument to lambda, we can refer that with it.

Lambda Receivers
- with function: When we use with function, we pass an instance and lambda to the function and within the lambda, you don't have to refer to the instance when you want to call one of its member functions, we can call member functions directly without invoking them using the instance.
- apply function: When we use apply function, lambda always returns the instance we invoked apply on.

### Lists
- Collections can be mutable or immutable in Kotlin.
- All collections take a generic type and all read only interfaces are covariant (immutable).
- The collection interface is implemented by the list and set collections.
- To sum up, use mutableListOf for mutable list and listOf for immutable list
```
fun main() {
    // immutable list
    val strings = listOf("spring", "summer", "fall")
    println(strings.javaClass)
    // class java.util.Arrays$ArrayList
    // In Java - We can add/remove but we can MODIFY the elements in list
    // In Kotlin - No function to MODIFY the list
 
    val emptyList = emptyList<String>()
    println(emptyList.javaClass) // class kotlin.collections.EmptyList
 
    val notNullList = listOfNotNull("hello", null)
    println(notNullList) // [hello]
 
    // mutable list
    val arrayList = arrayListOf(1, 2, 4)
    println(arrayList.javaClass) // class java.util.ArrayList
    arrayList.add(8)
 
    val mutableList = mutableListOf(1, 2, 3)
    println(mutableList.javaClass) // class java.util.ArrayList
 
    // convert array to list
    val array = arrayOf("a", "b", "c")
    println(array.javaClass)
    val list = array.toList()
    println(list.javaClass)
 
    mutableList[1] = 1
}
```
- Exploring more functions of list collections
```
fun main() {
    val strings = listOf("spring", "summer", "fall", "winter")
 
    // Exploring list function added specific for Kotlin
 
    println(strings.last())
    println(strings[0])
    println(strings.asReversed())
    println(strings)
 
    if (strings.size > 5) {
        println(strings[5])
    }
 
    // Alternate to above (specific kotlin)
    println(strings.getOrNull(5))
    println(strings.getOrElse(5) { it }) // returns 5
 
    val ints = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    println(ints.maxOrNull())
 
    println(strings.zip(ints)) // zip function creates Pair element using provided lists
 
    val mergedLists = listOf(strings, ints)
    println(mergedLists) // returns a list of lists
 
    val combinedList = strings + ints
    println(combinedList)
}
```

### De-structuring declaration
- We take an instance and de-structure/distribute its public member values to different variables.
```
val pair = Pair(10, "ten")
val (firstValue, secondValue) = pair
println(firstValue) // 10
println(secondValue) // ten
 
 
// Iterating map using destructuring declaration
// We are destructing a map entry into its key and value
for ((key, value) in mutableMap) {
   println(key)
   println(value)
}
 
// Destructuring Car class
val car = Car("blue", "Corvette", 1959)
val (color, model, year) = car
println(color)
println(model)
println(year)
 
 
class Car(val color: String, val model: String, val year: Int) {
    // We have to implement component functions to provide destructuring capability to class
    // This comes out-of-the-box for data classes
    operator fun component1() = color
    operator fun component2() = model
    operator fun component3() = year
}
```

### Sets
- Sets are similar to List, but would have unique elements. Similarly for immutable set use setOf() and for mutable set use mutableSetOf()
```
fun main() {
    val set = setOf(1, 2, 2, 3)
    println(set.javaClass)
    println(set)
    set.plusElement(4) // doesn't change existing set
    println(set)
    println(set.average())
 
    val mutableSet = mutableSetOf(1, 2, 2, 3)
    mutableSet.plus(10) // doesn't change existing mutable set
    println(mutableSet)
}
```

### Exploring more collection functions
```
fun main() {
    val ints = setOf(1, 2, 2, 3, 4)
    println(
        // Predicate lambda
        ints.filter { it: Int ->
            it % 2 == 0
        }
    )
 
    // using map function to modify collection
    val list = mutableListOf(1, 2, 3, 4, 5)
 
    list[1] = 10
 
    println(
        // Function lambda
        list.map { it ->
            it + 10
        }
    )
 
    // exploring all, any, find, count and groupBy functions of collection
    val map = mapOf(
        3 to Car1("green", "toyota", 2015),
        1 to Car1("silver", "honda", 2010),
        2 to Car1("blue", "ford", 2012)
    )
 
    println(map.all { it.value.year > 2014 })
    println(map.any { it.value.year > 2014 })
 
    val listOfCars = map.values
    println(listOfCars.find { it.year > 2014 })
    println(listOfCars.groupBy { it.color })
 
    println(map)
    println(map.toSortedMap())
 
    println(listOfCars.sortedBy { it.year })
}
 
data class Car1(val color: String, val model: String, val year: Int)
```

### Sequences
We can perform 2 types of operations on sequences:
- intermediate: this operation returns another sequence.
- terminal: this operation does not return a sequence, it terminates the chain.

- We can use sequences, which are similar to stream in Java.
- Each operation is applied to every element before proceeding to next element.
- Only when a terminal operation is applied to sequence, the intermediate operations are evaluated.
```
    println(
        listOf("Joe", "Mary", "Jane")
            .asSequence()
            .filter { println("filtering $it"); it[0] == 'J' }
            .map { println("mapping $it"); it.toUpperCase() }
            // above is not evaluated UNTIL a terminal operation is chained
            .toList()
    )
}
```

### Generics
```
fun main() {
    val bdList = mutableListOf(
        BigDecimal(33.45),
        BigDecimal(3.9),
        BigDecimal(10)
    )
    // println(bdList)
    println(printCollection(bdList))
    println(bdList.javaClass)
    bdList.print()
}
 
// T is called type parameter
fun <T> printCollection(collection: List<T>): T {
    for (item in collection) {
        println(item)
    }
    return BigDecimal(2) as T
}
 
// Lets make extension function for above
fun <T> List<T>.print() {
    for (item in this) {
        println(item)
    }
}
```

- For functions having more than 1 upper bound on generic type, we will have to use the where clause.

```
// For >1 upper bounds on generic type
fun <T> append(item1: T, item2: T)
    where T : CharSequence, T : Appendable {
    println(item1.append(item2))
}
 
 
// For 1 upper bound
fun <T : Number> convertToInt(collection: List<T>) {
    for (num in collection) {
        println(num.toInt())
    }
}
```

- Generic are compile-time aid.
- Generic types are erased at run-time.
- Type erasure: When a java app runs it doesn't have any of the generic info and that is called type erasure so that information is erased. So at compile-time we might declare a list of big decimal but at runtime all the JVM will see is an array list.
- So generics are basically the syntactical element that help the compiler and us.


### Reified Parameters
- Where using inline benefits?
    - When function has lambda as a parameter.
    - When we have a generic type as a parameter because inline function parameters can be reified.
- reification - It is a kotlin feature that prevents the type from being erased at runtime.
- If we declare a function as inline and a type parameter as a reified then we can check the generic type at runtime.

```
fun main() {
    val mixedList: List<Any> = listOf("string", 1, BigDecimal(22.5), "fall", BigDecimal(-400.5))
    // We are telling getElementsOfType to return a list of String
    // Else compiler should show - Not enough information to infer type variable T
    val bigDecimalOnly = getElementsOfType<BigDecimal>(mixedList)
    println(bigDecimalOnly)
}
 
inline fun <reified T> getElementsOfType(list: List<Any>): List<T> {
    val newList: MutableList<T> = mutableListOf()
    for (element in list) {
        // Cannot check for instance of erased type: T
        if (element is T) {
            newList.add(element)
        }
    }
    return newList
}
```

### Covariance
- List<Int> is a sub-type (not sub-class) of a List<Number>, basically we are saying that a list of numbers should be able to accept list of integers. We can alternatively say list of numbers is a super-type of list of ints.
- If we want sub-typing to be preserved when working with generics we have to declare type parameter to be covariant.
- When we are dealing with covariance - sub-typing is preserved so when something is covariant, a list of short is a sub-type of a list of number.
- When we are dealing with mutable list, sub-typing is not preserved/not covariant but it is preserved for immutable list.
- When a class is covariant meaning that we have used the out keyword, the sub-typing is preserved (Garden<Rose> can be used as function parameter for Garden<Flower>) and the class can only be used in out position i.e. return type of function declared in class can be generic NOT the function parameters (can't be generic).
- When we declare something as covariant, we lose the ability to write to an instance i.e. to change an instance, and to guarantee that you can't write to it -- you are not allowed to accept a parameter of type T in the member functions.
- Immutable list are co-variant and mutable list are NOT co-variant (that is why we are able to mutate).

### Contra-variance
- If you want to accept a class and all of its superclasses then you are dealing with contra-variance.
- If you want to accept a class and all its subclasses then you are dealing with covariance.

Note: When we are dealing with either co/contra-variance, we are actually widening a generic type to include either a class and its subclasses OR a class and its superclasses.

In Java,

- List<? extends A> is equivalent to co-variance.
- List<? super A> is equivalent to contra-variance.

### Use-Site Variance
- We made class/interface co/contra-variant by mentioning the same at declaration time and this is called declaration site-variance and we don't have this in Java. 
- In Java (and kt as well), we have use-site variance.
```
fun main() {
    val mutableInts: MutableList<Number> = mutableListOf(1, 2)
    val mutableShorts: MutableList<Short> = mutableListOf(1, 2)
    printList(mutableInts)
    printList(mutableShorts)
    addList(mutableShorts, mutableInts)
}

fun printList(collection: MutableList<out Number>) {
    println(collection)
}

fun <T> addList(source: MutableList<out T>, destination: MutableList<T>) {
    println(destination.addAll(source))
}
```
