package inheritance

import java.time.Year


fun main(args: Array<String>) {
    println(CompComs.getTagLine())
    println(CompComs.getCopyRightLine())

    SomeClass().accessPrivateVar()
    SomeClass.accessPrivateVar2()
    SomeClass.bla.accessPrivateVar2()

    val someFactoryClass = SomeFactoryClass.justAssign("BLOQha")
    val someFactoryClass1 = SomeFactoryClass.upperOrLowerCase("BLOQha", true)
    val someFactoryClass2 = SomeFactoryClass.upperOrLowerCase("BLOQha", false)
    println(someFactoryClass.someString)
    println(someFactoryClass1.someString)
    println(someFactoryClass2.someString)

    wantsSomeInterface(object : SomeInterface {
        override fun mustImplement(num: Int) = "this is from mustImplement my int: ${num * 100}"
    })

    var thisIsMutable = 45

    wantsSomeInterface(object : SomeInterface {
        override fun mustImplement(num: Int): String {
            thisIsMutable++
            return "this is $thisIsMutable from mustImplement my int: ${num * 200}"
        }
    })

    println(Department2.ACCOUNTING.getDepInfo())
}


object CompComs {
    val currentYear = Year.now().value
    fun getTagLine() = "our company rocks!"
    fun getCopyRightLine() = "blabla \u00A9 $currentYear blabla"
}

class SomeClass {
    private var privateVar = 6
    fun accessPrivateVar() {
        println(privateVar)
    }

//    companion object {
//        private var privateVar2 = 7
//        fun accessPrivateVar2(){
//            println(privateVar2)
//        }
//    }

    companion object bla {
        private var privateVar2 = 7
        fun accessPrivateVar2() {
            println(privateVar2)
        }
    }
}

class SomeFactoryClass private constructor(val someString: String) {
//    val someString: String
//
//    private constructor(str: String) {
//        someString = str
//    }
//
//    constructor(str: String, lowerCase: Boolean) {
//        if (lowerCase) {
//            someString = str.lowercase()
//        } else {
//            someString = str.uppercase()
//        }
//    }

    companion object {
        fun justAssign(str: String) = SomeFactoryClass(str)

        fun upperOrLowerCase(str: String, lowerCase: Boolean): SomeFactoryClass {
            if (lowerCase) {
                return SomeFactoryClass(str.lowercase())
            } else {
                return SomeFactoryClass(str.uppercase())
            }
        }
    }
}

interface SomeInterface {
    fun mustImplement(num: Int): String
}

fun wantsSomeInterface(si: SomeInterface) {
    println("printing from SomeInterface ${si.mustImplement(22)}")
}

enum class Department {
    HR, IT, ACCOUNTING, SALES
}

enum class Department2(val fullName: String, val numEmployees: Int) {
    HR("hr", 5),
    IT("it", 7),
    ACCOUNTING("acc", 12),
    SALES("sal", 20);

    fun getDepInfo() = "$fullName and $numEmployees"
}

