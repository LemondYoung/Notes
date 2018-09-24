package com.monsterlin.w3c;

/**
 * @author : monsterlin
 * @blog :  https://monsterlin.com
 * @github : https://github.com/monsterlin
 * @desc :  泛型的继承
 * @date : 2018/3/5
 */
public class MaximumTest {
    //比较三个值，并返回最大的
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {

        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    public static void main(String args[]) {
        System.out.printf("%d, %d 和 %d 中最大的数为 %d\n\n",
                3, 4, 5, maximum(3, 4, 5));

        System.out.printf("%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",
                6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));

        System.out.printf("%s, %s 和 %s 中最大的数为 %s\n", "pear",
                "apple", "orange", maximum("pear", "apple", "orange"));
    }
}
