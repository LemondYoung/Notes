/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : 流程控制
 * @date : 2018/1/29
 */
fun main(args: Array<String>) {
    if_normal(2)
    println(find_max(3, 4))
    when_normal(3)
    when_range(3)
    for_loop()
    for_with_range()
    for_with_index()
    for_break()
    for_break2()
    for_continue()
    while_loop()
    while_with_do()
}

/**
 * 基本的判断
 */
fun if_normal(a: Int) {
    if (a > 1) {
        println("a大于1")
    } else {
        println("a小于等于1")
    }
}

/**
 * 两个数的判断
 */
fun find_max(a: Int, b: Int): Int {
    val max = if (a > b) {
        a
    } else if (a < b) {
        b
    } else {
        a
    }
    return max
}

/**
 * when int匹配
 */
fun when_normal(a: Int) {
    when (a) {
        1 -> println("a等于1")
        2 -> println("a等于2")
        else -> println("a不等于1或2")
    }
}

/**
 * when 区间判断
 */
fun when_range(a: Int) {
    when (a) {
        in 1..10 -> println("1<=a<=10")
        else -> println("a不在1~10的范围内")
    }
}

/**
 * for基本用法
 */
fun for_loop() {
    val array = arrayOf(1, 2, 3, 4, 5)
    for (x in array) {
        println(x)
    }
}

/**
 * for in 用法
 */
fun for_with_range() {
    for (x in 1..5) {
        println(x)
    }
}

/**
 * 打印下标和值
 */
fun for_with_index() {
    val array = arrayOf(10, 9, 8, 7, 6)
    for ((index, value) in array.withIndex()) {
        println("index is ${index}")
        println("value is ${value}")
    }
}

/**
 * 打断for循环
 */
fun for_break() {
    for (x in 1..10) {
        if (x == 8) break
        println("x value is ${x}")
    }
}

/**
 * 双层循环
 * top@标记，当执行到y==3的时候，这次for循环则被停止
 */
fun for_break2() {
    top@ for (x in 1..5) {
        println("x value is ${x}")
        for (y in 1..5) {
            if (y == 3) break@top
            println("y value is ${y}")
        }
    }
}

/**
 * continue : 停止当前循环，执行下次的循环
 */
fun for_continue() {
    for (x in 1..5) {
        println("start")
        if (x == 3) continue
        println("x value is ${x}")
    }
}

/**
 * while循环
 */
fun while_loop() {
    var a = 10
    while (a > 0) {
        println(a)
        a--
    }
}

/**
 * do-while循环
 */
fun while_with_do() {
    var a = 10
    do {
        println(a)
    } while (a < 0)
}