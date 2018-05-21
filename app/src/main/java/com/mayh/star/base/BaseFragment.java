package com.mayh.star.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mayanhua on 2018/5/10.
 * <p>
 * 项目 Fragment 的基类
 */

public abstract class BaseFragment extends Fragment implements BaseView {
    public abstract int getContentViewId();

    protected abstract void initAllMemberView(Bundle saveInstanceState);

    protected Context mContext;
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getContentViewId(), container, false);
        this.mContext = getActivity();
        initAllMemberView(savedInstanceState);
        return mRootView;
    }

    @Override
    public void showLoading() {
        checkActivityAttached();
        ((BaseActivity) mContext).showLoading();
    }

    @Override
    public void hideLoading() {
        checkActivityAttached();
        ((BaseActivity) mContext).hideLoading();
    }

    @Override
    public void showToast(String msg) {
        checkActivityAttached();
        ((BaseActivity) mContext).showToast(msg);
    }

    @Override
    public void showError() {
        checkActivityAttached();
        ((BaseActivity) mContext).showError();
    }

    protected boolean isAttachedContext() {
        return getActivity() != null;
    }

    /**
     * 检查Activity连接情况
     */
    public void checkActivityAttached() {
        if (getActivity() == null)
            throw new ActivityNotAttachedException();
    }

    public static class ActivityNotAttachedException extends RuntimeException {
        public ActivityNotAttachedException() {
            super("Fragment has disconnected from Activity ! - -.");
        }
    }
}
