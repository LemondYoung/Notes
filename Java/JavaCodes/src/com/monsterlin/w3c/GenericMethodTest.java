package com.monsterlin.w3c;

/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : 泛型相关
 * @date : 2018/3/5
 */
public class GenericMethodTest {

    /**
     * 泛型方法
     * @param inputType
     * @param <E>
     */

    //所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前（在下面例子中的<E>）
    //每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。
    //类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。
    //泛型方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像int,double,char的等）。
    public static <E> void printArray(E[] inputType){
        //输出元素数据
        for (E element : inputType){
            System.out.printf("%s", element );
        }
        System.out.println();
    }

    public static void main(String[] args){
        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {1.1,2.2,3.3,4.4,5.5};
        Character[] charArray = {'a','b','c','d','e'};

        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);
    }
}
