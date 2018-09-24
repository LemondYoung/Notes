/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : java kotlin相互调用
 * @date : 2018/2/1
 */
public class JavaCall {
    public static void main(String[] args) {

        //java调用kotlin普通方法
        KUtils kUtils = new KUtils();
        kUtils.kotlin_normal_fun();


        //java调用kotlin的静态方法
        KUtils.Companion.kotlin_static_fun("java");
    }
}
