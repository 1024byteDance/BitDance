package com.qxy.bitdance.view;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.qxy.bitdance.factory.RepositoryFactory;
import com.qxy.bitdance.view.filmlist.fragment.MovieViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    public static ViewModelFactory provide(Context context) {
        return new ViewModelFactory(context);
    }

    private final Context context;

    public ViewModelFactory(Context context) {
        this.context = context;
    }

    @Override
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(RepositoryFactory.providerRankItemRepository(context));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
