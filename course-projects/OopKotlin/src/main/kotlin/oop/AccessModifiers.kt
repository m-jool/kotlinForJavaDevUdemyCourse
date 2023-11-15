package oop

import oop.Utils

val MY_CONSTANT = 100

fun main(args: Array<String>) {

    val emp1 = Employee1()
    println(emp1)

    val emp = Employee("john")
    println(emp.name)
    emp.fullTime = false

    val emp2 = Employee("Joe")
    println(emp2.name)
    println(emp2.fullTime)

    val emp3 = Employee("Jane", false)
    println(emp3.name)
    println(emp3.fullTime)

    println(MY_CONSTANT)

    val car = Car("blue", "toyota", 2015)
    println(car.toString())
    println(emp3.toString())

    val empA = Employee("john")
    val empB = Employee("john")
    println(empA == empB) // False: equals method requires override
    println(empA === empB)

    val car2 = Car("blue", "toyota", 2015)
    println(car == car2) // True: data class => by default, it does structural comparision
    println(car === car2)

    var car3 = car.copy()
    println(car3)
    println(car === car3) // false: different instance

    var car4 = car.copy(year = 2016)
    println(car4)

    println(labelMultiply(3, 4, "bla:"))
    println(labelMultiply2(3, 4, "bla:"))
    println(labelMultiply2(label = "bla:", y = 3, x = 4))

    println(emp.upperCaseName())

    printCars(car, car2, car3, car4, label = "blabl is: ")

    val manyCars = arrayOf(car, car2, car3)
    // We use the spread operator to spread the array
    printCars(*manyCars, label = "blo:")

    var moreCars = arrayOf(car2, car3)
    var lotsOfCars = arrayOf(manyCars, moreCars, car4)
    for (c in lotsOfCars) {
        println(c)
    }

    lotsOfCars = arrayOf(*manyCars, *moreCars, car4)
    for (c in lotsOfCars) {
        println(c)
    }

    println(Utils().upperFirstAndLast("this is all lowercase"))
    println(("this is all lowercase").upperFirstAndLast())
}

private class Employee1 {

}

//class Employee constructor(name: String) {
//    val name: String
//
//    init {
//        this.name = name
//    }
//}

//class Employee(val name: String) {
//
//    var fullTime: Boolean = true
//
//    // 2ndary constructor can not declare members (val or var)
//    // also, it must delegate what needs to be delegated to the primary constructor =>" : this(...)"
//    constructor(name: String, fullTime: Boolean) : this(name) {
//        this.fullTime = fullTime
//    }
//
//}

// The kotlin way
class Employee(val name: String, fullTime: Boolean = true) {

    var fullTime = fullTime
        get() {
            println("running the custom get")
            return field // this is called the backing field, this is only generated if we need the value of fullTime
        }
        set(value) {
            println("running the custom set")
            field = value
        }

    fun upperCaseName() = name.uppercase()
}

data class Car(val color: String, val model: String, val year: Int) {

}

fun labelMultiply(x: Int, y: Int, label: String): String {
    return "$label ${x * y}"
}

fun labelMultiply2(x: Int, y: Int, label: String) = "$label ${x * y}"

inline fun labelMultiply3(x: Int, y: Int, label: String) = "$label ${x * y}"

fun printCars(vararg cars: Car, label: String) {
    for (car in cars) {
        println(car.toString())
    }
}

fun String.upperFirstAndLast(): String {
    val upperFirst = this.substring(0, 1).uppercase() + this.substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) + upperFirst.substring(
        upperFirst.length - 1,
        upperFirst.length
    ).uppercase()
}
