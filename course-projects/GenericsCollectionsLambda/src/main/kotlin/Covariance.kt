fun main(args: Array<String>) {
    val shortList: List<Short> = listOf(1, 2, 3, 4, 5)
    convertToInt(shortList)

    val mutableShortList: MutableList<Short> = mutableListOf(1, 2, 3, 4, 5)
//    mutableConvertToInt(mutableShortList) => shows an error
}

fun convertToInt(collection: List<Number>) {
    for (num in collection) {
        println(num.toInt())
    }
}

fun mutableConvertToInt(collection: MutableList<Number>) {
    for (num in collection) {
        println(num.toInt())
    }
}

// Example on variance
fun waterGardern(garden: Garden<Flower>) {}

fun tendGarden(roserGarden: Garden<Rose>) {
    waterGardern(roserGarden)
    // the above gives a Type mismatch error
    // Required: Garden<Flower>
    // Found: Garden<Rose>
    // this happens because the garden class is invariant
    // we need to make it covariant: so we add the keyword out to class Garden<T : Flower> {}

}

open class Flower {}

class Rose : Flower() {}

class Daisy : Flower() {}

// a covariante comes with restrictions (like immutable classes)
// we can only use a covariant class in the "out" position
// function parameters are "in" position
// function return type are "out" position
class Garden<out T : Flower> {
    val listOfFlowers: List<T> = listOf()

    fun pickFlower(i: Int): T {
        return listOfFlowers.get(i)
    }
    // you can write the above as fun pickFlower(i: Int): T = listOfFlowers[i]

    // the below Type parameter T is declared as 'out' but occurs in 'in' position in type T
    // these concern member function, so passing a rose garden as a parameter to tendGarden(...) is OK
    // because there is nothing in it that affects the list of flowers
    // fun plantFlower(flower: T) {}
    // So why the restriction?
    // Because: nothing stops calling the plantFlower function with a "daisy" when we have a "rose" garden
}
