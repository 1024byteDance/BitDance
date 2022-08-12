package com.qxy.bitdance.database.dao;

import com.qxy.bitdance.database.domain.RankItem;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

//榜单item Dao类
@Dao
public interface RankItemDao {

    @Query("select * from rankitem where type == :type and version == :version")
    Maybe<List<RankItem>> queryMovie(int type, int version);

    @Insert
    Completable insert(List<RankItem> rankItems);

    @Query("delete from rankitem where type == :type and version == :version")
    Completable delete(int type, int version);

}

