package com.monsterlin.java;

/**
 * DynamicArray
 * Created by monsterlin on 17-3-6.
 */
public class DynamicArray {
    public static void main(String[] args){
        Other.main(new String[]{"monsterlin","monsterlin","monsterlin"});
    }
}

class Other{
    public static void main(String[] args){
        for (String s : args){
            ToolsPrint.print(s+"");
        }
    }
}
/**
 * Output:
 * monsterlin
 * monsterlin
 * monsterlin
 */
