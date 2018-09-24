/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : 类的介绍
 * @date : 2018/1/29
 */
class Dog(val name: String): Animal() {
    override fun voice() {
        println("wang wang")
    }

    //项目被new的时候或者被初始化的时候执行，在这里可以执行一些操作
    init {
        println("Dog is init")
    }

    //当函数有多个构造函数的时候，可以通过这样的方式，this(name)把头部的name传过来
    constructor(name: String,age:Int):this(name){
        println("constructor is execute")
    }

    override fun eat() {
        super.eat()
        println("$name Dog Eat")
    }
}