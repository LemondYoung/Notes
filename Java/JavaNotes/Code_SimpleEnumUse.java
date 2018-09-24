package com.monsterlin.java;

/**
 * Created by monsterlin on 17-3-6.
 */
public class SimpleEnumUse {
    public static void main(String [] args){
        Spiciness howHot = Spiciness.EDIUM;
        System.out.println(howHot);

        for (Spiciness s : Spiciness.values()){
            System.out.println(s+",ordinal "+ s.ordinal());
        }
    }
}

enum Spiciness{
    NOT,MILD,EDIUM,HOT,FLAMING
}

/**
 * Output:
 *
 * EDIUM
 * NOT,ordinal 0
 * MILD,ordinal 1
 * EDIUM,ordinal 2
 * HOT,ordinal 3
 * FLAMING,ordinal 4
 **/
