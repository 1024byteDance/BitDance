package com.qxy.bitdance.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.qxy.bitdance.database.converter.StringArrayConverters;
import com.qxy.bitdance.database.dao.AccessTokenDao;
import com.qxy.bitdance.database.dao.ClientTokenDao;
import com.qxy.bitdance.database.dao.RankItemDao;
import com.qxy.bitdance.database.domain.AccessToken;
import com.qxy.bitdance.database.domain.ClientToken;
import com.qxy.bitdance.database.domain.RankItem;

//数据库类
@Database(entities = {AccessToken.class, ClientToken.class, RankItem.class}, version = 2)
@TypeConverters({StringArrayConverters.class})
public abstract class MyDB extends RoomDatabase {

    public abstract AccessTokenDao accessTokenDao();

    public abstract ClientTokenDao clientTokenDao();

    public abstract RankItemDao rankItemDao();

    private static volatile MyDB INSTANCE;

    public static MyDB get(Context context) {
        if (INSTANCE == null) {
            synchronized (MyDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyDB.class, "my-database").build();
                }
            }
        }
        return INSTANCE;
    }
}
