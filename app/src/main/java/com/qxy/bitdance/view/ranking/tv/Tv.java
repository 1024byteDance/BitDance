package com.qxy.bitdance.view.ranking.tv;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.qxy.bitdance.database.domain.RankItem;
import com.qxy.bitdance.databinding.ListItemTvBinding;
import com.qxy.bitdance.view.ranking.BaseRanking;

//电视榜单
public class Tv extends BaseRanking {
    ListItemTvBinding binding;

    public Tv(@NonNull View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    @Override
    public void bind(RankItem rankItem) {
        binding.setMovie(rankItem);
    }
}
