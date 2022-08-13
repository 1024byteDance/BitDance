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
import com.qxy.bitdance.view.filmlist.FilmListActivity;

//榜单页面Fragment
public class RankFragment extends Fragment {

    private FragmentRankBinding binding;

    public static RankFragment newInstance() {
        return new RankFragment();
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
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
