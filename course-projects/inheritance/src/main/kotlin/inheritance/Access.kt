package inheritance

class Access {
    var x: Int = 0
        get() = field
        set(value) {
            if (value > 6) field = 7
        }

    constructor(x: Int) {
        this.x = x
    }
}

class Temperature {
    var celsius: Double = 0.0
        set(value) {
            field = if (value >= -273.15) value else -273.15
        }

    val fahrenheit: Double
        get() = (celsius * 9 / 5) + 32  // Computed without modifying backing field

    init {
        celsius = 0.0
    }
}

fun main() {
    var x = Access(9)

    println(x.x)

    var y = "hello"?.let {
        println("yoyo")
        it + "jeje"
    }

    println(y)

    val temp = Temperature()
    temp.celsius = 25.0
    println(temp.celsius)    // Output: 25.0
    println(temp.fahrenheit) // Output: 77.0

    temp.celsius = 50.0
    println(temp.celsius)
    println(temp.fahrenheit)

//    temp.fahrenheit = 100.0
//    can not be reassigned

    temp.celsius = -300.0
    println(temp.celsius)    // Output: -273.15

    val seasons = arrayOf("spring", "summer", "autumn", "fall")
    seasons.forEach { println(it) }
    seasons.forEachIndexed { index, value -> println("$index is $value") }

    val myList = listOf("jofe", "john", "jane")
        .asSequence()
        .filter { println(it); it[3] == 'e' }
        .map { println(it); it.uppercase() }
        .toList()

    println(myList)
}