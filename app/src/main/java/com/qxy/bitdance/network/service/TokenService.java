package com.qxy.bitdance.network.service;

import com.qxy.bitdance.network.model.AccessTokenData;
import com.qxy.bitdance.network.model.ClientTokenData;
import com.qxy.bitdance.network.response.DouyinResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

//凭证Token网络接口
public interface TokenService {

    @FormUrlEncoded
    @POST("/oauth/access_token/")
    Observable<DouyinResponse<AccessTokenData>> getAccessToken(@Field("client_secret") String clientSecret
            , @Field("code") String code, @Field("grant_type") String grantType
            , @Field("client_key") String clientKey);

    @FormUrlEncoded
    @POST("/oauth/client_token/")
    Observable<DouyinResponse<ClientTokenData>> getClientToken(@Field("client_key") String clientKey,
                                                               @Field("client_secret") String clientSecret,
                                                               @Field("grant_type") String grantType);

}
