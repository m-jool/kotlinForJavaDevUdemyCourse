import java.Employee

fun main(args: Array<String>) {
    val employee = Employee("jane", "smith", 2000)
    employee.lastName = "jones"
//    employee.salaryLast3Years = arrayOf(50.25, 54.60, 56.42)
    // Solution 1
    employee.salaryLast3Years = floatArrayOf(50.25F, 54.60F, 56.42F)
    // Solution 2
    employee.salaryLast3Years = arrayOf(50.25F, 54.60F, 56.42F).toFloatArray()
}