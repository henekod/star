package com.mayh.star.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mayh.star.R;
import com.mayh.star.base.BaseActivity;
import com.mayh.star.global.AppConstants;

/**
 * Created by mayanhua on 2018/5/16.
 *
 * 启动页
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 根据Key获取SharedPreferences文件相应boolean值
        boolean isFirstOpen = App.getSharedPreference().getBoolean(AppConstants.FIRST_OPEN, false);
        if (!isFirstOpen){// 如果是第一次启动，则先进入功能引导页
            Intent intent = new Intent(this, WelcomeGuideActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        // 如果不是第一次启动，则正常显示启动屏
        setContentView(R.layout.activity_splash_layout);

        // 两秒后关闭启动屏，进入主页
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
