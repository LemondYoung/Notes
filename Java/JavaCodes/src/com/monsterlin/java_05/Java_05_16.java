package com.monsterlin.java_05;

/**
 * 匿名类 与类有关的匿名类
 *
 * Created by monsterLin on 6/27/2016.
 */
public class Java_05_16 {
    public static void main(String args[]){

        Teacher zhang = new Teacher();
        zhang.look(new Student() {  //匿名类的类体，既Student的子类的雷替
            @Override
            void speak() {
                System.out.println("这是匿名类中的方法");
            }
        });
    }
}

abstract class Student{
    abstract void speak ();
}

class Teacher{
    void look(Student stu){
        stu.speak();  //执行匿名类体中重写的speak方法
    }
}
