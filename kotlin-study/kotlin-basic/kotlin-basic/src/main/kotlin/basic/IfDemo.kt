package basic

fun main() {
    val number1: Int = 9999999
    val number2: Int = 8888888

    // 表达式 比 大小 最大值
    val maxValue = if (number1 > number2) number1 else number2
    // println(maxValue)

    val max: Int = if (number1 > number2) {
        println("number1是最大的哦")
        // TODO
        // ....... 省略 200行代码
        number1
    } else {
        println("number2是最大的哦")
        // TODO
        // .......  省略 200行代码
        number2
    }
    // println(max)

    // 使用区间做判断
    val x = 80
    val y = 29
    if (x in 1..10 && y in 1..50) {
        // println("x y 轴 符合")
    } else {
        // println("x y 轴 不符合")
    }
    println()
    val number = 3
    val result = when (number) {
        1 -> {
            println("很开心")
            // 很多很多的逻辑..  省略 200行代码
            // ...
            // TODO ....
            "今天是星期一"
            99
        }
        2 -> {
            println("很开心")
            // 很多很多的逻辑..  省略 200行代码
            // ...
            // TODO ....
            "今天是星期二"
            88
        }
        3 -> {
            println("很开心")
            // 很多很多的逻辑..  省略 200行代码
            // ...
            // TODO ....
            "今天是星期三"
            true
            100
        }
        else -> 99
    }

    when (8) {
        1, 2, 3, 4, 5, 6, 7 -> println("满足")
        else -> println("不满足")
    }
}