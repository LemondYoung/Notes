/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : java kotlin相互调用
 * @date : 2018/2/1
 */
public class JUtils {

    public static void java_static_fun(){
        System.out.println("我是java的静态方法");
    }

    public void java_normal_fun(String message){
        System.out.println("我是java的常规方法，你好："+message);
    }
}
