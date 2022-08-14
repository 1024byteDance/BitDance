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
import com.qxy.bitdance.view.ranking.RankingActivity;

//榜单页面Fragment
public class RankingFragment extends Fragment {

    private FragmentRankBinding fragmentRankBinding;

    public static RankingFragment newInstance() {
        return new RankingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        fragmentRankBinding = FragmentRankBinding.inflate(getLayoutInflater(),container,false);
        onClickFilm();
        onClickTv();
        onClickVariter();

        return fragmentRankBinding.getRoot();
    }

    private void onClickFilm() {
        // 设置点击跳转电影榜单页面
        fragmentRankBinding.filmCardView.setOnClickListener((v) ->{
            Intent intent = new Intent(requireContext(), RankingActivity.class);
            intent.putExtra("type",1);
            intent.putExtra("version",0);
            requireContext().startActivity(intent);
        });
    }

    private void onClickTv() {
        // 设置点击跳转电视剧榜单页面
        fragmentRankBinding.tvCardView.setOnClickListener((v) ->{
            Intent intent = new Intent(requireContext(), RankingActivity.class);
            intent.putExtra("type",2);
            intent.putExtra("version",0);
            requireContext().startActivity(intent);
        });
    }

    private void onClickVariter() {
        // 设置点击跳转综艺榜单页面
        fragmentRankBinding.varietrCardView.setOnClickListener((v) ->{
            Intent intent = new Intent(requireContext(), RankingActivity.class);
            intent.putExtra("type",3);
            intent.putExtra("version",0);
            requireContext().startActivity(intent);
        });
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
