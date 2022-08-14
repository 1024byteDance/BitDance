package com.qxy.bitdance.view.ranking.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.qxy.bitdance.R;
import com.qxy.bitdance.databinding.FragmentMovieBinding;
import com.qxy.bitdance.network.exception.ErrorConsumer;
import com.qxy.bitdance.network.exception.NetException;
import com.qxy.bitdance.view.ViewModelFactory;
import com.qxy.bitdance.view.ranking.adapter.MovieAdapter;

import io.reactivex.disposables.CompositeDisposable;

//电影榜单Fragment
public class MovieFragment extends Fragment {


    public static MovieFragment newInstance(int type, int version) {
        return new MovieFragment(type, version);
    }

    // 榜单版本 0 最新
    private final int version;
    private final int type;

    public MovieFragment(int type, int version) {
        this.version = version;
        this.type = type;
    }


    private MovieViewModel vm;

    private FragmentMovieBinding binding;

    private CompositeDisposable compositeDisposable;

    private  MovieAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        vm = new ViewModelProvider(this, ViewModelFactory.provide(requireContext())).get(MovieViewModel.class);
        compositeDisposable = new CompositeDisposable();
        binding = FragmentMovieBinding.inflate(getLayoutInflater(), container, false);
        binding.swipeRefresh.setOnRefreshListener(this::list);
        // 设置列表相关属性
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setItemViewCacheSize(15);
        binding.swipeRefresh.setColorSchemeColors(requireContext().getResources().getColor(R.color.purple_500));
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        binding.swipeRefresh.setRefreshing(true);
        list();
    }

    private void list() {
        // 请求获取榜单列表
        compositeDisposable.add(vm.getRankList(type,version)
                .subscribe(rankItems -> {
                    if (rankItems.size() > 0) {
                        if (adapter == null) {
                            binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
                        }
                        adapter = new MovieAdapter(rankItems,type);
                        adapter.setHasStableIds(true);
                        binding.recyclerView.setAdapter(adapter);
                    }
                    binding.swipeRefresh.setRefreshing(false);
                    binding.msgText.setVisibility(View.GONE);
                }, new ErrorConsumer() {
                    @Override
                    protected void error(NetException e) {
                        Toast.makeText(requireContext(), e.getMsg(), Toast.LENGTH_SHORT).show();
                        binding.swipeRefresh.setRefreshing(false);
                        binding.msgText.setVisibility(View.VISIBLE);
                        binding.msgText.setText(e.getMsg() + "，请下拉刷新");
                    }
                }));
    }

    @Override
    public void onStop() {
        super.onStop();
        compositeDisposable.clear();
    }
}