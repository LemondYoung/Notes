package com.monsterlin.demo_material_design.themes;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.monsterlin.demo_material_design.BaseActivity;
import com.monsterlin.demo_material_design.R;

/**
 * Created by  monsterLin on 2016/10/30.
 */

public class MDThemesActivity extends BaseActivity {

    private Toolbar mToolBar ;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);
        mToolBar= (Toolbar) findViewById(R.id.toolbar);
        initToolBar(mToolBar,"MDThemes",true);


    }
}
