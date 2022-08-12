package com.qxy.bitdance.dataSource;

import com.qxy.bitdance.database.domain.ClientToken;

import io.reactivex.Completable;
import io.reactivex.Maybe;

//ClientToken接口类
public interface ClientTokenDataSource {

    // 从数据库获取ClientToken
    Maybe<ClientToken> getClientToken();

    // 添加ClientToken到数据库
    Completable insert(ClientToken clientToken);
}

