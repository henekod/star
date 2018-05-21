package com.mayh.star.model;

import android.os.Handler;

import com.mayh.star.base.BaseModel;
import com.mayh.star.callback.NetWorkCallBack;

/**
 * Created by mayanhua on 2018/5/11.
 * <p>
 * Model 示例
 */

public class MainModel extends BaseModel<String> {

    @Override
    public void execute(final NetWorkCallBack<String> callBack) {
        // 利用postDelayed方法模拟网络请求数据的耗时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // mParams 是从父类得到的请求参数
                switch (mParams[0]) {
                    case "normal":
                        callBack.onSuccess("根据参数" + mParams[0] + "的请求网络数据成功");
                        break;

                    case "failure":
                        callBack.onFailure(0, "请求失败：参数有误");
                        break;

                    case "error":
                        callBack.onError();
                        break;
                }
                callBack.onComplete();
            }
        }, 2000);
    }
}
