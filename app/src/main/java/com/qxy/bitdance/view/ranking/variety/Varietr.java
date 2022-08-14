package com.qxy.bitdance.view.ranking.variety;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.qxy.bitdance.database.domain.RankItem;
import com.qxy.bitdance.databinding.ListItemVarietrBinding;
import com.qxy.bitdance.view.ranking.BaseRanking;

public class Varietr extends BaseRanking {
    ListItemVarietrBinding binding;

    public Varietr(@NonNull View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    @Override
    public void bind(RankItem rankItem) {
        binding.setMovie(rankItem);
    }
}
