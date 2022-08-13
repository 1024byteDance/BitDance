package com.qxy.bitdance.tiktokApi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bytedance.sdk.open.aweme.CommonConstants;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.qxy.bitdance.dataSource.AccessTokenDataSource;
import com.qxy.bitdance.factory.RepositoryFactory;
import com.qxy.bitdance.network.exception.ErrorConsumer;
import com.qxy.bitdance.network.exception.NetException;

import io.reactivex.disposables.Disposable;

public class TiktoEntryActivity extends Activity implements IApiEventHandler {

    DouYinOpenApi douYinOpenApi;

    @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        douYinOpenApi = DouYinOpenApiFactory.create(this);
        douYinOpenApi.handleIntent(getIntent(), this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {

        if (baseResp.getType() == CommonConstants.ModeType.SEND_AUTH_RESPONSE) {
            Authorization.Response response = (Authorization.Response) baseResp;
            if (response.isSuccess()) {
                Toast.makeText(this, "授权成功", Toast.LENGTH_LONG).show();
                getAccessToken(response.authCode);
            }
            else {
                Toast.makeText(this, "授权失败", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onErrorIntent(Intent intent) {
        Toast.makeText(this, "网络错误", Toast.LENGTH_LONG).show();
        finish();
    }


    private void getAccessToken(String authCode) {
        AccessTokenDataSource accessTokenDataSource = RepositoryFactory.providerAccessTokenRepository(this);
        Disposable disposable = accessTokenDataSource.requestAccessToken(authCode)
                .subscribe(accessToken -> {
                    Toast.makeText(TiktoEntryActivity.this, "成功获取AccessToken", Toast.LENGTH_SHORT).show();
                    System.out.println(accessToken);
                    finish();
                }, new ErrorConsumer() {
                    @Override
                    protected void error(NetException e) {
                        Toast.makeText(TiktoEntryActivity.this,e.getMsg(),Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }
}
