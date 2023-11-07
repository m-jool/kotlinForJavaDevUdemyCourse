typealias EmployeeSet = Set<Employee>

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    // val: equivalent to final in Java, once value is assigned, it becomes immutable
    val number = 25
    // infered type is "int"
    val number2: Int = 25
    // or we can tell kotlin exactly what we want

    val number3: Int
    number3 = 10
    // number3 = 11 => this will throw the error

    var number4: Int
    number4 = 9
    number4 = 12
    // var: value is mutable

    val employee = Employee("lynn smith", 500)
    employee.name = "lynn jones"
    // employee.id = 5
    // val employee can not be assigned a new Employee instance (val), but that does not mean that its member variables
    // can not be changed, in this case, the name can be changed (var) but id can not

    var employee2 = Employee("lynn smith", 500)
    employee2 = Employee("john smith", 100)

    // no need for new keyword
    var employee3: Employee = Employee("john smith", 100)

    val employees: EmployeeSet

    val names = arrayListOf("bla", "blo", "bli")
    println(names[1])

    println(employee == employee2)
    println(employee2 == employee3)
    println(employee.equals(employee2))
    println(employee2.equals(employee3))
    println(employee === employee2)
    println(employee2 === employee3)
    val employee4 = employee2
    println(employee2 === employee4)
    println(employee2 != employee4)
    println(employee2 !== employee4)
    println(employee2 != employee3)
    println(employee2 !== employee3)

    val something: Any = employee2
    if (something is Employee) {
        // to cast in Java: (Employee) something
        // to cast in kotlin
        val newEmp = something as Employee
    }

    val bla = 'c' // single quotes: for chars only: char literal vs " => string literal
    // val blaS = 'chshshs'

    val change = 4.22
    println("to show the value of change we use: \$change and its value is $change (ps: $$change shows the $ sign)")

    val x = 10
    val y = 20.2
    println("division = ${x / y}")
    println("employee id = ${employee.id}")

    val windowsFilePath = "c:\\someDir\\Somedir"
    val windowsFilePath2 = """"c:\someDir\someDir"""


    // can be multiline:
    var bro = """balbalbalbalbalbalba
lkasdjflkajsdlkfj
asdfasdfasdf"""
    println(bro)
    bro = """balbalbalbalbalbalba
            lkasdjflkajsdlkfj
            asdfasdfasdf"""
    println(bro)
    // the indentation here looks bad, but if we beautify the code, the resulting string will contain the tabs
    // so we use trimMargin method with a trim margin char of our choosing
    bro = """balbalbalbalbalbalba
            *lkasdjflkajsdlkfj
            *asdfasdfasdf""".trimMargin("*")
    println(bro)

}

class Employee(var name: String, val id: Int) {

    override fun equals(obj: Any?): Boolean {
        // obj is instance of Employee
        if (obj is Employee) {
            return name == obj.name && id == obj.id
        }

        return false
    }

    override fun toString(): String {
        return "Employee(name='$name', id=$id)"
        //return "Employee(name=$name, id=$id)" you can remove the single quotes, but they are usually put around string values
        // $varname => String template instead of concatenating or using string format methods
    }


}