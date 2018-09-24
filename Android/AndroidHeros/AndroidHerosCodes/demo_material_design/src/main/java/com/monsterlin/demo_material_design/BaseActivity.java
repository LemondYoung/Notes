package com.monsterlin.demo_material_design;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

/**
 * Created by  monsterLin on 2016/10/30.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    /**
     * 显示Toast
     * @param msg
     */
    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT);
    }

    /**
     * 跳到另一个页面
     * @param cls
     */
    public void nextActivity(Class cls) {
        nextActivity(cls, null);
    }

    /**
     * 带数据包的跳转
     * @param cls
     * @param bundle
     */
    public void nextActivity(Class cls, Bundle bundle) {
        Intent i = new Intent(this, cls);
        if (bundle != null)
            i.putExtras(bundle);
        startActivity(i);
    }

    public void initToolBar(Toolbar toolbar , String title, boolean isBack){
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        if (isBack){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }
}
