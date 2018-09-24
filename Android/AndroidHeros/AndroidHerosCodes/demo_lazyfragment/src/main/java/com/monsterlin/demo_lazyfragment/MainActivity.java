package com.monsterlin.demo_lazyfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.monsterlin.demo_lazyfragment.adapter.ViewPagerAdapter;
import com.monsterlin.demo_lazyfragment.fragment.OneFragment;
import com.monsterlin.demo_lazyfragment.fragment.ThreeFragment;
import com.monsterlin.demo_lazyfragment.fragment.TwoFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabGuide ;
    private ViewPager mVpGuide ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initVPContent();
    }

    private void initVPContent() {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Fragment oneFragment = new OneFragment();
        Fragment twoFragment = new TwoFragment();
        Fragment threeFragment = new ThreeFragment();


        adapter.addFragment(oneFragment,"第一页");
        adapter.addFragment(twoFragment,"第二页");
        adapter.addFragment(threeFragment,"第三页");

        mVpGuide.setAdapter(adapter);
        mVpGuide.setOffscreenPageLimit(2);
        mTabGuide.setupWithViewPager(mVpGuide);


    }

    private void initView() {
        mTabGuide= (TabLayout) findViewById(R.id.main_tl_guide);
        mVpGuide= (ViewPager) findViewById(R.id.main_vp_guide);

    }
}
