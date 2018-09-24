/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : java kotlin相互调用
 * @date : 2018/2/1
 */
fun main(args: Array<String>) {

    //kotlin调用java的方法
    val utils = JUtils()
    utils.java_normal_fun("Kotlin")

    //kotlin直接调用静态方法
    JUtils.java_static_fun()

}
   