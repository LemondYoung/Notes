package com.monsterlin.java;

/**
 * OrderOfInitialization
 * Created by monsterlin on 17-3-5.
 */
public class OrderOfInitialization {

    public static void main(String[] args) {
        House house = new House();
        house.f();
    }
}


class Window {
    Window(int marker) {
        ToolsPrint.print("Window(" + marker + ")");
    }
}

class House {

    //在类的内部，变量的先后顺序决定了初始化的顺序；
    //即使变量散布在方法定义之间。它们仍旧会在任何方法(包括构造器)被调用前得到初始化
    Window w1 = new Window(1);  //before constructor

    House() {
        ToolsPrint.print("House()");
        w3 = new Window(33);  //reInitialize w3
    }

    Window w2 = new Window(2); //after constructor

    void f() {
        ToolsPrint.print("f()");
    }

    Window w3 = new Window(3); //at end
}

/**
 * Output :
 *
 * Window(1)
 * Window(2)
 * Window(3)
 * House()
 * Window(33)
 * f()
 */
