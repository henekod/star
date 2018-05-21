package com.mayh.star.base;

/**
 * Created by mayanhua on 2018/5/10.
 * <p>
 * MVP 架构的 Presenter 的基类
 */

public class BasePresenter<V extends BaseView> {

    // 绑定的view
    private V mBaseView;

    /**
     * 绑定view，一般在初始化中调用该方法
     *
     * @param baseView
     */
    public void attachView(V baseView) {
        this.mBaseView = baseView;
    }

    /**
     * 解绑view，一般在onDestroy中调用该方法
     */
    public void detachView() {
        this.mBaseView = null;
    }

    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     *
     * @return
     */
    public boolean isViewAttached() {
        return mBaseView != null;
    }

    /**
     * 获取连接的view
     *
     * @return
     */
    public V getView() {
        return mBaseView;
    }

}
