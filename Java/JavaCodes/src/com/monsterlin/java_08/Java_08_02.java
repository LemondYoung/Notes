package com.monsterlin.java_08;

/**
 * Created by monsterLin on 7/5/2016.
 */
public class Java_08_02 {
    public static void main(String args[]){
        WriteThread zhang , wang ;
        zhang=new WriteThread("张小红",200);
        wang=new WriteThread("JamsKeven",100);
        zhang.start();
        wang.start();

    }
}

class WriteThread extends Thread{
    int n ;
    WriteThread(String s , int n){
        setName(s);
        this.n=n;
    }

    public void run(){
        for (int i =1;i<8;i++){
            System.out.println("我是一个线程，我的名字是："+getName());
            try {
                sleep(n);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
