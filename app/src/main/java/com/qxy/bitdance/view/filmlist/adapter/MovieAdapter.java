package com.qxy.bitdance.view.filmlist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.qxy.bitdance.R;
import com.qxy.bitdance.database.domain.RankItem;
import com.qxy.bitdance.databinding.ListItemMovieBinding;

import java.util.List;

//电影榜单适配器
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder>{

    private final List<RankItem> dates;

    public MovieAdapter(List<RankItem> dates) {
        this.dates = dates;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new MovieHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        holder.bind(dates.get(position));
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }

    public static class MovieHolder extends RecyclerView.ViewHolder {

        ListItemMovieBinding binding;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        private void bind(RankItem rankItem) {
            binding.setMovie(rankItem);
        }

    }

}
