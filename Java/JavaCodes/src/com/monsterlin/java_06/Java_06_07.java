package com.monsterlin.java_06;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * StringTokenizer
 * Created by monsterLin on 6/30/2016.
 */
public class Java_06_07 {
    public static void main(String args[]){
        String []mess = {"整数部分","小数部分"};
        Scanner reader = new Scanner(System.in);

        double x = reader.nextDouble();
        String s = String.valueOf(x);

        StringTokenizer fenxi = new StringTokenizer(s,".");

        for (int i =0;fenxi.hasMoreTokens();i++){
            String str = fenxi.nextToken();
            System.out.println(mess[i]+":"+str);
        }


    }
}
