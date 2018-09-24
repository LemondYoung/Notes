package com.monsterlin.practice

/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : 动物类
 * @date : 2018/2/1
 */
open class Animal {
    open fun eat(animal:String){
        println("${animal}正在吃饭")
    }

    open fun drink(animal: String){
        println("${animal}正在喝水")
    }
}