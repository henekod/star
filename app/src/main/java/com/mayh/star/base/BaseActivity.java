package com.mayh.star.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.mayh.star.R;
import com.mayh.star.view.custom.ProgressDialog;

/**
 * Created by mayanhua on 2018/5/10.
 *
 * 项目 Activity 的基类
 */

public abstract class BaseActivity extends Activity implements BaseView {
    /** 是否沉浸式状态栏 **/
    private boolean isStatusBar = true;

    /** 是否允许全屏 **/
    private boolean mAllowFullScreen = true;

    /** 是否禁止旋转屏幕 **/
    private boolean isAllowScreenRoate = true;

    /** 当前 Activity 渲染视图 View **/
    private View mContextView = null;

    /** 是否输出日志信息 **/
    private boolean isDebug;

    private String APP_NAME;

    protected final String TAG = this.getClass().getSimpleName();

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
    }

    @Override
    public void showLoading() {
        if (!mProgressDialog.isShowing())
            mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        showToast(getResources().getString(R.string.app_name));
    }

    @Override
    public Context getContext() {
        return BaseActivity.this;
    }
}
