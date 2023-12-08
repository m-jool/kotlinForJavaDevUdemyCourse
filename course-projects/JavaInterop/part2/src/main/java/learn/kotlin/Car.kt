package learn.kotlin

import java.io.IOException

fun topLevel() = println("this is top level fun")
const val x = 8

class Car (val color:String, val model: String){
    companion object {
        @JvmStatic fun carComp () {
            println("i am comp obj of car")
        }
    }

    fun printMe(text: String) {
        println("I do not expect a null value: $text")
    }

    @Throws(IOException::class)
    fun doIO() {
        throw IOException()
    }

    @JvmOverloads fun defaultArgs(str: String, num: Int = 25){}
}

object SingletonObject {
    fun myFun() = println("bla")
}