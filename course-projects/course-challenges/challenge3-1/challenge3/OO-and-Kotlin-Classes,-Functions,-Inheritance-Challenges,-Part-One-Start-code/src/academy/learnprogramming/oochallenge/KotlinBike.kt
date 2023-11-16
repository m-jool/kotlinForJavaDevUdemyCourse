package academy.learnprogramming.oochallenge

open class KotlinBicycle(var cadence: Int, var gear: Int = 10, var speed: Int) {
    fun applyBrake(decrement: Int) {
        speed -= decrement
    }

    fun speedUp(increment: Int) {
        speed += increment
    }

    open fun printDescription() {
        println("Bike is in gear $gear with a cadence of $cadence travellingat a speed of $speed.")
    }
}

class KotlinMountainBike : KotlinBicycle {
    var seatHeight: Int
    var color: String = ""

    companion object {
        val listOfColors: List<String> = listOf("green", "blue", "red", "white", "black")

        fun printListOfColors() {
            println(listOfColors.toString())
        }
    }

    constructor(seatHeight: Int, cadence: Int, speed: Int, gear: Int) : super(cadence, gear, speed) {
        this.seatHeight = seatHeight
    }

    constructor(seatHeight: Int, cadence: Int, speed: Int) : super(cadence = cadence, speed = speed) {
        this.seatHeight = seatHeight
    }

    constructor(seatHeight: Int, cadence: Int, speed: Int, gear: Int, color: String) : super(cadence, gear, speed) {
        this.seatHeight = seatHeight
        this.color = color
    }

    override fun printDescription() {
        super.printDescription()
        println("the mountain bike has a seat height of $seatHeight.")
    }
}

class KotlinRoadBike(val tireWidth: Int, cadence: Int, speed: Int, gear: Int) : KotlinBicycle(cadence, speed, gear) {

    var color: String? = null

    constructor(tireWidth: Int, cadence: Int, speed: Int, gear: Int = 20, color: String?) : this(
        tireWidth,
        cadence,
        speed,
        gear
    ) {
        this.color = color ?: "blue"
    }

    override fun printDescription() {
        super.printDescription()
        println("the road bike has a tire width of $tireWidth.")
    }
}