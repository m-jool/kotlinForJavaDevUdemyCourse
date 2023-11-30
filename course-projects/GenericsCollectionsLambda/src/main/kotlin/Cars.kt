fun main(args: Array<String>) {
    val immutableMap: Map<Int, Car> = mapOf(
        1 to Car("blue", "toyota", 2016),
        2 to Car("red", "ford", 1990),
        3 to Car("green", "bmw", 2006),
    )

    println(immutableMap.javaClass)
    println(immutableMap)

    val mutableMap = mutableMapOf(
        "bla bla" to Car("blue", "toyota", 2016),
        "juju's" to Car("red", "ford", 1990),
        "fun" to Car("green", "bmw", 2006),
    )

    println(mutableMap.javaClass)
    println(mutableMap)

    val hashMap = hashMapOf(
        "bla bla" to Car("blue", "toyota", 2016),
        "juju's" to Car("red", "ford", 1990),
        "fun" to Car("green", "bmw", 2006),
    )

    println(hashMap.javaClass)
    println(hashMap)

    val pair = Pair(10, "ten")
    val value1 = pair.first
    val value2 = pair.second

    // we destructrured or distributed an instance
    val (valueA, valueB) = pair

    for (entry in mutableMap) {
        println(entry.key)
        println(entry.value)
    }

    for ((key, value) in mutableMap) {
        println(key)
        println(value1)
    }

    val car = Car("red", "bmw", 1994)
    val (color, model, year) = car

    val dataCar = DataCar("red", "bmw", 1994)
    val (color2, model2, year2) = dataCar

    val setInts = setOf(1, 2, 3, 4, 5, -20)
    println(setInts)
    println(setInts.plus(20))
    println(setInts)

    val mutableSetInts = mutableSetOf(1, 2, 3, 4 - 10)
    mutableSetInts.add(30)
    mutableSetInts.remove(3)
    println(mutableSetInts)

    println(mutableSetInts.average())
    println(mutableSetInts.drop(2))

    println(setInts.filter { it % 2 != 0 })

    val immutableMap2: Map<Int, Car> = mapOf(
        3 to Car("green", "bmw", 2006),
        1 to Car("blue", "toyota", 2016),
        2 to Car("red", "ford", 1990),
        4 to Car("red", "merc", 1992),
    )

    println(immutableMap2.filter { it.value.year < 2010 })

    val ints = arrayOf(1, 2, 3, 4, 5)
    val add10List: MutableList<Int> = mutableListOf()
    for (i in ints) {
        add10List.add(i + 10)
    }
    println(add10List)

    val add10List2 = ints.map { it + 10 }
    print(add10List2)

    println(immutableMap2.map { it.value.year })
    println(immutableMap2.filter { it.value.model == "ford" }.map { it.value.color })

    println(immutableMap2.all { it.value.year > 2014 })
    println(immutableMap2.any { it.value.year > 2014 })
    println(immutableMap2.count { it.value.year > 2014 })

    val cars = immutableMap2.values
    println(cars.find { it.year > 2014 })
    println(cars.groupBy { it.color })

    println(immutableMap2.toSortedMap())
    println(cars.sortedBy { it.year })

    println(immutableMap2.asSequence().filter { it.value.model == "ford" }.map { it.value.color })

    println("----- sequences -----")
    listOf("joe", "john", "jane")
        .asSequence()
        .filter { println(it); it[0] == 'j' }
        .map { println(it); it.uppercase() }
        .toList()
}

class Car(val color: String, val model: String, val year: Int) {

    operator fun component1() = color

    operator fun component2() = model

    operator fun component3() = year
}

data class DataCar(val color: String, val model: String, val year: Int) {}
