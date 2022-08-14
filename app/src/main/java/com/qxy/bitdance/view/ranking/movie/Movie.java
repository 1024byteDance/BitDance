package com.qxy.bitdance.view.ranking.movie;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.qxy.bitdance.database.domain.RankItem;
import com.qxy.bitdance.databinding.ListItemMovieBinding;
import com.qxy.bitdance.view.ranking.BaseRanking;

//电影榜单
public class Movie extends BaseRanking {

    ListItemMovieBinding binding;

    public Movie(@NonNull View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public void bind(RankItem rankItem) {
        binding.setMovie(rankItem);
    }
}
