package com.qxy.bitdance.factory;

import android.content.Context;

import com.qxy.bitdance.dataSource.AccessTokenDataSource;
import com.qxy.bitdance.dataSource.ClientTokenDataSource;
import com.qxy.bitdance.repository.AccessTokenRepository;
import com.qxy.bitdance.repository.ClientTokenRepository;
import com.qxy.bitdance.repository.RankItemRepository;

//仓库工厂类
public class RepositoryFactory {


    public static AccessTokenDataSource providerAccessTokenRepository(Context context) {
        return new AccessTokenRepository(DaoFactory.providerAccessTokenDao(context));
    }

    public static ClientTokenDataSource providerClientTokenRepository(Context context) {
        return new ClientTokenRepository(DaoFactory.providerClientTokenDao(context));
    }

    public static RankItemRepository providerRankItemRepository(Context context) {
        return new RankItemRepository(providerClientTokenRepository(context)
                ,DaoFactory.providerRankItemDao(context));
    }
}
