package ru.navodnikov.denis.collectionsandmaps.dto;

public interface CallbackFragment {
    void setError(int error);

    void updateTabRecycleAdaptor(BenchmarkItem benchmarkItem);
    void setProgress(boolean isProgress);
}

