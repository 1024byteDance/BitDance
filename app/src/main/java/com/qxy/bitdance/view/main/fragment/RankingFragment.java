package com.qxy.bitdance.view.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.qxy.bitdance.R;
import com.qxy.bitdance.database.domain.AccessToken;
import com.qxy.bitdance.databinding.ActivityMainBinding;
import com.qxy.bitdance.view.main.MainActivity;
import com.qxy.bitdance.view.ranking.RankingActivity;

//榜单页面Fragment
public class RankingFragment extends Fragment {

    private ActivityMainBinding activityMainBinding;

    public static RankingFragment newInstance() {
        return new RankingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater(),container,false);
        onClickFilm();
        onClickTv();
        onClickVariter();

        return activityMainBinding.getRoot();
    }

//    private void switchFragment(Fragment fragment) {
//        FragmentTransaction transaction = MainActivity.appCompatActivity.getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.fragment, fragment).commitNow();
//    }

    private void onClickFilm() {
        // 设置点击跳转电影榜单页面
        activityMainBinding.filmCardView.setOnClickListener((v) ->{
            Intent intent = new Intent(requireContext(), RankingActivity.class);
            intent.putExtra("type",1);
            intent.putExtra("version",0);
            requireContext().startActivity(intent);
        });

    }

    private void onClickTv() {
        // 设置点击跳转电视剧榜单页面
        activityMainBinding.tvCardView.setOnClickListener((v) ->{
            Intent intent = new Intent(requireContext(), RankingActivity.class);
            intent.putExtra("type",2);
            intent.putExtra("version",0);
            requireContext().startActivity(intent);
        });
    }

    private void onClickVariter() {
        // 设置点击跳转综艺榜单页面
        activityMainBinding.varietrCardView.setOnClickListener((v) ->{
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
