package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ru.navodnikov.denis.collectionsandmaps.dto.Constants;
import ru.navodnikov.denis.collectionsandmaps.models.Collections;
import ru.navodnikov.denis.collectionsandmaps.models.Maps;

public class BenchmarkedModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final int page;

    public BenchmarkedModelFactory(int page) {
        super();
        this.page = page;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == BenchmarkedViewModel.class) {
            if (page == Constants.PAGE_COLLECTIONS) {
                return (T) new BenchmarkedViewModel(new Collections());
            } else if (page == Constants.PAGE_MAPS) {
                return (T) new BenchmarkedViewModel(new Maps());
            }
        }
        return null;
    }
}
