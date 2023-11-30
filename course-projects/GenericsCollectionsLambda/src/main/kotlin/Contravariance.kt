fun main(args: Array<String>) {
    // making this an anonymous object with keyword "object"
    val roseTender = object : FlowerCare<Rose2> {
        override fun prune(flower: Rose2) {
            println("I am pruning a rose")
        }
    }

    val roseGarden = Garden2<Rose2>(listOf(Rose2(), Rose2()), roseTender)
    roseGarden.tendFlower(0)

    val daffodilTender = object : FlowerCare<Daffodil> {
        override fun prune(flower: Daffodil) {
            println("I am pruning a daffodil")
        }
    }

    val daffodilGarden = Garden2<Daffodil>(listOf(Daffodil(), Daffodil(), Daffodil()), daffodilTender)
    daffodilGarden.tendFlower(2)

    val flowerTender = object : FlowerCare<Flower2> {
        override fun prune(flower: Flower2) {
            println("I am pruning a Flower")
        }
    }

    // even with the above, we still can not do:
    // val daffodilGarden2 = Garden2<Daffodil>(listOf(Daffodil(), Daffodil(), Daffodil()), flowerTender)
    // we will geta type mismatch error
    // after adding in to interface FlowerCare<in T> {...} below, now we can do this
    val daffodilGarden2 = Garden2<Daffodil>(listOf(Daffodil(), Daffodil(), Daffodil()), flowerTender)
    // now we can reduce repetition and remove the flower and daffodil tender
}


class Garden2<T : Flower2>(val flowers: List<T>, val flowerCare: FlowerCare<T>) {
    fun pickFlower(i: Int) = flowers[i]
    fun tendFlower(i: Int) {
        flowerCare.prune(flowers[i])
    }
}

open class Flower2 {}

class Rose2 : Flower2() {}

class Daffodil : Flower2() {}

interface FlowerCare<in T> {
    fun prune(flower: T) // in position
    // fun pick(i: Int): T - out position
}

