package academi.learnprogramming.challenge1

fun main(args: Array<String>) {
    val hello1 = "Hello"
    val hello2 = "Hello"

    println("ref equality check: ${hello1 === hello2}")
    // results is true bcz Java has only 1 instance of a String literal in its pool given that strings are immutable

    println("struct equality check: ${hello1 == hello2}")

    var mum: Int = 2988
    // default data type for numbers is Int

    val text: Any = "The Any type is the root of the Kotlin classhierarchy"
    if (text is String) {
        println(text.uppercase())
    }

    println(
        """    1
          |   11
          |  111
          | 1111
        """.trimMargin("|")
    )
}