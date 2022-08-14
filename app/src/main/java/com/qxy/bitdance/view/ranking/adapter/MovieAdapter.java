package com.qxy.bitdance.view.ranking.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qxy.bitdance.R;
import com.qxy.bitdance.database.domain.RankItem;
import com.qxy.bitdance.view.ranking.BaseRanking;
import com.qxy.bitdance.view.ranking.movie.Movie;
import com.qxy.bitdance.view.ranking.tv.Tv;
import com.qxy.bitdance.view.ranking.variety.Varietr;

import java.util.List;

//电影榜单适配器
public class MovieAdapter extends RecyclerView.Adapter<BaseRanking>{

    private final List<RankItem> dates;
    private final int type;

    public MovieAdapter(List<RankItem> dates, int type) {
        this.dates = dates;
        this.type = type;
    }

    @NonNull
    @Override
    public BaseRanking onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
            return new Movie(itemView);
        } else if (viewType == 2) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_tv, parent, false);
            return new Tv(itemView);
        }
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_varietr, parent, false);
        return new Varietr(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRanking holder, int position) {
        holder.bind(dates.get(position));
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }

    @Override
    public int getItemViewType(int position) {
        return type;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
