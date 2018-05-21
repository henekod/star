package com.mayh.star.presenter;

import com.mayh.star.base.BasePresenter;
import com.mayh.star.callback.NetWorkCallBack;
import com.mayh.star.model.DataModel;
import com.mayh.star.model.ModelToken;
import com.mayh.star.view.MainView;

/**
 * Created by mayanhua on 2018/5/11.
 * <p>
 * Presenter 示例
 */

public class MainPresenter extends BasePresenter<MainView> {

    /**
     * 获取网络数据
     *
     * @param param 参数
     */
    public void getData(String param) {
        if (!isViewAttached())// 如果没有view引用就不加载数据
            return;

        // 显示正在加载进度条
        getView().showLoading();

        // 使用MainModel请求主页数据
        DataModel.request(ModelToken.API_MAIN_MODEL)
                .params(param)
                .execute(new NetWorkCallBack<String>() {
                    @Override
                    public void onSuccess(String data) {
                        // 调用View接口显示数据
                        if (isViewAttached())
                            getView().showData(data);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        // 调用View接口提示失败信息
                        if (isViewAttached())
                            getView().showToast(msg);
                    }

                    @Override
                    public void onError() {
                        // 调用View接口提示请求异常
                        if (isViewAttached())
                            getView().showError();
                    }

                    @Override
                    public void onComplete() {
                        if (isViewAttached())
                            getView().hideLoading();
                    }
                });
    }

}
