package com.qxy.bitdance.network.service;

import com.qxy.bitdance.database.domain.RankItem;
import com.qxy.bitdance.network.model.RankData;
import com.qxy.bitdance.network.response.DouYinResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

//榜单网络接口
public interface RankService {

    @GET("/discovery/ent/rank/item/")
    Observable<DouYinResponse<RankData<RankItem>>> getMovieRank(@Header("access-token")String clientToken
            , @Query("type") int type);

    @GET("/discovery/ent/rank/item/")
    Observable<DouYinResponse<RankData<RankItem>>> getMovieRank(@Header("access-token")String clientToken
            , @Query("type") int type, @Query("version") Integer version);

}
