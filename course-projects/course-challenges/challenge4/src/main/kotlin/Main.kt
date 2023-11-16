fun main(args: Array<String>) {
    for (num in 5..5000 step 5) {
        println(num)
    }

    for (num in -500..0) {
        println(num)
    }


    var previousPreviousResult: Int = 0
    var previousResult: Int = 0
    var result: Int = 0
    for (i in 0..15) {
        if (i == 0) {
            result = 0
            println(result)
            previousResult = result
        } else if (i == 1) {
            result = 1
            println(result)
            previousPreviousResult = 0
            previousResult = result
        } else {
            result = previousResult + previousPreviousResult
            println(result)
            previousPreviousResult = previousResult
            previousResult = result
        }
    }

    // We want the output to be 1, 11, 100, 99, 98, 2
    for (i in 1..5) {
        println(i)
        if (i == 2) break
        jloop@ for (j in 11..20) {
            println(j)
            for (k in 100 downTo 90) {
                println(k)
                if (k == 98) break@jloop
            }
        }
    }

    val num: Int = 10
    val dNum: Double = if (num > 100) -234.567 else if (num < 100) 444.555 else 0.0
    println(dNum)

    println(
        when {
            num > 100 -> -234.567
            num < 100 -> 444.555
            else -> 0.0
        }
    )
}