package ru.navodnikov.denis.collectionsandmaps.dto;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ru.navodnikov.denis.collectionsandmaps.core.Benchmarked;

public class BenchmarkedModelFactory extends ViewModelProvider.NewInstanceFactory {
    private Benchmarked benchmarked;

    public BenchmarkedModelFactory(Benchmarked benchmarked) {
        super();
        this.benchmarked = benchmarked;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == BenchmarkedViewModel.class)
            return (T) new BenchmarkedViewModel(benchmarked);
        return null;
    }
}
