package com.mayh.star.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mayh.star.R;
import com.mayh.star.base.BaseActivity;
import com.mayh.star.presenter.MainPresenter;
import com.mayh.star.view.MainView;
import com.mayh.star.view.custom.BottomIndicator;
import com.zyao89.view.zloading.ZLoadingBuilder;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import java.util.ArrayList;
import java.util.List;

/**
 * =========================================
 *
 * author: Ma Yuhua
 * date: 2018/5/28
 * desc: 项目主页面
 *
 * =========================================
 */
public class MainActivity extends BaseActivity implements MainView, View.OnClickListener {
    private ViewPager mViewPager;
    private BottomIndicator mBottomIndicator;

    private List<Fragment> mFragments = new ArrayList<>();
    private FragmentPagerAdapter mPagerAdapter;

    private TextView testText;
    private Button testBtn;

    private ZLoadingDialog mDialog;

    MainPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);

        testText = (TextView) findViewById(R.id.testText);
        testBtn = (Button) findViewById(R.id.testBtn);

        testBtn.setOnClickListener(this);

        initView();
        initDialog();

        // 初始化 Presenter
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
    }

    /**
     * 初始化Dialog
     */
    private void initDialog(){
        mDialog = new ZLoadingDialog(this);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.setLoadingBuilder(Z_TYPE.PAC_MAN)// 设置类型
                .setLoadingColor(Color.RED)// 颜色
                .setHintText("Loading...")// 提示文字
                .setHintTextColor(Color.RED)// 提示文字颜色
                .setHintTextSize(16)// 提示文字大小 sp
                .setDurationTime(0.5)// 设置动画时间百分比
                .setDialogBackgroundColor(Color.parseColor("#CC111111"));// 设置背景颜色，默认白色
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mBottomIndicator = (BottomIndicator) findViewById(R.id.bottomIndicator);

        mFragments.add(StarPowerFragment.newInstance("", ""));
        mFragments.add(TrackFragment.newInstance("", ""));
        mFragments.add(DynamicFragment.newInstance("", ""));
        mFragments.add(StarFragment.newInstance("", ""));
        mPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this, mFragments);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(2);
        mBottomIndicator.setViewPager(mViewPager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 断开View引用
        mPresenter.detachView();
    }

    @Override
    public void showLoading() {
        super.showLoading();
        if (mDialog != null)
            mDialog.show();
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        if (mDialog != null)
            mDialog.dismiss();
    }

    @Override
    public void showData(String data) {
        testText.setText(data);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.testBtn:
                mPresenter.getData("normal");
                break;

            default:
                break;
        }
    }
}
