package com.monsterlin.java_05;

/**
 * Created by monsterLin on 6/24/2016.
 */


public class Java_05_11 {

    public static void main(String args[]){
        A a = new A();
        B b = new B();
        System.out.println(a.MAX);
        System.out.println(""+a.f(10)+""+a.g(12,6));
        System.out.println(b.MAX);
        System.out.println(""+b.f(10)+""+b.g(29,2));
    }
}


interface Computable{
    final int MAX = 100;
    int f(int x);
    public abstract int g(int x ,int y);
}


class A implements Computable{

    @Override
    public int f(int x) {
        return x*x;
    }

    @Override
    public int g(int x, int y) {
        return x+y;
    }
}


class B implements Computable{

    @Override
    public int f(int x) {
        return x*x*x;
    }

    @Override
    public int g(int x, int y) {
        return x*y;
    }
}