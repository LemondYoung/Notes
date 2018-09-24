package com.monsterlin.java_08;

/**
 * Created by monsterLin on 7/4/2016.
 */
public class Java_08_01 {
    public static void main(String args[]) {
        WriteWordThread zhang, wang;
        zhang = new WriteWordThread("zhang");  //新建线程
        wang = new WriteWordThread("wang"); //新建线程

        zhang.start();  //张启动线程

        for (int i = 1; i <= 8; i++) {
            System.out.println("我是主线程中的语句");
        }
        wang.start();  //王启动线程

    }

}

class WriteWordThread extends Thread {  //Thread子类负责创建线程对象
    WriteWordThread(String s) {
        setName(s);  //调用Thread类的setName方法为线程起名字
    }

    public void run() {
        for (int i = 1; i <= 8; i++) {
            System.out.println("我是一个线程，我的名字是：" + getName());
        }
    }
}