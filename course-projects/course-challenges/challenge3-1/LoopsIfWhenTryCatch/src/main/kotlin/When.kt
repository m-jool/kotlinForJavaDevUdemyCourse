import java.math.BigDecimal

fun main(args: Array<String>) {
    var x = 100

    when (x) {
        100 -> println(100)
        200 -> println(200)
        300 -> println(200)
        else -> println("no match")
    }

    x = 600
    when (x) {
        100 -> println(100)
        200, 600 -> println(200) // we can have multiple cases
        300 -> println(200)
        else -> println("no match")
    }

    x = 220
    when (x) {
        100 -> println(100)
        in 200..250 -> println("in range") // we can have ranges
        300 -> println(200)
        else -> println("no match")
    }

    x = 330
    val y = 30
    when (x) {
        100 -> println(100)
        in 200..250 -> println("in range")
        300 + y -> println(300) // we can also use expressions
        else -> println("no match")
    }

    val obj: Any = "I am a string"
    val obj2: Any = BigDecimal(2.2)
    val obj3: Any = 45
    val something: Any = obj2

    if (something is BigDecimal) {
        println("big D")
    }

    when (something) {
        is String -> println("String")
        is BigDecimal -> println("big D")
    }

    // Smart casting in play
    when (something) {
        is String -> println(something.uppercase())
        is BigDecimal -> println("big D")
    }

    val z = when (something) {
        is String -> {
            println(something.uppercase())
            1 // this would be the return value if "something" was a string
        }

        is BigDecimal -> println("big D")
        else -> print("bla") // else here is mandatory, z MUST have a value, in this case the return value will be "Unit"
    }

    val season = Season.FALL
    val str = when (season) {
        Season.FALL -> "it is fall"
        Season.SUMMER -> "it is summer"
        else -> "dunno man"
    }

    println(str)

    // "when" can be used as an alternative to if else => used without an input value
//    when {
//        x < y -> do this
//        x == y -> dot that
//        else -> finish it
//    }
}

enum class Season {
    SPRING, SUMMER, FALL, WINTER
}