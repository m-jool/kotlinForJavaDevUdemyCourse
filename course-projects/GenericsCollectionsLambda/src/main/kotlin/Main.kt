fun main(args: Array<String>) {
    val employees = listOf(
        Employee("john", "bla", 2010),
        Employee("Bro", "El Sis", 1080)
    )

    println(employees.minBy { e -> e.startYear })
    println(employees.minBy({ e -> e.startYear }))
    println(employees.minBy { e: Employee -> e.startYear })
    println(employees.minBy { it.startYear })
    println(employees.minBy(Employee::startYear))

    run(::topLeve)

    println(countTo100())
    println(countTo100WithLambda())

    findByLastName(employees, "bla")
    findByLastName(employees, "hahahaha")
    findByLastName2(employees, "bla")
    findByLastName2(employees, "hahahaha")

    "some String".apply someString@{
        "another String".apply {
            println(toLowerCase()) // tagets "another string as receiver object"
            println(this@someString.toUpperCase()) // tagets "some string as receiver object"
        }
    }

}

data class Employee(val firstName: String, val lastName: String, val startYear: Int) {

}

fun useParamter(employees: List<Employee>, num: Int) {
    employees.forEach {
        println(it.firstName)
        println(it.startYear)
        println(num)
    }
}

fun topLeve() {
    println("i am top level")
}

fun countTo100(): String {
    val numbers = StringBuilder()
    for (i in 1..99) {
        numbers.append(i)
        numbers.append(", ")
    }
    numbers.append(100)
    return numbers.toString()
}

fun countTo100WithLambda(): String {
    val numbers = StringBuilder()

    return with(numbers) {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
        toString()
    }
}

fun countTo100WithLambda2(): String =
    with(StringBuilder()) {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
        toString()
    }

fun countTo100ApplyLambda3(): String =
    StringBuilder().apply {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100)
        toString()
    }.toString()

fun findByLastName(employees: List<Employee>, name: String) {
    for (employee in employees) {
        if (employee.lastName == name) {
            println("YES, found")
            return
        }
    }

    println("found none")
}

fun findByLastName2(employees: List<Employee>, name: String) {
    employees.forEach {
        if (it.lastName == name) {
            println("YES, found")
            return // the return here also returns from the function and not the lambda
        }
    }

    println("found none")
}

fun findByLastNameLocalReturn(employees: List<Employee>, name: String) {
    employees.forEach returnBlock@{
        if (it.lastName == name) {
            println("YES, found")
            return@returnBlock
        }

        println("found none")
    }
}