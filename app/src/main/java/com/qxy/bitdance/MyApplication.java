package com.qxy.bitdance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;

import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;

public class MyApplication extends Application {

    //Client Key
    public static final String clientkey = "aw8vkj85mfe2pkc6";
    //Client Secret
    public static final String clientSecret = "e3d9ad23babe5a2563bac4da19a00064";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate();
        DouYinOpenApiFactory.init(new DouYinOpenConfig(clientkey));
    }
}