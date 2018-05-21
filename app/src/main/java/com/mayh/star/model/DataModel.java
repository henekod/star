package com.mayh.star.model;

import com.mayh.star.base.BaseModel;

/**
 * Created by mayanhua on 2018/5/11.
 * <p>
 * DataModel负责数据请求的分发
 */

public class DataModel {

    public static BaseModel request(String token) {
        // 声明一个空的BaseModel
        BaseModel baseModel = null;
        try {
            // 利用发射机制获取对应Model对象的引用
            baseModel = (BaseModel) Class.forName(token).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return baseModel;
    }
}
