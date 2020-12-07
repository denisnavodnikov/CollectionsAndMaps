package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;

public interface CallbackFragment {

    void setErrorToElements(int error);

    void setErrorToThreads(int error);

    void setCheckedButton(boolean isChecked);

    void updateItemInAdaptor(BenchmarkItem benchmarkItem);

    void setProgress(boolean isProgress);

    void showMessage(int message);

    void setDefaultTime();
}

