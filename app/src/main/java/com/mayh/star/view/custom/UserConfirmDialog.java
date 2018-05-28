package com.mayh.star.view.custom;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mayh.star.R;
import com.mayh.star.utils.StringUtils;

/**
 *  自定义dialog
 *
 * author: Ma Yuhua
 * date: 2016/6/8
 */
public class UserConfirmDialog extends Dialog implements View.OnClickListener {
    private OnConfirmListener mListener;
    private Context mContext;
    private TextView mText_title, mText_content, mText_ok, mText_cancel;
    private View view_line;
    private String mDialogTitle; // dialog标题
    private String mDialogContent;  // dialog内容
    private boolean mDialogLeft = true;   // 是否显示dialog取消
    private String mDialogRightText;  // dialog右边按钮文字
    private String mDialogLeftText;  // dialog左边按钮文字
    private String mDialogLeftTextColor; // dialog左边按钮文字颜色
    private String mDialogRightTextColor; // dialog右边按钮文字颜色

    public String getDialogTitle() {
        return mDialogTitle;
    }

    public void setDialogTitle(int resId) {
        this.mDialogTitle = mContext.getResources().getString(resId);
    }

    public void setDialogTitle(String mDialogTitle) {
        this.mDialogTitle = mDialogTitle;
    }

    public String getDialogContent() {
        return mDialogContent;
    }

    public void setDialogContent(int resId) {
        this.mDialogContent = mContext.getResources().getString(resId);
    }

    public void setDialogContent(String mDialogContent) {
        this.mDialogContent = mDialogContent;
    }

    public boolean getDialogLeft() {
        return mDialogLeft;
    }

    public void setDialogLeft(boolean mDialogLeft) {
        this.mDialogLeft = mDialogLeft;
    }

    public String getDialogRightText() {
        return mDialogRightText;
    }

    public void setDialogRightText(int resId) {
        this.mDialogRightText = mContext.getResources().getString(resId);
    }

    public void setDialogRightText(String mDialogRightText) {
        this.mDialogRightText = mDialogRightText;
    }

    public void setDialogLeftText(boolean mDialogLeft, String dialogLeftText) {
        this.mDialogLeft = mDialogLeft;
        this.mDialogLeftText = dialogLeftText;
    }

    public void setDialogLeftText(boolean mDialogLeft, int resId) {
        this.mDialogLeft = mDialogLeft;
        this.mDialogLeftText = mContext.getResources().getString(resId);
    }

    public String getDialogLeftText() {
        return mDialogLeftText;
    }

    public String getDialogRightTextColor() {
        return mDialogRightTextColor;
    }

    public void setDialogRightTextColor(String dialogRightTextColor) {
        this.mDialogRightTextColor = dialogRightTextColor;
    }

    public String getDialogLeftTextColor() {
        return mDialogLeftTextColor;
    }

    public void setDialogLeftTextColor(String dialogLeftTextColor) {
        this.mDialogLeftTextColor = dialogLeftTextColor;
    }

    public UserConfirmDialog(Context context, OnConfirmListener onListener) {
        super(context, R.style.Dialog);
        this.mListener = onListener;
        this.mContext = context;
    }

    public UserConfirmDialog(Context context, int theme) {
        super(context, theme);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_confirm_dialog);
        initView();
    }

    /**
     * 初始化布局
     */
    private void initView() {
        mText_title = (TextView) findViewById(R.id.title);
        mText_content = (TextView) findViewById(R.id.content);
        mText_cancel = (TextView) findViewById(R.id.dialog_cancel);
        mText_ok = (TextView) findViewById(R.id.dialog_confirm);
        view_line = (View) findViewById(R.id.view_line);

        // 设置标题
        if (!StringUtils.EmptyEquals(getDialogTitle())) {
            mText_title.setText(mDialogTitle);
        }

        // 设置内容
        if (!StringUtils.EmptyEquals(getDialogContent())) {
            mText_content.setVisibility(View.VISIBLE);
            mText_content.setText(mDialogContent);
        } else {
            mText_content.setVisibility(View.GONE);
        }

        // 设置左右按钮字体颜色
        if(!StringUtils.EmptyEquals(mDialogLeftTextColor)){
            mText_cancel.setTextColor(Color.parseColor(mDialogLeftTextColor));
        }
        if(!StringUtils.EmptyEquals(mDialogRightTextColor)){
            mText_ok.setTextColor(Color.parseColor(mDialogRightTextColor));
        }

        // 设置按钮左边字体
        if (mDialogLeft) {
            mText_cancel.setVisibility(View.VISIBLE);
            view_line.setVisibility(View.VISIBLE);
            if (!StringUtils.EmptyEquals(getDialogLeftText())) {
                mText_cancel.setText(mDialogLeftText);
            }
        } else {
            mText_ok.setBackgroundResource(R.drawable.dialog_btn_selector);
            mText_cancel.setVisibility(View.GONE);
            view_line.setVisibility(View.GONE);
        }

        // 设置右边按钮字体
        if (!StringUtils.EmptyEquals(getDialogRightText())) {
            mText_ok.setText(mDialogRightText);
        }

        mText_cancel.setOnClickListener(this);
        mText_ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_confirm:
                mListener.onOkClick(this);
                break;

            case R.id.dialog_cancel:
                mListener.onCancelClick(this);
                break;
        }
    }

    public interface OnConfirmListener {
        void onCancelClick(Dialog dialog);

        void onOkClick(Dialog dialog);
    }
}
