package com.monsterlin.classic.interfacecallback;

/**
 * 这是一个接口回调的接口
 * <p>
 * 这个callBack为我们自定义的callBack ,非系统的callBack
 * Created by monsterLin on 2016/10/14.
 */
public interface CallBack {

    /**
     * 表示小李知道答案后，将答案告诉小王，这个函数被称为回调函数
     *
     * @param result 答案
     */


    public void solve(String result);
}
