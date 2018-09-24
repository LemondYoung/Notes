/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : 类的介绍
 * @date : 2018/1/29
 */
fun main(args: Array<String>) {
    val dog = Dog("candy", 2)
    dog.eat()

    val person = Person("monsterlin", 24)

    //复制
    val lisa = person.copy("Lisa")
    println(person.name)
    println("name is ${lisa.name} age is ${lisa.age}")

    val big_house = House()
    big_house.Cat().drink()
    big_house.Dog().drink()

    color_checker(Color.RED)

    val people = People()
    people.sayHello()

    println("你好".addTag())
    println("".isEmpty())
    println("abc".isEmpty())

    println("apple" em ("pen"))

    println("Fover".firstLatter)

    println(sum(1,2))

    /**
     * 高阶函数的应用
     */
    cook("青椒",{
        name,time->
        println("把${name}切碎")
        println("下油，等锅热了")
        println("把${name}放进去，翻炒")
        println("加盐")

        //最后一句为返回值
        println("翻炒${time}分钟后")
        true
    })
}

/**
 * lambda表达式
 */
val sum={x:Int,y:Int->x+y}

fun color_checker(color: Color) {
    when (color) {
        Color.RED -> println("is red")
        Color.GREEN -> println("is green")
        Color.BLUE -> println("is blue")
    }
}

/**
 * => 高阶函数
 * unit相当于null 等同于没有返回值的意思
 * 下面的println例子就好比数据库的操作，数据库的连接和断开
 */
fun cook(name:String,action:(String,Int)->Boolean){
    println("准备食物")
    println("清洗食物")
    action(name,3)
    println("出锅")
    println("装盘")
}