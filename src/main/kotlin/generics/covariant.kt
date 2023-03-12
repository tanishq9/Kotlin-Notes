package generics

// When a class is covariant meaning that we have used the out keyword,
// the sub-typing is preserved (Garden<Rose> can be used as function parameter for Garden<Flower>)
// and the class can only be used in out position i.e. return type of member function declared in class can be generic
// NOT the function parameters (can't be generic).

// Garden of some type of flower
// Class is covariant
// meaning sub-typing is preserved i.e. child class can be used instead of parent class (if this is the what type extends to)
// the type could only be used in out position of member function
class Garden<out T : Flower> {

    val flowers: List<T> = listOf()

    // generic type T used as function return type
    fun pickFlower(i: Int): T = flowers[i]

    // Error - Type parameter T is declared as 'out' but occurs in 'in' position in type T
    // T can only be used in out position i.e. as return type of function but not as parameter type of function
    // Reasoning - Sub-typing is preserved using out keyword, that means we could plant ANY flower if we allow that in input of function
    // and in that case we could be having a garden of multiple type of flowers (if at all possible) and that is NOT allowed
    /*fun plantFlower(flower: T) {

    }*/
}

open class Flower() {}

class Rose : Flower() {}

class Daffodil : Flower() {}

fun waterGarden(garden: Garden<Flower>) {

}

fun tendGarden(roseGarden: Garden<Rose>) {
    waterGarden(roseGarden)
}

// When we declare something as covariant, we lose the ability to write to an instance i.e. to change an instance,
// and to guarantee that you can't write to it -- you are not allowed to accept a parameter of type T in the member functions.

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
