fun main(args: Array<String>) {
    val cars1 = mutableListOf(Car2(), Car2())
    val cars2: MutableList<Car2> = mutableListOf()
    copyCars(cars1, cars2)

    val fords1 = mutableListOf(Ford(), Ford())
    val fords2: MutableList<Ford> = mutableListOf()
    // copyCars(fords1, fords2): this gives errors, it wants cars, so make the method generic to relax or widen the invariant typing
    copyCars(fords1, fords2)
    // copyCars(fords1, cars2): this gives an error because T has to be the same
    val cars3: MutableList<Car2> = mutableListOf(Ford(), Ford()) // this works even though the above does not
    // so how can we fix the copyCars(fords1, cars2) -> looking at the function, we do not modify the source, and we do not read from the destination
    copyCars(fords1, cars2) // we add out to the source => now it works, this is what we call Use-Site covariance
    // because we are changing the class, just some independent function that makes use of said classes
    // this is also called type projection
    // this helps when dealing with 3 party libs, and we want to write functions that use them
    // PS: use site variance in Kotlin is equivalent to wilde cards in Java
    // PS: for the copyCars method, we can also put "in" with the destination variable

}

fun <T : Car2> copyCars(source: MutableList<out T>, destination: MutableList<T>) {
    for (car in source) {
        destination.add(car)
    }
}

open class Car2 {}

class Toyota : Car2() {}

class Ford : Car2() {}