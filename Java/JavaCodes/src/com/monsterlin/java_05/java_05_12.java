package com.monsterlin.java_05;

/**
 * 接口回调
 * Created by monsterLin on 6/24/2016.
 */
public class java_05_12 {

    public static void main(String args[]){
        ShowMessage sm ;
        sm= new TV();  //声明接口，实现接口的实现类，，进而调用内部的方法

        sm.showTradeMark();

        sm=new PC();
        sm.showTradeMark();
    }

}


interface ShowMessage{
    void showTradeMark();
}


class TV implements ShowMessage{

    @Override
    public void showTradeMark() {
        System.out.println("我是电视机");
    }
}

class PC implements ShowMessage{

    @Override
    public void showTradeMark() {
        System.out.println("我是电脑");
    }
}
