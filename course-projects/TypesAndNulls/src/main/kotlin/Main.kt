fun main(args: Array<String>) {
    val a = 5
    val b: Long = a.toLong() // no automatic widening like Java

    val x: Long = 5
    val y = 6F

    val names = arrayOf("bla", "blo", "bli")
    // array of longs
    val long1 = arrayOf(1L, 2L, 3L)
    val long2 = arrayOf<Long>(1, 2, 3) // => arrays in kotlin are collections
    println(long1 is Array<Long>)
    println(long2 is Array<Long>)
    println(long1[0])
    println(long1.get(0))

    val myArr = Array(16) { i -> i * 2 }
    myArr.forEach { i -> println(i) }
    for (num in myArr) {
        println(num)
    }

    // the 2 expressions below produce the same result
    val allZeros = Array(100) { 0 }
    val allZeros2 = Array(100) { i -> 0 }

    val mixedArray = arrayOf("bla", 0, 1L, 2.4F) // results in an array of "Any"

    val intArr = intArrayOf(1, 2, 3)

    // method .toIntArray() can be used to convert a kotlin Int array to a general int array of primitive ints
    // in order to do the opposite, and convert the array to a kotlin Int array, we use .toTypedArray()
    // val x: Array<Int> = y.toTypedArray()

    val str: String? = null
    // val str: String = null => this produces a compiler error
    // but, once a variable is nullable, the operations that can be done on it become restricted
    // certain string methods for example can no longer be called
    // so get access to it, we do a null check => smart null check like smart casting
    if (str != null) {
        str.length
    }

    // the above can be replaced with safe access expression
    str?.length

    // the elvis operator "?:"
    val str2 = str ?: "this is the default value if str is null"
    val str3: String = str ?: "this is the default value if str is null"
    val str4: String? = str ?: "this is the default value if str is null"
    // HERE the compiler knows that str2, str3 and str4 CAN NOT BE NULL

    // safe casting
    val something: Any = arrayOf(1, 2, 3, 4)
    val str5 = something as? String // tring to cast an array of Any to string
    println(str5) // we get a null because we can not cast successfully here

    val myString: String? = "never null"
    println(myString!!.length) // in this case, if myString is null, we will actually get a null pointer exception
    // we get a kotlin.KotlinNullPointerException

    str?.let { println(it) }

    println(str == myString) // no error here even though str can be null, that is because == is a safe operatora

    val myArrayOfNulls: Array<Int?> = Array(16) { null }
    val myArrayOfNulls2 = arrayOfNulls<Int>(16)

}