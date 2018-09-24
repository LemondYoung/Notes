package com.monsterlin.java;

/**
 * Created by monsterlin on 17-3-6.
 */
public class NewVarArgs {
    public static void main(String[] args){
        printArray(new Integer(47),new Float(3.14),new Double(11.11));
        printArray(47,3.14F,11.11);
        printArray("one","two","three");
        printArray(new A(),new A(),new A());

        printArray(new Integer[]{1,2,3,4});
        printArray();
    }


    static void printArray(Object... args){
        for (Object obj: args){
            System.out.print(obj+"  ");
        }
        System.out.println();

    }


}
class A{

}

/**
 * Output :
 * 47  3.14  11.11
 * 47  3.14  11.11
 * one  two  three
 * com.monsterlin.java.A@1540e19d  com.monsterlin.java.A@677327b6  com.monsterlin.java.A@14ae5a5
 * 1  2  3  4
 **/
