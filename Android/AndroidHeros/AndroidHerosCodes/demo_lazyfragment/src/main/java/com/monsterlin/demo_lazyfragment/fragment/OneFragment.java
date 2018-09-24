package com.monsterlin.demo_lazyfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.monsterlin.demo_lazyfragment.BaseFragment;
import com.monsterlin.demo_lazyfragment.R;
import com.monsterlin.demo_lazyfragment.widget.LoadingDialog;

/**
 * Created by  monsterLin on 2016/11/3.
 */

public class OneFragment extends BaseFragment {


    private boolean isPrepared ; //标志位，标识已经初始化完成
    private boolean mHasLoadedOnce ;  //是否已经被加载过

    LoadingDialog dialog ;

    private TextView textView ;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        dialog = new LoadingDialog(getActivity());
        textView= (TextView) view.findViewById(R.id.textview);

        isPrepared=true;

        lazyLoad();
        return view;
    }


    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible || mHasLoadedOnce) {
            return;
        }

        //进行数据的延迟加载

        try {

            dialog.showDialog();

            Thread.sleep(1000);

            textView.setText("oneFragment已被加载");

            dialog.dismissDialog();
            mHasLoadedOnce=true;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
