package com.study.thinking_in_java;

/**
 * Created by monsterLin on 2017/1/15.
 */
public class Thinking_03_0304 {
    public static void main(String args[]) {
        Tank t1 = new Tank();
        Tank t2 = new Tank();

        t1.level = 9;
        t2.level = 47;

        System.out.println("1: t1.level：" + t1.level + "  ,  t2.level：" + t2.level);

        t1 = t2;

        System.out.println("2: t1.level：" + t1.level + "  ,  t2.level：" + t2.level);

        t1.level = 27;

        System.out.println("3: t1.level：" + t1.level + "  ,  t2.level：" + t2.level);

    }
}

class Tank {
    int level;

}

/**
 * 1: t1.level：9  ,  t2.level：47
 * 2: t1.level：47  ,  t2.level：47
 * 3: t1.level：27  ,  t2.level：27
 */
