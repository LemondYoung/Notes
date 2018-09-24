package com.monsterlin.java;

/**
 * StaticInitialization
 * Created by monsterlin on 17-3-3.
 */
public class StaticInitialization {
    public static void main(String[] args) {
        //在Alibaba编程规范中：【强制】中括号是数组类型的一部分,数组定义如下: String[] args;

        ToolsPrint.print("create new cupboard() in main");
        new Cupboard();

        ToolsPrint.print("create new cupboard() in main");
        new Cupboard();

        table.f2(1);
        cupboard.f3(1);
    }

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}

class Bowl {
    Bowl(int marker) {
        ToolsPrint.print("Bowl(" + marker + ")");
    }

    void f1(int marker) {
        ToolsPrint.print("f1(" + marker + ")");
    }
}

class Table {
    static Bowl bowl = new Bowl(1);

    public Table() {
        ToolsPrint.print("Table()");

        bowl2.f1(1);
    }

    void f2(int marker) {
        ToolsPrint.print("f2(" + marker + ")");
    }

    static Bowl bowl2 = new Bowl(2);
}


class Cupboard {
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    public Cupboard() {
        ToolsPrint.print("Cupboard()");

        bowl4.f1(2);
    }

    void f3(int marker) {
        ToolsPrint.print("f3(" + marker + ")");
    }


    static Bowl bowl5 = new Bowl(5);
}

/**
 * Output :
 * 经
 * 思想：在方法的调用上： 静态static方法 > 非static静态方法 > constructor够构造方法静态镜头经
 *
 * Bowl(1)
 * Bowl(2)
 * Table()
 * f1(1)
 * Bowl(4)
 * Bowl(5)
 * Bowl(3)
 * Cupboard()
 * f1(2)
 * create new cupboard() in main
 * Bowl(3)
 * Cupboard()
 * f1(2)
 * create new cupboard() in main
 * Bowl(3)
 * Cupboard()
 * f1(2)
 * f2(1)
 * f3(1)
 */
