package com.mayh.star.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

/**
 * =========================================
 *
 * author: Ma Yuhua
 * date: 2018/5/28
 * desc: 设备操作工具类
 *
 * =========================================
 */
public class DeviceUtil {

    /**
     * 获取屏幕宽度
     * @param context 上下文
     * @return
     */
    public static int getScreenWidth(Context context){
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     * @param context 上下文
     * @return
     */
    public static int getScreenHeight(Context context){
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }


    /**
     * dp 转 px
     *
     * @param context 上下文
     * @param dpValue dp值
     * @return
     */
    public static int dp2px(Context context, float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.getResources().getDisplayMetrics());
    }

    /**
     * sp 转 px
     *
     * @param context 上下文
     * @param spValue sp值
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, context.getResources().getDisplayMetrics());
    }

    /**
     * 动态检查以及获取系统权限
     * Android 6.0 以上版本需要，以下不需要
     *
     * @param context 上下文
     * @param permission 权限
     * @return
     */
    public static boolean checkPermission(Context context, String permission){
        int checkPermission = ContextCompat.checkSelfPermission(context, permission);
        if (checkPermission != PackageManager.PERMISSION_GRANTED)
            return false;
        return true;
    }
}
