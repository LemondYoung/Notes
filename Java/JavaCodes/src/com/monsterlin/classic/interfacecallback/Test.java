package com.monsterlin.classic.interfacecallback;

/**
 * 一天小王遇到一个很难的问题
 * Created by monsterLin on 2016/10/14.
 */
public class Test {

    public static void main(String args[]) {

        Li li = new Li();

        Wang wang = new Wang(li);


        /**
         * 小王问小李问题
         */
        wang.askQuestion("1+1=?");
    }

}
