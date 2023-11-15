package inheritance

fun main(array: Array<String>){
    val laserPrinter = LaserPrinter("blo123", 15)
    laserPrinter.printModel()
}

// we use the keyword open: to make a class non-final
open abstract class Printer(val modelName: String) {
    // after adding abstract => we can remove the open keyword: it becomes redundant
    open fun printModel() = println("the model name is: $modelName")
    open fun printModel2() = println("the model name is: $modelName")

    // declaring an abtract method
    abstract fun bestSellingPrice(): Double
}

open class LaserPrinter(modelName: String, ppm: Int) : Printer(modelName) {
    override fun printModel() = println("the new output is: $modelName")
    final override fun printModel2() = println("the new output is: $modelName")
    override fun bestSellingPrice(): Double = 129.99
}

class SpecialLaserPrinter(modelName: String): LaserPrinter(modelName, 15){
    override fun printModel() = println("the SUPERLASER output is: $modelName")
    // override fun printModel2() = println("the new output is: $modelName") > This gives an error
}

open class bla {
    val x: Int
    constructor(x: Int){
        this.x = x
    }
}

class blo: bla{
    constructor(x: Int): super(x){} // if bla had a primary constructor, then super here will be calling it and not the 2ndary one
}

class Something: MySubInter {
    override val number: Int = 25

    override fun mySubString(str: String): String {
        TODO("Not yet implemented")
    }

    override fun myString(str: String): String {
        TODO("Not yet implemented")
    }

}

class SomethingElse: bla(5), MyInter, MyInter2 {
    override val number: Int = 25

    override fun myString(str: String): String {
        TODO("Not yet implemented")
    }

    override fun myString2(str: String): String {
        TODO("Not yet implemented")
    }
}

interface MyInter {
    val number: Int
    val number2: Int
        get() = 25
    val number3: Int
        get() {
            return 25
        }
    val number4: Int
        get() {
            return number * 5
        }
    fun myString(str: String): String
}

interface MySubInter: MyInter {
    fun mySubString(str: String): String
}

interface MyInter2 {
    fun myString2(str: String): String
}