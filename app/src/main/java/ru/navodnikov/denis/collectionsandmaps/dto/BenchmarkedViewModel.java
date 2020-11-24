package ru.navodnikov.denis.collectionsandmaps.dto;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.core.Benchmarked;
import ru.navodnikov.denis.collectionsandmaps.ui.AppContext;

public class BenchmarkedViewModel extends ViewModel {

    private String error;
    private Benchmarked benchmarked;
    private Handler modelHandler = new Handler(Looper.getMainLooper());

    public interface CallbackFragment {
        void setError(String error);

        void updateAdapter(boolean isProgress, BenchmarkItem benchmarkItem);
    }

    private CallbackFragment callbackFragment;

    public void registerCallback(CallbackFragment callbackFragment) {
        this.callbackFragment = callbackFragment;
    }

    public BenchmarkedViewModel(Benchmarked benchmarked) {
        this.benchmarked = benchmarked;
    }

    public List<BenchmarkItem> getItems() {
        return benchmarked.getItems();
    }

    public int getSpanCount() {
        return benchmarked.getSpanCount();
    }

    public BenchmarkItem measureTime(BenchmarkItem benchmarkItem, int elementsCount) {
        return benchmarked.measureTime(benchmarkItem, elementsCount);
    }

    public void onButtonClicked(String elements, String threads, boolean isChecked) {

        if (TextUtils.isEmpty(elements) || elements.equals("0")) {
            error = AppContext.getContext().getString(R.string.elements_empty);
            callbackFragment.setError(error);
        }

        if (TextUtils.isEmpty(threads) || threads.equals("0")) {
            error = AppContext.getContext().getString(R.string.threads_empty);
            callbackFragment.setError(error);
        }

        AtomicInteger counter = new AtomicInteger(getItems().size());

        if (!TextUtils.isEmpty(elements) && !TextUtils.isEmpty(threads) && !elements.equals("0") && !threads.equals("0") && isChecked) {

            int elementsCount = Integer.parseInt(elements);
            int threadsCount = Integer.parseInt(threads);

            for (BenchmarkItem benchmarkItem : getItems()) {
                benchmarkItem.setProgress(true);
            }

            ExecutorService threadPool = Executors.newFixedThreadPool(threadsCount);

            for (BenchmarkItem benchmarkItem : getItems()) {

                threadPool.execute(() -> {
                    BenchmarkItem item = measureTime(benchmarkItem, elementsCount);
                    modelHandler.post(() -> callbackFragment.updateAdapter(false, item));
                    counter.addAndGet(-1);
                    if (counter.equals(0)) {
//                        modelHandler.post(() -> );

                    }
                });

            }

            threadPool.shutdown();


        }
    }
}


