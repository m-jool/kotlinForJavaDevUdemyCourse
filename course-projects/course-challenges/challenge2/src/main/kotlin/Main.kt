import dummy.Dummy

fun main(args: Array<String>) {
    val x = -3847.384F
    val y: Float? = (-3847.384).toFloat()

    val arr1: Array<Short> = Array(5) { i -> (i + 1).toShort() }
    val arr11 = shortArrayOf(1, 2, 3, 4, 5)
    val arr111: Array<Short> = arrayOf(1, 2, 3, 4, 5)

    val arr2: Array<Int?> = Array(200 / 5) { i -> (i + 1) * 5 }
    val arr22 = Array<Int?>(200 / 5) { i -> (i + 1) * 5 }

    val arr3 = arrayOf('a', 'b', 'c')
    val arr33 = charArrayOf('a', 'b', 'c')

    val dummy = Dummy()
    dummy.method1(arr3.toCharArray())
    dummy.method1(arr33)

    val a: String? = "I AM IN UPPERCASE"
    val b: String = a?.lowercase() ?: "I give up!"
    a?.let { it.lowercase().replace("am", "am not") }

    val myNonNullVariable: Int? = null
    myNonNullVariable!!.toDouble()
}