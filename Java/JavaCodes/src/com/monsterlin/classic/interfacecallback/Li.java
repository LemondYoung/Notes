package com.monsterlin.classic.interfacecallback;

/**
 * Created by monsterLin on 2016/10/14.
 */
public class Li {

    /**
     * 小王帮忙解答问题
     *
     * @param callBack 询问问题的回复
     * @param message  所要问的问题
     */
    public void executeMessage(CallBack callBack, String message) {

        System.out.println("小王问的问题：" + message);

        //模拟小李做自己事情的时间
        for (int i = 0; i < 1000; i++) {

        }

        String result = "答案是2";

        callBack.solve(result);

    }
}
