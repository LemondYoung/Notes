/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : 接口实现
 * @date : 2018/1/30
 */
class People : Hello,Hey{
    override fun sayHello() {
        super<Hello>.sayHello()
    }
}