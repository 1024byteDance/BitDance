package com.qxy.bitdance.tiktokApi;

import android.app.Activity;

import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;

public class ApiUtil {

    // 权限集
    private static final String mScope =
            "user_info" +            //授权登录与用户基础信息
            "trial.whitelist" +      //测试应用白名单权限
            "renew_refresh_token" +  //授权动态续期
            "discovery.ent" +        //抖音影视综榜单数据
            "fans.list" +            //关注和粉丝列表
            "following.list" +       //关注和粉丝列表
            "video.list" +           //视频查询
            "video.data"             //视频查询
    ;

    // 授权调用
    public static boolean sendAuth(Activity activity) {
        DouYinOpenApi douYinOpenApi = DouYinOpenApiFactory.create(activity);
        Authorization.Request request = new Authorization.Request();

        // 用户授权时必选权限
        request.scope = mScope;
        // 优先使用抖音app进行授权，如果抖音app因版本或者其他原因无法授权，则使用wap页授权
        return douYinOpenApi.authorize(request);

    }
}
