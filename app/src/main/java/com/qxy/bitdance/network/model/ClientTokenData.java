package com.qxy.bitdance.network.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.qxy.bitdance.network.response.DouyinBaseData;

//ClientToken请求回调data实体类(client_access_token用于不需要用户授权就可以调用的接口。)
public class ClientTokenData extends DouyinBaseData {

    // 接口调用凭证
    @SerializedName("access_token")
    private String accessToken;

    // access_token接口调用凭证超时时间，单位（秒)
    @SerializedName("expires_in")
    private Long expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    @NonNull
    @Override
    public String toString() {
        return "ClientTokenData{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", errorCode=" + errorCode +
                ", description='" + description + '\'' +
                '}';
    }
}
