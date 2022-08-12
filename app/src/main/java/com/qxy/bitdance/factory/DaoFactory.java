package com.qxy.bitdance.factory;

import android.content.Context;

import com.qxy.bitdance.database.MyDB;
import com.qxy.bitdance.database.dao.AccessTokenDao;
import com.qxy.bitdance.database.dao.ClientTokenDao;
import com.qxy.bitdance.database.dao.RankItemDao;

//Dao工厂类
public class DaoFactory {

    public static MyDB providerAppDatabase(Context context) {
        return MyDB.get(context);
    }

    public static AccessTokenDao providerAccessTokenDao(Context context) {
        return providerAppDatabase(context).accessTokenDao();
    }

    public static ClientTokenDao providerClientTokenDao(Context context) {
        return providerAppDatabase(context).clientTokenDao();
    }

    public static RankItemDao providerRankItemDao(Context context) {
        return providerAppDatabase(context).rankItemDao();
    }
}
