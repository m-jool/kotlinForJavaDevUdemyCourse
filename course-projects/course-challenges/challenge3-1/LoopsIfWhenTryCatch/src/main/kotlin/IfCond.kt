fun main(args: Array<String>) {
    var x = 5
    var y = 0

    if (x == 5) {
        y = 6
    } else {
        y = 7
    }

    // in java we can do
    // y = x == 5 ? 6 : 7
    // in kotlin, there is no ternary operator
    val z = if (x == 5) 6 else 7

    val v = if (x == 5) {
        println(x)
        6
    } else {
        println("bla")
        7
    }

    println("blabla ${if (x == 5) 6 else 7}")
}