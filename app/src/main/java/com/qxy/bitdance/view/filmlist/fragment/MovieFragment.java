package com.qxy.bitdance.view.filmlist.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.qxy.bitdance.databinding.FragmentMovieBinding;
import com.qxy.bitdance.network.exception.ErrorConsumer;
import com.qxy.bitdance.network.exception.NetException;
import com.qxy.bitdance.view.ViewModelFactory;
import com.qxy.bitdance.view.filmlist.adapter.MovieAdapter;

import io.reactivex.disposables.CompositeDisposable;

//电影榜单Fragment
public class MovieFragment extends Fragment {


    public static MovieFragment newInstance(int version) {
        return new MovieFragment(version);
    }

    // 榜单版本 0 最新
    private final int version;

    public MovieFragment(int version) {
        this.version = version;
    }


    private MovieViewModel vm;

    private FragmentMovieBinding binding;

    private CompositeDisposable compositeDisposable;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        vm = new ViewModelProvider(this, ViewModelFactory.provide(requireContext())).get(MovieViewModel.class);
        compositeDisposable = new CompositeDisposable();
        binding = FragmentMovieBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        // 请求获取榜单列表
        compositeDisposable.add(vm.getRankList(version).subscribe(rankItems -> {
            MovieAdapter adapter = new MovieAdapter(rankItems);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
            binding.recyclerView.setAdapter(adapter);
        }, new ErrorConsumer() {
            @Override
            protected void error(NetException e) {
                Toast.makeText(requireContext(), e.getMsg(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public void onStop() {
        super.onStop();
        compositeDisposable.clear();
    }
}