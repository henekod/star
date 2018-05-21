package com.mayh.star.base;

import com.mayh.star.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by mayanhua on 2018/5/11.
 * <p>
 * MVP 架构的 Model 的基类
 */

public abstract class BaseModel<T> {

    // 数据请求参数
    protected String[] mParams;

    /**
     * 设置数据请求参数
     *
     * @param args 参数数组
     * @return
     */
    public BaseModel params(String... args) {
        mParams = args;
        return this;
    }

    /**
     * 添加callBack并执行数据请求
     * 具体的数据请求由子类执行
     *
     * @param callBack
     */
    public abstract void execute(NetWorkCallBack<T> callBack);

    /**
     * 执行Get网络请求
     *
     * @param url      请求url
     * @param callBack 返回
     */
    protected void requestGetApi(String url, NetWorkCallBack<T> callBack) {
        // 具体的网络请求
    }

    /**
     * 执行Post网络请求
     *
     * @param url      请求url
     * @param params   请求参数
     * @param callBack 返回
     */
    protected void requestPostApi(String url, Map params, NetWorkCallBack<T> callBack) {
        // 具体的网络请求
    }
}
