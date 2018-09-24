package com.monsterlin.practice

/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : 熊
 * @date : 2018/2/1
 */
class Bear: Animal(),BearFeature{

    override fun sing(name:String,music: String) {
        println("${name}正在唱${music}")
    }

    override fun eat(animal: String) {
        super.eat(animal)
    }

    override fun drink(animal: String) {
        super.drink(animal)
    }
}