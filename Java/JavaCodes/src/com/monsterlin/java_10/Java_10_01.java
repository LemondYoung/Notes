package com.monsterlin.java_10;

import javax.swing.*;

/**
 * Created by monsterLin on 2016/6/17.
 */
public class Java_10_01 {
    public static void main(String args[]){
        JFrame frame1 = new JFrame("第一个窗口");
        JFrame frame2 = new JFrame("第二个窗口");

        //设置窗口在屏幕的位置

        /**
         * Frame距离屏幕左面a个像素,距离屏幕上方b个像素
         * 窗口的宽是width , 高是height
         */

        frame1.setBounds(60,100,188,108);
        frame2.setBounds(260,100,188,108);

        frame1.setVisible(true);
        frame2.setVisible(true);

        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  //释放当前窗口
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //退出程序

        frame1.setResizable(false);  //设置是否可调整大小
        frame2.setResizable(true);
    }
}
