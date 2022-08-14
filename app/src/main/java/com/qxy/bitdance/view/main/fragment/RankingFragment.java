package com.qxy.bitdance.view.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.qxy.bitdance.databinding.FragmentRankBinding;
import com.qxy.bitdance.view.ranking.FilmListActivity;

//榜单页面Fragment
public class RankingFragment extends Fragment {

    private FragmentRankBinding binding;

    public static RankingFragment newInstance() {
        return new RankingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentRankBinding.inflate(getLayoutInflater(),container,false);
        // 设置点击跳转电影榜单页面
        binding.filmCardView.setOnClickListener((v) ->{
            Intent intent = new Intent(requireContext(), FilmListActivity.class);
            requireContext().startActivity(intent);
        });
        // 设置点击跳转电视剧榜单页面
        binding.tvCardView.setOnClickListener((v) ->{
            Intent intent = new Intent(requireContext(), FilmListActivity.class);
            intent.putExtra("type",2);
            intent.putExtra("version",0);
            requireContext().startActivity(intent);
        });

        // 设置点击跳转综艺榜单页面
        binding.varietyCardView.setOnClickListener((v) ->{
            Intent intent = new Intent(requireContext(), FilmListActivity.class);
            intent.putExtra("type",3);
            intent.putExtra("version",0);
            requireContext().startActivity(intent);
        });
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
