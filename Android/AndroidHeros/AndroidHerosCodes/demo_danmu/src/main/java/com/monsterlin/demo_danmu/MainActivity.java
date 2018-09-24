package com.monsterlin.demo_danmu;

import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.VideoView;

import java.util.Random;

import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.ui.widget.DanmakuView;

public class MainActivity extends AppCompatActivity {

    private VideoView mVideoView;
    private DanmakuView danmakuView; //弹幕的view
    private DanmakuContext danmakuContext;  //弹幕的上下文
    private boolean showDanmaku; //是否显示弹幕
    private LinearLayout operationLayout ;
    private Button send ;
    private EditText editText ;

    //弹幕解析器
    private BaseDanmakuParser parser = new BaseDanmakuParser() {
        @Override
        protected IDanmakus parse() {
            return new Danmakus();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        /**
         * 对VideoView的基本配置
         */
        mVideoView.setVideoPath(Environment.getExternalStorageDirectory() + "/zuiyou/hangdali.mp4");
        mVideoView.start();


        danmakuView.enableDanmakuDrawingCache(true); //启用弹幕库缓存

        /**
         * 弹幕的回调事件
         */
        danmakuView.setCallback(new DrawHandler.Callback() {
            @Override
            public void prepared() {
                //准备弹幕
                showDanmaku = true;
                danmakuView.start();
                generateSomeDanmaku();
            }

            @Override
            public void updateTimer(DanmakuTimer timer) {

            }

            @Override
            public void danmakuShown(BaseDanmaku danmaku) {

            }

            @Override
            public void drawingFinished() {

            }
        });

        danmakuContext = DanmakuContext.create();
        danmakuView.prepare(parser, danmakuContext);


        danmakuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operationLayout.getVisibility()==View.GONE){
                    operationLayout.setVisibility(View.VISIBLE);
                }else {
                    operationLayout.setVisibility(View.GONE);
                }
            }
        });


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editText.getText().toString();
                if (!TextUtils.isEmpty(content)){
                    addDanmaku(content,true);
                    editText.setText("");
                }
            }
        });


        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility==View.SYSTEM_UI_FLAG_VISIBLE){
                    onWindowFocusChanged(true);
                }
            }
        });
    }

    private void initView() {
        mVideoView = (VideoView) findViewById(R.id.video_view);
        danmakuView = (DanmakuView) findViewById(R.id.danmaku_view);
        operationLayout= (LinearLayout) findViewById(R.id.operation_layout);
        send= (Button) findViewById(R.id.send);
        editText= (EditText) findViewById(R.id.edit_text);
    }

    /**
     * 随机生成一些弹幕以供测试
     */
    private void generateSomeDanmaku() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (showDanmaku) {
                    int time = new Random().nextInt(300);
                    String content = "" + time + time;
                    addDanmaku(content, false);
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    /**
     * 向弹幕View中添加一条弹幕
     *
     * @param content     弹幕的内容
     * @param widthBorder 弹幕是否有边框,主要用于区分是否为自己发送的弹幕
     */
    private void addDanmaku(String content, boolean widthBorder) {

        //对弹幕进行基本的配置
        BaseDanmaku danmaku = danmakuContext.mDanmakuFactory
                .createDanmaku(BaseDanmaku.TYPE_SCROLL_RL);
        danmaku.text = content;
        danmaku.padding = 5;
        danmaku.textSize = sp2x(20);
        danmaku.textColor = Color.WHITE;
        danmaku.setTime(danmakuView.getCurrentTime());
        if (widthBorder) {
            danmaku.borderColor = Color.GREEN;
        }

        danmakuView.addDanmaku(danmaku);

    }

    private int sp2x(int spValue) {
        float fontScale = getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus&& Build.VERSION.SDK_INT>=19){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    |View.SYSTEM_UI_FLAG_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
        }
    }


    /**
     * 对弹幕的生命周期进行管理
     */
    @Override
    protected void onPause() {
        super.onPause();
        if (danmakuView != null && danmakuView.isPrepared()) {
            danmakuView.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (danmakuView != null && danmakuView.isPrepared() && danmakuView.isPaused()) {
            danmakuView.resume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showDanmaku = false;
        if (danmakuView != null) {
            danmakuView.release();
            danmakuView = null;
        }

    }
}
