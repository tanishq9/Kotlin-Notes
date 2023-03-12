package generics

fun main() {

    val flowerTender = object : FlowerCare<Flower> {
        override fun prune() {
            println("prune flower")
        }
    }

    /*val roseTender = object : FlowerCare<Rose> {
        override fun prune() {
            println("prune rose")
        }
    }*/
    val roseGarden = TestGarden<Rose>(listOf(Rose(), Rose()), flowerTender)

    /*val daffodilTender = object : FlowerCare<Daffodil> {
        override fun prune() {
            println("prune daffodil")
        }
    }*/
    val daffodilGarden = TestGarden<Daffodil>(listOf(Daffodil(), Daffodil()), flowerTender)

    println(roseGarden.tendFlower(0))
    println(daffodilGarden.tendFlower(0))
}

class TestGarden<T : Flower>(val flowers: List<T>, val flowerCare: FlowerCare<T>) {
    fun pickFlower(i: Int) = flowers[i]
    fun tendFlower(i: Int) = flowerCare.prune()
}

// If you want to accept a class and all of its superclasses then you are dealing with contra-variance
interface FlowerCare<in T> {
    fun prune()
}
