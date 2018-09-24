/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : java kotlin相互调用
 * @date : 2018/2/1
 */
class KUtils{

    //kotlin常规方法
    fun kotlin_normal_fun(){
        println("我是Kotlin的常规方法")
    }

    //kotlin定义静态方法

    companion object {
        fun kotlin_static_fun(str: String){
            println("我是Kotlin的静态方法，你好${str}")
        }
    }
}
   