import java.math.BigDecimal

fun main(args: Array<String>) {
    val list: MutableList<String> = mutableListOf("Hello")
    list.get(0).uppercase()
    list[0].uppercase()

    list.add("goodbye")

    printCollection(list)

    val bdList = mutableListOf(BigDecimal(-33.45), BigDecimal(3503.99), BigDecimal(0.329))

    genericPrintCollection(list)
    genericPrintCollection(bdList)

    list.extendedGenericPrintCollection()
    bdList.extendedGenericPrintCollection()

    val shorts: List<Short> = mutableListOf(1, 2, 3, 4)
    val doubles: List<Double> = mutableListOf(1.0, 2.2, 3.4, 4.5)

    convertToNumber(shorts)
    convertToNumber(doubles)

    appendChars(StringBuilder("Bla"), StringBuilder("Nlo"))
}

fun printCollection(collection: List<String>) {
    for (item in collection) {
        println(item)
    }
}

// <T> => type parameter declaration
fun <T> genericPrintCollection(collection: List<T>) {
    for (item in collection) {
        println(item)
    }
}

// We can also do extension function
fun <T> List<T>.extendedGenericPrintCollection() {
    for (item in this) {
        println(item)
    }
}

// Boundaries: Bounded Types
fun <T : Number> convertToNumber(collection: List<T>) {
    for (item in collection) {
        println(item.toInt()) // we need to add a boundary else we can not call .toInt() on item
    }
}

// Boundaries: Multiple Boundaries
fun <T> appendChars(item1: T, item2: T)
        where T : CharSequence, T : Appendable {
    println(item1.append(item2))
}
