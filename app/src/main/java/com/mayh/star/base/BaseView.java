package com.mayh.star.base;

import android.content.Context;

/**
 * Created by mayanhua on 2018/5/10.
 * <p>
 * MVP 架构的 View 的基类
 * View接口中定义Activity的UI逻辑
 */

public interface BaseView {

    /**
     * 显示正在加载的view
     */
    void showLoading();

    /**
     * 隐藏正在加载的view
     */
    void hideLoading();

    /**
     * 显示提示
     *
     * @param msg 提示信息
     */
    void showToast(String msg);

    /**
     * 显示请求错误提示
     */
    void showError();

    /**
     * 获取上下文
     *
     * @return 上下文
     */
    Context getContext();

}
