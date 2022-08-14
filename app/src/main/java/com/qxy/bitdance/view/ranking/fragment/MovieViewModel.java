package com.qxy.bitdance.view.ranking.fragment;

import androidx.lifecycle.ViewModel;

import com.qxy.bitdance.database.domain.RankItem;
import com.qxy.bitdance.repository.RankItemRepository;

import java.util.List;

import io.reactivex.Maybe;

//电影榜单ViewModel
public class MovieViewModel extends ViewModel {

    private final RankItemRepository rankItemRepository;

    public MovieViewModel(RankItemRepository rankItemRepository) {
        this.rankItemRepository = rankItemRepository;
    }

    public Maybe<List<RankItem>> getRankList(int version) {
        return rankItemRepository.queryMovie(1,version);
    }

}
