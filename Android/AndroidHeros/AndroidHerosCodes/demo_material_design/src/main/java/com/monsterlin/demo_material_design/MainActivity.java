package com.monsterlin.demo_material_design;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.monsterlin.demo_material_design.themes.MDThemesActivity;

public class MainActivity extends BaseActivity  implements View.OnClickListener{

    private Toolbar mToolBar ;

    private Button mButtonMDThemes ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initToolBar(mToolBar,"Demo_Material_Design",false);
        initEvent();
    }

    private void initEvent() {
        mButtonMDThemes.setOnClickListener(this);
    }

    private void initView() {
        mButtonMDThemes = (Button) findViewById(R.id.main_btn_mdtheme);
        mToolBar= (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_btn_mdtheme:
                nextActivity(MDThemesActivity.class);
                break;
        }
    }
}
