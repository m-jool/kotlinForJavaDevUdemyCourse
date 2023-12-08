

fun main(args: Array<String>) {

    val car = Car("blue", "Ford", 2015)
    car.color = "green"
    println(car)

    //var model: String = car.model
    //println(model.javaClass)
    //model = null
    //println(model)

    //val color: Int = car.color

    car.variableMethod(5, "hello", "bye")
    var strings = arrayOf("hello", "bye")
    // car.variableMethod(6, strings) => can't do this, even though in Java we can and even though this is taking an array under the covers
    // we have to use the spread operator
    car.variableMethod(6, *strings)

//    (car.obj as java.lang.Object).notify()

    println(Car.x)
    println(Car.xString())
    println(Car.xString())
    println(Car.x)

    Car.demoMethod2({ println("i am in a thread") })
}