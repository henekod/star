package com.mayh.star.utils;

import android.text.TextUtils;

/**
 * =========================================
 *
 * author: Ma Yuhua
 * date: 2018/5/28
 * desc: 字符串工具类
 *
 * =========================================
 */
public class StringUtils {

    /**
     * 是否字符串为空
     * @param str
     * @return
     */
    public static boolean EmptyEquals(String str){
        if (TextUtils.isEmpty(str) || "null".equals(str)) {
            return true;
        }
        return false;
    }
}
