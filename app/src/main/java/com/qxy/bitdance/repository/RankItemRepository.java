package com.qxy.bitdance.repository;

import com.qxy.bitdance.dataSource.ClientTokenDataSource;
import com.qxy.bitdance.dataSource.RankItemDataSource;
import com.qxy.bitdance.database.dao.RankItemDao;
import com.qxy.bitdance.database.domain.ClientToken;
import com.qxy.bitdance.database.domain.RankItem;
import com.qxy.bitdance.factory.NetWorkFactory;
import com.qxy.bitdance.network.model.RankData;
import com.qxy.bitdance.network.response.DouyinResponse;
import com.qxy.bitdance.network.response.ResponseTransformer;
import com.qxy.bitdance.network.service.RankService;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

//RankItem仓库类
public class RankItemRepository implements RankItemDataSource {

    ClientTokenDataSource clientTokenDataSource;

    RankItemDao rankItemDao;

    public RankItemRepository(ClientTokenDataSource clientTokenDataSource, RankItemDao rankItemDao) {
        this.clientTokenDataSource = clientTokenDataSource;
        this.rankItemDao = rankItemDao;
    }

    @Override
    public Maybe<List<RankItem>> queryMovie(int type, int version) {
        // 首先请求获取clientToken，如果数据库的未过期会从数据库中拿，数据库过期会联网申请
        return clientTokenDataSource.getClientToken()
                .flatMap((Function<ClientToken, MaybeSource<List<RankItem>>>) clientToken -> {
                    // 成功获取ClientToken
                    Retrofit retrofit = NetWorkFactory.provideRetrofit();
                    RankService rankService = retrofit.create(RankService.class);
                    // 根据是否需要版本号选择请求方式
                    Observable<DouyinResponse<RankData<RankItem>>> observable
                            = type == 0 ? rankService.getMovieRank(clientToken.getAccessToken(), type) // 获取最新
                            : rankService.getMovieRank(clientToken.getAccessToken(),type,version); // 根据版本号获取
                    return observable
                            .compose(ResponseTransformer.obtain())
                            .map(rankItemRankData -> {
                                // 如果map被调用，则说明联网请求成功，将结果异步缓存到数据库
                                // 保存数据到数据库
                                rankItemDao.delete(type,version);
                                rankItemDao.insert(rankItemRankData.getList())
                                        .subscribeOn(Schedulers.io())
                                        .subscribe();
                                return rankItemRankData.getList();
                            })
                            .singleElement();
                })
                .onErrorResumeNext((Function<Throwable, MaybeSource<List<RankItem>>>) throwable -> {
                    // 如果请求出现异常(联网失败等情况)
                    System.out.println("请求出现异常，尝试访问数据库");
                    return rankItemDao.queryMovie(type,version)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread());
                });
    }

}
