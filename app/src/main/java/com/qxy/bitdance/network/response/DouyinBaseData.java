package com.qxy.bitdance.network.response;

import com.google.gson.annotations.SerializedName;

//抖音Api接口回调数据data项的基类
public abstract class DouyinBaseData {

    // 错误码
    @SerializedName("error_code")
    protected Long errorCode;

    // 错误码描述
    protected String description;

    public Long getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }
}