package ru.navodnikov.denis.collectionsandmaps.dto;

import androidx.lifecycle.ViewModel;

import ru.navodnikov.denis.collectionsandmaps.core.Benchmarked;

public class BenchmarkedViewModel extends ViewModel {
    private Benchmarked benchmarked;

    public BenchmarkedViewModel(Benchmarked benchmarked) {
        this.benchmarked = benchmarked;
    }
}


