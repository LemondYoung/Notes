/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : 嵌套类
 * @date : 2018/1/29
 */
class House {

    var water = 10L

    inner class Cat{
        fun drink(){
            water-=1
            println("猫喝了水 剩下的水是：${water}")
        }
    }

    inner class Dog{
        fun drink(){
            water-=3
            println("狗喝了水 剩下的水是：${water}")
        }
    }
}