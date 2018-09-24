package com.monsterlin.java_06;

/**
 * Created by monsterLin on 6/29/2016.
 */
public class Java_06_01 {

    public static void main(String args[]){
        char a[] ={'s','t','u','d','e','n','t'};

        /**
         * String (char a[], int startIndex,int count)
         * 提取字符数组a中的一部分字符创建一个字符串对象，参数startIndex 和 count 分别指定在a中提取字符的起始位置和从该位置开始截取的字符个数
         */
        String s = new String(a,2,3);
        System.out.println(s);

        //

        /**
         * 判断当前字符串对象是否含有参数指定的字符串
         */
        String tom = "we love android";
        boolean isTom = tom.contains("an");
        boolean isNTom = tom.contains("ok");

        System.out.println("isTom："+isTom+"\n"+"isNTom："+isNTom);

        //

        /**
         * public boolean startsWith(String s)  判断当前字符串对象的前缀是否是参数指定的字符串
         *
         * public boolean endsWith(String s)  判断当前字符串对象的后缀是否是参数指定的字符串
         */


        //


        /**
         * public int compareTo (String s)
         * 按字典与参数s指定的字符串比较大小
         * 如果当前字符串与s相同，该方法返回值为0；
         * 如果当前字符串对象大于s，该方法返回正值；
         * 如果当前字符串对象小雨s，该方法返回负值；
         *
         * 依次字符比较，比较：第一个与第二个进行比较，如果相同在向下进行
         * 第一个字符-第二个字符的差
         */

        String str = "abcde" ;
        System.out.println("boy："+str.compareTo("boy"));
        System.out.println("aba："+str.compareTo("aba"));
        System.out.println("abcde："+str.compareTo("abcde"));


        //

        /**
         * public int indexOf(String s)
         * 从当前字符串的头开始检索字符串s，并返回首次出现s的位置，如果没有检索到字符串s，则该方法返回值为-1
         * 检索顺序 ： 0/1/2/3/...
         */


        //

        /**
         * public String subString (int startPoint)
         *
         * 获得一个当前字符串的字串，该子串是从当前字符串的startPoint处截取到最后锁得到的字符串
         */


        //

        /**
         * public String subString (int start ,int end)
         *
         *
         * 获得一个当前字符串的子串，该子串是从当前start处截取到end处所得到的字符串，但不包括end处所对应的字符
         */


        //

        /**
         * public void trim();
         * 一个字符串通过调用trim()得到一个字符串对象，该字符串是去掉s前后空格的字符串
         *
         */
    }
}
