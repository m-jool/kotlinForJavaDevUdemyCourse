fun main(args: Array<String>) {
    val strings = listOf("1", "2", "bla")
    if (strings is List<String>) {
        println("strings is a List<String>")
    }

    val list: List<Any> = listOf("str1", "str2")
    // The bellow shows an error: can not check for instance of erased type
    // if (list is List<String>) {
    //     println("list is a List<String>")
    // }

    // the below is like Java, it works
    if (list is List) {
        println("list is a List")
    }

    var listAny: Any = listOf("str1", "str2")
    // The below does not work, in Kotlin, you must always specify the type
    // if (list2 is List) {
    //     println("list is a List")
    // }
    // so we use "*" => star projection syntax, it sort of acts like a wilde card
    if (listAny is List<*>) {
        println("list2 is a List, thank you star projection")
    }

    // as operator can be used for casting
    // of course here, smart casting is happening: list2 (Any) is known to be a List of something
    if (listAny is List<*>) { // here we are checking that list2 is a list of anything
        println("list2 contains strings")
        val strList = listAny as List<String>
        println(strList.get(1).replace("str", "string"))
    }

    // thus, given the above, the below code triggers a java.lang.ClassCastException
    listAny = listOf(1, 2, 3)
    if (listAny is List<*>) { // here we are checking that list2 is a list of anything
        println("list2 contains strings")
        val strList = listAny as List<String>
        println(strList.get(1).replace("str", "string"))
    }
}