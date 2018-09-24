package com.monsterlin.java_10;

import javax.swing.*;
import java.awt.*;

/**
 * Created by monsterLin on 6/29/2016.
 */
public class java_10_03 {
    public static void main(String args[]){
            new WindowFlow("FLowLayout布局窗口");
    }
}

class WindowFlow extends JFrame{
    JButton b[] ;
    WindowFlow(String s){

        setTitle(s);
        b=new JButton[10];

        FlowLayout flow = new FlowLayout();
        flow.setAlignment(FlowLayout.LEFT);  //重新设置布局的对齐方式
        flow.setHgap(2); //设置布局的水平间隙
        flow.setVgap(8); //设置布局的垂直间隙
        setLayout(flow);

        for (int i =0;i<b.length;i++){
            b[i] = new JButton(""+i);

            add(b[i]);

            if (i==b.length-1){
                /**
                 * 添加到flowLayout的组件调用setSize(int x, int y )设置大小无效，如果需要改变大小，需要调用
                 * public void setPreferredSize(Dimension preferredSize)方法设置大小
                 */
                b[i].setPreferredSize(new Dimension(80,40));
            }

            validate(); //进行绘制
            setBounds(100,100,200,160); //设置起始位置
            setVisible(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //隐藏当前窗口，并释放窗体占有的其他资源
        }

    }





}
