fun main(args: Array<String>) {
    val range = 1..5
    val charRange = 'a'..'z'
    val sringRange = "ABC".."XYZ"

    val backwardsRange = 5.downTo(1) //
    val backwardsRange2 = 5..1 // backwards rand this way does not work

    println(5 in range)
    println(1 in range)

    println(5 in backwardsRange)
    println(1 in backwardsRange)

    println(5 in backwardsRange2)
    println(1 in backwardsRange2)

    val rangWithSteps = 3..15
    val rangWithSteps4 = 3..15 step 4
    val rangWithSteps3 = rangWithSteps.step(3)
    val reversedRange = rangWithSteps.reversed()

    for (n in rangWithSteps3) {
        println(n)
    }

    for (n in reversedRange) {
        println(n)
    }

    val str = "hello"
    for (c in str) {
        println(c)
    }

    for (num in 1..20 step 4) {
        println(num)
    }

    for (num in 20 downTo 15 step 2) {
        println(num)
    }

    for (num in 1 until 10) {
        println(num)
    }

    for (num in 20 downTo 10 subtract setOf(14, 15)) {
        println(num)
    }

    val seasons = arrayOf("spring", "summer", "autumn", "fall")
    seasons.forEach { println(it) }
    seasons.forEachIndexed { index, value -> println("$index is $value") }
    for (index in seasons.indices) {
        println("$index is ${seasons[index]}")
    }

    for (i in 1..3) {
        println(i)
        jloop@ for (j in 1..4) { // we can give loops a name
            println(j)
            for (k in 1..10) {
                println(k)
                if (k == 7) {
                    break; // breaks only the k loop
                    // if we want to break as the jloop, we 1st give it a name then
                    // break@jloop;
                    // also works with continue
                }
            }
        }
    }
}