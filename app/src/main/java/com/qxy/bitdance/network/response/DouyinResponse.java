package com.qxy.bitdance.network.response;

import androidx.annotation.NonNull;

//抖音Api接口回调实体类
public class DouyinResponse<T extends DouyinBaseData> {

    // 回调核心数据
    private T data;

    private String message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @NonNull
    @Override
    public String toString() {
        return "DouYinResponse{" +
                "data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}