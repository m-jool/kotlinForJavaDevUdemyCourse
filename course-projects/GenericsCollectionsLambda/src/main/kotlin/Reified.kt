import java.math.BigDecimal

fun main(args: Array<String>) {
    val list: List<Any> = listOf("string", 1, BigDecimal(2.25), "bla", BigDecimal(-299.3))
    val bigDec = getElementsOfType<BigDecimal>(list)
    println(bigDec)
    println(getElementsOfType<String>(list))
}

inline fun <reified T> getElementsOfType(list: List<Any>): List<T> {
    var newList: MutableList<T> = mutableListOf()
    for (element in list) {
        if (element is T) {
            newList.add(element)
        }
    }

    return newList
}