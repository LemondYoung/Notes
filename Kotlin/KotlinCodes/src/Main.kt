/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : 基本类型与方法定义
 * @date : 2018/1/29
 */

val double_type: Double = 1.0
val float_type: Float = 1.0f
val long_type: Long = 123L
val short_type: Short = 123
val int_type: Int = 123
val byte_type: Byte = 127
val a_char: Char = 'a'
val b_char = 'b'
val string_type: String = "你好"
val true_type: Boolean = true
val false_type: Boolean = false

fun main(args: Array<String>) {
    println(string_type)
    println(single(1, 2))
    println(add(1, 2))
    println(addThree(1, 1, 1))
    println(addThree(1, 1))
    println(addThree(1))
}

/**
 * 含有两个参数的方法
 */
fun add(a: Int, b: Int): Int {
    return a + b
}

/**
 * 含有2个默认值的方法
 */
fun addThree(a: Int, b: Int = 1, c: Int = 1): Int {
    return a + b + c
}

/**
 * 简单的直接输出值的方法
 */
fun single(a: Int, b: Int): Int = a + b

