package com.mayh.star.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mayh.star.R;
import com.mayh.star.base.BaseActivity;
import com.mayh.star.presenter.MainPresenter;
import com.mayh.star.view.MainView;

/**
 * Created by mayanhua on 2018/5/10.
 * <p>
 * 项目主页面
 */
public class MainActivity extends BaseActivity implements MainView, View.OnClickListener {
    private TextView testText;
    private Button testBtn;

    MainPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);

        testText = (TextView) findViewById(R.id.testText);
        testBtn = (Button) findViewById(R.id.testBtn);

        testBtn.setOnClickListener(this);

        // 初始化 Presenter
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 断开View引用
        mPresenter.detachView();
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
