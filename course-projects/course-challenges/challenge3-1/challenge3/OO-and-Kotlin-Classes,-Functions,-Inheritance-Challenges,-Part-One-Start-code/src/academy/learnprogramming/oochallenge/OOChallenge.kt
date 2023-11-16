package academy.learnprogramming.oochallenge

fun main(args: Array<String>) {
    val kotlineBike = KotlinBicycle(1, 2, 3)
    val kotlinMountainBike = KotlinMountainBike(1, 2, 3, 4)
    val kotlinRoadBike = KotlinRoadBike(1, 2, 3, 4)

    kotlineBike.printDescription()
    kotlinMountainBike.printDescription()
    kotlinRoadBike.printDescription()

    val kotlineBike2 = KotlinBicycle(cadence = 1, speed = 3)
    val kotlinMountainBike2 = KotlinMountainBike(seatHeight = 1, cadence = 2, speed = 3)

    kotlineBike2.printDescription()
    kotlinMountainBike2.printDescription()

    val kotlinRoadBike3 = KotlinRoadBike(1, 1, 1, color = "green")

    KotlinMountainBike.printListOfColors()
    KotlinMountainBike.listOfColors.forEach { it -> println(it) }
    KotlinMountainBike.listOfColors.forEach(fun(it) {
        println(it)
    })
}




