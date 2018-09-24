package com.monsterlin.classic.interfacecallback;

/**
 * Created by monsterLin on 2016/10/14.
 */
public class Wang implements CallBack {

    private Li li;

    public Wang(Li li) {
        this.li = li;
    }

    /**
     * 小王询问问题
     *
     * @param question
     */
    public void askQuestion(String question) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                li.executeMessage(Wang.this, question);
            }
        }).start();

        play();
    }

    private void play() {
        System.out.println("我要逛街去了");
    }


    @Override
    public void solve(String result) {
        System.out.println("小李告诉小王的答案是：" + result);
    }
}
