package com.qxy.bitdance.view.ranking.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.qxy.bitdance.R;
import com.qxy.bitdance.database.domain.RankItem;
import com.qxy.bitdance.databinding.ListItemMovieBinding;
import com.qxy.bitdance.view.ranking.BaseRanking;
import com.qxy.bitdance.view.ranking.movie.Movie;

import java.util.List;

//电影榜单适配器
public class MovieAdapter extends RecyclerView.Adapter<BaseRanking>{

    private final List<RankItem> dates;

    public MovieAdapter(List<RankItem> dates) {
        this.dates = dates;
    }

    @NonNull
    @Override
    public BaseRanking onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new Movie(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRanking holder, int position) {
        holder.bind(dates.get(position));
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }


}
