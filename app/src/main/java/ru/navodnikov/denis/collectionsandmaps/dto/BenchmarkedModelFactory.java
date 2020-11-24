package ru.navodnikov.denis.collectionsandmaps.dto;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ru.navodnikov.denis.collectionsandmaps.core.Benchmarked;
import ru.navodnikov.denis.collectionsandmaps.core.Collections;
import ru.navodnikov.denis.collectionsandmaps.core.Maps;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.Pages;

public class BenchmarkedModelFactory extends ViewModelProvider.NewInstanceFactory {
    private int page;

    public BenchmarkedModelFactory(int page) {
        super();
        this.page = page;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == BenchmarkedViewModel.class)
            if (page == Pages.PAGE_COLLECTIONS) {
                return (T) new BenchmarkedViewModel(new Collections());
            } else if (page == Pages.PAGE_MAPS) {
                return (T) new BenchmarkedViewModel(new Maps());
            }
        return null;
    }
}
