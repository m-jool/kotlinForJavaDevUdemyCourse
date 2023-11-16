fun main(args: Array<String>) {
    println(getNumber("22"))
    println(getNumber("bla"))
    println(getNumber("22.5"))

    println(getNumber2("22.5") ?: "it was null")

//    println(getNumber2("22.5") ?: throw IllegalAccessException("was not an int"))

//    println(getNumber3("22.5"))


}

fun getNumber(str: String): Int {
    // like other blocks, the last expression's value can serve as a return value
    return try {
        Integer.parseInt(str) // returns the result of this
    } catch (ex: NumberFormatException) {
        0 // returns zero
    } finally { // like java, always executes
        println("finally!")
    }
}

// nullable return type
fun getNumber2(str: String): Int? {
    // like other blocks, the last expression's value can serve as a return value
    return try {
        Integer.parseInt(str) // returns the result of this
    } catch (ex: NumberFormatException) {
        null
    } finally { // like java, always executes
        println("finally bla!")
    }
}

// re-throw / chain exception
fun getNumber3(str: String): Int {
    // like other blocks, the last expression's value can serve as a return value
    return try {
        Integer.parseInt(str) // returns the result of this
    } catch (ex: NumberFormatException) {
        throw IllegalArgumentException("twas bad bro", ex)
    } finally { // like java, always executes
        println("finally bla!")
    }
}

fun notImplementedYet(something: String): Nothing {
    throw IllegalArgumentException("implement me!")
}