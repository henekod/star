package com.mayh.star.view;

import com.mayh.star.base.BaseView;

/**
 * Created by mayanhua on 2018/5/11.
 * <p>
 * view 示例
 */

public interface MainView extends BaseView {

    /**
     * 当数据请求成功后，调用此接口显示数据
     *
     * @param data 数据源
     */
    void showData(String data);
}
