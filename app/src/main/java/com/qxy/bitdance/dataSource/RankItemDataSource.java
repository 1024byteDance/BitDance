package com.qxy.bitdance.dataSource;

import com.qxy.bitdance.database.domain.RankItem;

import java.util.List;

import io.reactivex.Maybe;

//RankItem接口类
public interface RankItemDataSource {

    // 根据类型与版本号查询榜单
    Maybe<List<RankItem>> queryMovie(int type, int version);
}
