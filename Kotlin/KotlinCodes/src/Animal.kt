/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : 类的介绍
 * @date : 2018/1/29
 */
abstract class Animal {
    open fun eat(){
        println("Animal Eat")
    }

    open fun jump(){
        println("Animal Jump")
    }

    abstract fun voice()
}