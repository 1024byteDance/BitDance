package com.qxy.bitdance.view.ranking;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.qxy.bitdance.R;
import com.qxy.bitdance.databinding.ActivityRankBinding;
import com.qxy.bitdance.view.ranking.fragment.RankingFragment;


//榜单Activity类
public class RankingActivity extends AppCompatActivity {

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
        int i = 0;
        if (type == 1) {
            i = R.drawable.ic_film;
            binding.layoutTextview.setText("院线电影");
            binding.layoutTextview.setBackgroundColor(Color.WHITE);
        }
        else if(type == 2) {
            i = R.drawable.ic_tv;
            binding.layoutTextview.setText("");
            binding.layoutTextview.getBackground().setAlpha(0);
        }
        else {
            i = R.drawable.ic_variety;
            binding.layoutTextview.setText("");
            binding.layoutTextview.getBackground().setAlpha(0);
        }

        binding.back.setOnClickListener(v -> {
            finish();
        });

        binding.toolbar.setBackgroundResource(i);
        Fragment fragment = RankingFragment.newInstance(type, version);
        getSupportFragmentManager()
                .beginTransaction()
                .add(binding.fragment.getId(), fragment)
                .commit();
    }
}
