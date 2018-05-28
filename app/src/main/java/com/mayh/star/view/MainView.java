package com.mayh.star.view;

import com.mayh.star.base.BaseView;

/**
 * =========================================
 *
 * author: Ma Yuhua
 * date: 2018/5/28
 * desc: view 示例
 *
 * =========================================
 */
public interface MainView extends BaseView {

    /**
     * 当数据请求成功后，调用此接口显示数据
     *
     * @param data 数据源
     */
    void showData(String data);
}
