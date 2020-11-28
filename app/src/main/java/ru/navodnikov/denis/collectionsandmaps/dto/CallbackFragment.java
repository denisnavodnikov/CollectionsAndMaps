package ru.navodnikov.denis.collectionsandmaps.dto;

public interface CallbackFragment {
    void setErrorToElements(int error);

    void setErrorToThreads(int error);

    void setCheckedButton(boolean isChecked);

    void updateItemInAdaptor(BenchmarkItem benchmarkItem);

    void setProgress(boolean isProgress);
}

