package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;
import javax.inject.Named;

import ru.navodnikov.denis.collectionsandmaps.BenchmarkApp;
import ru.navodnikov.denis.collectionsandmaps.dto.Constants;
import ru.navodnikov.denis.collectionsandmaps.models.Benchmarked;
import ru.navodnikov.denis.collectionsandmaps.models.Collections;
import ru.navodnikov.denis.collectionsandmaps.models.Maps;

public class BenchmarkedModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final int page;
    @Inject
    @Named("Collections")
    Benchmarked collections;
    @Inject
    @Named("Maps")
    Benchmarked maps;

    public BenchmarkedModelFactory(int page) {
        super();
        this.page = page;
        BenchmarkApp.getContext().getAppComponent().inject(this);
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == BenchmarkedViewModel.class) {
            if (page == Constants.PAGE_COLLECTIONS) {
                return (T) new BenchmarkedViewModel(collections);
            } else if (page == Constants.PAGE_MAPS) {
                return (T) new BenchmarkedViewModel(maps);
            }
        }
        return null;
    }
}
