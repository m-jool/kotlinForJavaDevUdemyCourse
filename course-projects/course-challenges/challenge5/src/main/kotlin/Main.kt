fun main(args: Array<String>) {
    val joe = Person("Joe", "Jones", 45)
    val jane = Person("Jane", "Smith", 12)
    val mary = Person("Mary", "Wilson", 70)
    val john = Person("John", "Adams", 32)
    val jean = Person("Jean", "Smithson", 66)

    val (fName, lName, age) = joe
    println("fName = $fName, lName = $lName and age = $age")

    // Solution 1
    val personMap: Map<String, Person> = mapOf(
        joe.lastName to joe,
        jane.lastName to jane,
        mary.lastName to mary,
        john.lastName to john,
        jean.lastName to jean
    )

    // Solution 2
    val personList = listOf(joe, jane, mary, john, jean)
    val personMap2 = makePersonMap(personList)

    // Solution 3
    val personMap3 = personList.map {person: Person -> person.lastName to person}.toMap()
    val personMap3v2 = personList.map {it -> it.lastName to it}.toMap()
    val personMap3v3 = personList.map {it.lastName to it}.toMap()

    println(personMap)
    println(personMap.javaClass)
    println(personMap2)
    println(personMap2.javaClass)
    println(personMap3)
    println(personMap3.javaClass)
    println(personMap3v2)
    println(personMap3v2.javaClass)
    println(personMap3v3)
    println(personMap3v3.javaClass)

    // Solution 1
    println(personMap.count { it.value.lastName.first().lowercase() == "s" })
    // Solution 2
    println(personMap.filter { it.value.lastName.startsWith("S") }.size)
    // Solution 3
    println(personMap.filter { it.value.lastName.startsWith("S") }.count())

    // Solution 1
    val namePairsList: MutableList<Pair<String, String>> = mutableListOf()
    personMap.forEach { (key, value) -> namePairsList.add(Pair(value.firstName, value.lastName)) }
    println(namePairsList)
    // Solution 2
    val namePairsList2: List<Pair<String, String>> = personMap.map { Pair(it.value.firstName,  it.value.lastName) }
    println(namePairsList)
    // Solution 3
    val firstNames = personMap.map { it.value.firstName }
    val lastNames = personMap.map { it.value.lastName }
    val namePairsList3 = firstNames.zip(lastNames)
    println(namePairsList3)

    // Solution 1
    personMap.forEach { println("${it.value.firstName} is ${it.value.age} old") }
    // Solution 2
    personMap.also { it.map { println("${it.value.firstName} is ${it.value.age} old") } }

    val list1 = listOf(1, 4, 9, 15, 33)
    val list2 = listOf(4, 55, -83, 15, 22, 101)
    // Solution 1
    val list3 = list1.intersect(list2)
    println(list3)
    // Solution 2
    val list3v2 = list1.filter { it in list2 }
    println(list3v2)
    // Solution 3
    val list3v3 = list1.filter { list2.contains(it) }
    println(list3v3)

    val regularPaper = Box<Regular>()
    var paper = Box<Paper>()

    // We want T to accept T or any of its subclasses: covariance
    paper = regularPaper

}

class Person(val firstName: String, val lastName: String, val age: Int){
    operator fun component1() = firstName
    operator fun component2() = lastName
    operator fun component3() = age
}

fun makePersonMap(personList: List<Person>): Map<String, Person>{
    val personMap: MutableMap<String, Person> = mutableMapOf()
    for (person in personList){
        personMap.put(person.lastName, person)
    }

    // toMap() -> returns an immutable map, which is what want in this challenge
    return personMap.toMap()
}

// We want T to accept T or any of its subclasses: covariance
class Box<out T: Paper> {

}

open class Paper {

}

class Regular: Paper() {

}

class Premium: Paper() {

}