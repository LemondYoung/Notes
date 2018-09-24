package com.monsterlin.demo_lazyfragment.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.monsterlin.demo_lazyfragment.R;


/**
 * Created by  monsterLin on 2016/11/3.
 */

public class LoadingDialog {

    private AlertDialog alertDialog;
    private Context mContext;

    public LoadingDialog(Context context) {
        this.mContext = context;
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_alert, null);
        alertDialog = new AlertDialog.Builder(context)
                .setView(view)
                .create();
        alertDialog.setCancelable(false); //这句代码设置这个对话框不能被用户按[返回键]而取消掉
    }

    public void showDialog() {
        alertDialog.show();
    }


    public void dismissDialog() {
        alertDialog.dismiss();
    }
}
