package com.qxy.bitdance.view.main.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.qxy.bitdance.R;
import com.qxy.bitdance.databinding.ActivityRankBinding;

@SuppressLint("NewApi")
public class FragmentAll extends Fragment {

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View view = inflater.inflate(R.layout.activity_rank, null);
        return view;
    }
}
