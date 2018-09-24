package com.monsterlin.w3c;

/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc : 泛型类
 * @date : 2018/3/5
 */
public class Box<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }


    public static void main(String [] args){
        Box<Integer> integerBox = new Box<>();
        Box<String> stringBox = new Box<>();
        integerBox.add(new Integer(10));
        stringBox.add(new String("菜鸟教程"));

        System.out.println(integerBox.get()+"\n"+stringBox.get());
    }
}
