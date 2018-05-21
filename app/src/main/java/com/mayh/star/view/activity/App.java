package com.mayh.star.view.activity;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by mayanhua on 2018/5/19.
 */

public class App extends Application {
    // SharedPreference 文件名
    private static final String SPFileName = "app_star";

    // 创建一个SharedPreference对象
    private static SharedPreferences mSharedPreference;

    // 创建一个SharedPreference.Editor对象
    private static SharedPreferences.Editor mEditor;

    @Override
    public void onCreate() {
        super.onCreate();
        mSharedPreference = getSharedPreferences(SPFileName, Context.MODE_PRIVATE);
    }

    /**
     * 获取SharedPreferences对象
     *
     * @return
     */
    public static SharedPreferences getSharedPreference() {
        return mSharedPreference;
    }

    /**
     * 获取SharedPreferences.Editor对象
     * @return
     */
    public static SharedPreferences.Editor getEditor() {
        return mSharedPreference.edit();
    }
}
