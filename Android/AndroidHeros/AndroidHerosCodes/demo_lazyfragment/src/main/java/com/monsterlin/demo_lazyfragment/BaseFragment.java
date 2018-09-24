package com.monsterlin.demo_lazyfragment;

import android.support.v4.app.Fragment;

/**
 * Created by  monsterLin on 2016/11/3.
 */

public abstract class BaseFragment  extends Fragment{

    protected  boolean isVisible ;  //Fragment当前状态是否可见

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        /**
         * 设置当前的fragment是否可见
         *
         * 如果可见，则visible设置为true
         * 如果不可见，则visible设置为false
         *
         */
        if (getUserVisibleHint()){
            isVisible=true;
            onVisible();
        }else {
            isVisible=false;
            onInVisible();
        }

    }

    /**
     * 不可见
     */
    protected void onInVisible() {

    }

    /**
     * 可见
     */
    protected void onVisible() {
        lazyLoad();
    }

    /**
     * 延迟加载
     * 子类必须重写此方法
     */
    protected abstract void lazyLoad();

}
