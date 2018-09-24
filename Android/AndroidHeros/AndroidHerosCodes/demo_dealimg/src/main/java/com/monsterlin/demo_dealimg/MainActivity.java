package com.monsterlin.demo_dealimg;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private ImageView iv_showImg;

    /**
     * Hue ：色调
     * Saturation : 饱和度
     * Lun : 亮度
     */

    private SeekBar sb_hue, sb_saturation, sb_lum;

    private float mHue;
    private float mSaturation;
    private float mLum;

    private Bitmap bm;

    private static final int MID_VALUE = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        bm = ((BitmapDrawable) iv_showImg.getDrawable()).getBitmap();

        initEvent();

    }

    private void initEvent() {
        sb_hue.setOnSeekBarChangeListener(this);
        sb_saturation.setOnSeekBarChangeListener(this);
        sb_lum.setOnSeekBarChangeListener(this);
    }

    private void initView() {
        iv_showImg = (ImageView) findViewById(R.id.iv_showImg);
        sb_hue = (SeekBar) findViewById(R.id.sb_hue);
        sb_saturation = (SeekBar) findViewById(R.id.sb_saturation);
        sb_lum = (SeekBar) findViewById(R.id.sb_lum);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.sb_hue:
                mHue = (progress - MID_VALUE) * 1.0F / MID_VALUE * 180;
                break;
            case R.id.sb_saturation:
                mSaturation = progress * 1.0F / MID_VALUE;
                break;
            case R.id.sb_lum:
                mLum = progress * 1.0F / MID_VALUE;
                break;
        }

        iv_showImg.setImageBitmap(ImageHelper.HandleImageEffect(bm, mHue, mSaturation, mLum));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
