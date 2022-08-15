package com.qxy.bitdance.view.main;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.qxy.bitdance.view.main.adapter.MainLayoutAdapter;
import com.qxy.bitdance.view.main.fragment.RankingFragment;
import com.qxy.bitdance.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

//主界面Activity
public class MainActivity extends AppCompatActivity {
    public static AppCompatActivity appCompatActivity;

    private ActivityMainBinding binding;

    private MainLayoutAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        appCompatActivity = this;
//        setSupportActionBar(binding.toolbar);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (adapter == null) {
            List<Fragment> list = new ArrayList<>();
            list.add(RankingFragment.newInstance());
            adapter = new MainLayoutAdapter(list, getSupportFragmentManager(), getLifecycle());
            binding.viewPager2.setAdapter(adapter);
        }
    }
}
