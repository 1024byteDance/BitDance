package com.qxy.bitdance.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.qxy.bitdance.database.domain.ClientToken;

import io.reactivex.Completable;
import io.reactivex.Maybe;

//ClientToken Dao类
@Dao
public interface ClientTokenDao {

    @Query("select * from clienttoken where expiresIn - :curTime > 1000 * 60 limit 1")
    Maybe<ClientToken> getClientToken(long curTime);

    @Insert
    Completable insert(ClientToken clientToken);
}
