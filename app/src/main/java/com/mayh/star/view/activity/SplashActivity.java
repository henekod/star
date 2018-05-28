package com.mayh.star.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mayh.star.App;
import com.mayh.star.R;
import com.mayh.star.base.BaseActivity;
import com.mayh.star.global.AppConstants;

/**
 * =========================================
 *
 * author: Ma Yuhua
 * date: 2018/5/28
 * desc: 启动页
 *
 * =========================================
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 如果不是第一次启动，则正常显示启动屏
        setContentView(R.layout.activity_splash_layout);

        // 根据Key获取SharedPreferences文件相应boolean值
        final boolean isFirstOpen = App.getSharedPreference().getBoolean(AppConstants.FIRST_OPEN, false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isFirstOpen) {// 如果是第一次启动，则先进入功能引导页
                    Intent intent = new Intent(SplashActivity.this, WelcomeGuideActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        }, 1000);

        // 两秒后关闭启动屏，进入主页
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}
