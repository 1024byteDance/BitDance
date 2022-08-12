package com.qxy.bitdance.network.exception;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

//自定义网络请求异常类
public class NetException extends Exception{

    private final String msg;

    public NetException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public static NetException handleException(Throwable e) {
        e.printStackTrace();
        NetException ex;
        if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            ex = new NetException("数据解析异常");
        } else if (e instanceof ConnectException
                || e instanceof UnknownHostException
                || e instanceof SocketTimeoutException) {
            ex = new NetException("网络请求异常");
        } else {
            ex = new NetException("未知异常");
        }
        return ex;
    }
}
