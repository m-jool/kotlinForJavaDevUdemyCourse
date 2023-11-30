fun main(args: Array<String>) {
    val strings = listOf("spring", "summer", "fall", "winter")
    println(strings.javaClass)

    val emptyList = emptyList<String>()
    println(emptyList.javaClass)

    if (!emptyList.isEmpty()) {
        println(emptyList.get(0))
    }

    val notNullList = listOfNotNull("hello", null, "good bye")
    println(notNullList)

    val arrayList = arrayListOf(1, 2, 3)
    println(arrayList.javaClass)

    val mutableList = mutableListOf<Int>(1, 2, 3)
    println(mutableList.javaClass)

    val array = arrayOf("black", "while", "green")
    val list =
        listOf(*array) // we use the "*" spread operator to unpack an array, else we get a lis where the 1st element is an array itself
    println(list)

    val list2 = array.toList()

    val ints = intArrayOf(1, 2, 3)
    val intsList = ints.toList()
    println(intsList)

    println(mutableList)
    println(mutableList.get(1))
    mutableList.set(1, 5)
    println(mutableList)
    println(mutableList.get(1))


    val stringsList = listOf("spring", "summer", "fall", "winter", "summer")
    val colorList = listOf("black", "while", "red", "white", "red")
    println(stringsList.last())
    println(stringsList.first())

    println(stringsList.reversed())
    println(stringsList.asReversed())

    println(stringsList.getOrNull(5))
    println(stringsList.getOrElse(5) { it -> it * 10 })

    val intsList2 = listOf(1, 5, 6, 2)
    println(intsList2.max())

    println(colorList.zip(stringsList))

    println(colorList + stringsList)

    val noDupsList = colorList.union(stringsList)
    println(noDupsList)

    val noDupColors = colorList.distinct()
    println(noDupColors)

    val mutableSeasons = stringsList.toMutableList()
    mutableSeasons.add("some other season")
    println(mutableSeasons)
}