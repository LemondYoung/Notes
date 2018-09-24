package com.monsterlin.java_05;

/**
 * 内部类
 * Created by monsterLin on 6/27/2016.
 */
public class Java_05_15 {

    public static void main(String args[]){

        China china = new China();
        china.f();
        china.dalian.g();

    }

}


class NorthEast{
    String land = "黑土地" ;
}


class China {
    int x = 10 , y = 10;
    LiaoNing dalian ;

    China(){
        dalian=new LiaoNing();
    }


    void f (){
        System.out.println("我是中国");

        dalian.speak();

    }

    class LiaoNing extends NorthEast{
        int z ;
        void  speak(){
            System.out.println("我是大连,z="+z+":"+land);
        }

        void g(){
            z=x+y;
            f();
        }

    }
}

