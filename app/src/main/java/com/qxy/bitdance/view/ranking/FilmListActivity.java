package com.qxy.bitdance.view.ranking;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.qxy.bitdance.databinding.ActivityRankBinding;
import com.qxy.bitdance.view.ranking.fragment.MovieFragment;

//榜单Activity类
public class FilmListActivity extends AppCompatActivity {

    ActivityRankBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRankBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadFragment();
    }

    // 加载页面
    private void loadFragment() {
        int type = getIntent().getIntExtra("type",1);
        int version = getIntent().getIntExtra("version",0);
        Fragment fragment = MovieFragment.newInstance(type, version);
        getSupportFragmentManager()
                .beginTransaction()
                .add(binding.fragment.getId(), fragment)
                .commit();
    }
}
