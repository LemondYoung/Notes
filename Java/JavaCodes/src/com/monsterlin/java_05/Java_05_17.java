package com.monsterlin.java_05;

/**
 * 与接口有关的匿名类的用法
 * Created by monsterLin on 6/27/2016.
 */
public class Java_05_17 {
    public static void main(String args[]){
        A1 a1 = new A1();
        a1.f(new Chow() {
            @Override
            public void chow() {
                System.out.println("这是实现接口的匿名类");
            }
        });
    }
}

interface Chow{
    public void chow();
}

class A1{
    void f(Chow c){
        c.chow();  //c调用匿名类体中实现的接口方法(接口回调)
    }
}
