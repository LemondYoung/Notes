package com.monsterlin.java_10;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by monsterLin on 6/20/2016.
 */
public class java_10_02 {

    public static void main(String args[]){
        FirstWindow win = new FirstWindow("一个简单的窗口");
    }

}

class FirstWindow extends JFrame{

    JMenuBar menuBar;  //菜单条
    JMenu menu; //菜单
    JMenuItem item1 , item2 ;//菜单项

    /**
     * 构造方法，创建对象的时候需要传入窗口的标题
     * @param s
     */
    FirstWindow(String s){

        /**
         * 设置窗口的全局实行
         */
        setTitle(s);
        setSize(160,170);
        setLocation(120,120);
        setVisible(true);


        /**
         * 逻辑:
         * 菜单条(JMenubar)-->菜单(JMenu)--->菜单项(JMenuItem)
         *
         */
        menuBar= new JMenuBar();

        menu=new JMenu("文件");

        item1=new JMenuItem("打开");
        item2=new JMenuItem("保存");

        /**
         * 设置快捷键
         */
        item1.setAccelerator(KeyStroke.getKeyStroke('O'));
        item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

        menu.add(item1);
        menu.add(item2);
        menu.addSeparator();
        menuBar.add(menu);
        setJMenuBar(menuBar);


        /**
         * 进行绘制
         */
        validate();

        /**
         * 设置默认的关闭方式
         */
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


}


