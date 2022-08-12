package com.qxy.bitdance.dataSource;

import com.qxy.bitdance.database.domain.AccessToken;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;

// AccessToken接口类
public interface AccessTokenDataSource {

    // 从数据库获取AccessToken
    Maybe<AccessToken> getAccessToken();

    // 添加AccessToken到数据库
    Completable insert(AccessToken accessToken);

    // 联网申请AccessToken
    Observable<AccessToken> requestAccessToken(String authCode);
}
