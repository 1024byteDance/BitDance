package com.qxy.bitdance.view.ranking;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qxy.bitdance.database.domain.RankItem;

public abstract class BaseRanking extends RecyclerView.ViewHolder {
    public BaseRanking(@NonNull View itemView) {
        super(itemView);
    }
    abstract public void bind(RankItem rankItem);
}
