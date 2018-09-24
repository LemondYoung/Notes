/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : 类的扩展
 * @date : 2018/1/30
 */


/**
 * string的扩展方法
 */
fun String.addTag(): String {
    return this + "monsterlin"
}

/**
 * 判断是否为空
 */
fun String?.isEmpty(): Boolean {
    if (this == null) return true
    return this == ""
}

/**
 * 合并一句话-> 只能有一个参数，让表单更加的简洁
 */
infix fun String.em(content: String): String {
    return this + content
}


/**
 * 定义一个返回第一个字母的方法
 */
val String.firstLatter: Char
    get() = this[0]