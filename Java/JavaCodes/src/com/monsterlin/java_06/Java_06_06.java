package com.monsterlin.java_06;

/**
 * Created by monsterLin on 6/30/2016.
 */
public class Java_06_06 {

    public static void main(String args[]){

        StringBuffer str = new StringBuffer("0123456789");

        str.setCharAt(0,'a'); //将第0个位置的字符替换为a
        str.setCharAt(1,'b');
        System.out.println(str);

        str.insert(2,"**");
        System.out.println(str);

        str.delete(6,8);
        System.out.println(str);
    }

}
