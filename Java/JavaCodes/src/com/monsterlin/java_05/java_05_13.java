package com.monsterlin.java_05;

/**
 * 接口作为参数
 * Created by monsterLin on 6/24/2016.
 */
public class java_05_13 {
    public static void main(String args[]){
        CC c = new CC();
        c.f(new AA());
        c.f(new BB());
    }
}

interface Show{
    void show();
}


class AA implements Show{

    @Override
    public void show() {
        System.out.println("I Love This Game");
    }
}

class BB implements Show {

    @Override
    public void show() {
        System.out.println("我喜欢看NBA");
    }
}

class CC {
    /**
     * 接口作为变量
     * @param s
     */
    public void f(Show s){
        s.show();
    }
}