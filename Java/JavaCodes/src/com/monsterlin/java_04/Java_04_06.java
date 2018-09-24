package com.monsterlin.java_04;

/**
 * Created by monsterLin on 2016/6/17.
 */
public class Java_04_06 {
    public static void main(String args[]){
        Lader.bottom=40;  //Lader的字节码被加载到内存，通过类名操作类变量
        Lader laderOne , laderTwo ;
        System.out.println("现在所有的Lader对象的bottom都是"+Lader.bottom);

        laderOne = new Lader();
        laderTwo= new Lader();

        System.out.println("laderOne的bottom："+laderOne.getBottom());
        System.out.println("laderTwo的bottom："+laderTwo.getBottom());

        laderOne.setAbove(11);
        laderTwo.setAbove(11);
        laderTwo.setBottom(100);

        System.out.println("现在所有Lader对象的bottom都是"+Lader.bottom);

        System.out.println("laderOne的above："+laderOne.getAbove());
        System.out.println("laderTwo的above："+laderTwo.getAbove());

    }
}

class Lader{
    double above  ;
    static double bottom ;

     double getAbove() {
        return above;
    }

     void setAbove(double above) {
        this.above = above;
    }

    double getBottom() {
        return bottom;
    }

     void setBottom(double bottom) {
        Lader.bottom = bottom;
    }
}
