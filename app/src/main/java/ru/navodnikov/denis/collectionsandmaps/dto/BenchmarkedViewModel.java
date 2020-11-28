package ru.navodnikov.denis.collectionsandmaps.dto;


import android.text.TextUtils;

import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import ru.navodnikov.denis.collectionsandmaps.core.Benchmarked;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.Constants;

public class BenchmarkedViewModel extends ViewModel {

    private Benchmarked benchmarked;


    private CallbackFragment callbackFragment;
    private ExecutorService threadPool;
    private final AtomicInteger counter = new AtomicInteger();

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

        if (isChecked) {
            if (TextUtils.isEmpty(elements) && TextUtils.isEmpty(threads)) {
                callbackFragment.setErrorToElements(Constants.ERROR_EMPTY_ELEMENTS);
                callbackFragment.setErrorToThreads(Constants.ERROR_EMPTY_THREADS);
                return;
            }
            if (TextUtils.isEmpty(elements)) {
                callbackFragment.setErrorToElements(Constants.ERROR_EMPTY_ELEMENTS);
                return;
            }

            if (TextUtils.isEmpty(threads)) {
                callbackFragment.setErrorToThreads(Constants.ERROR_EMPTY_THREADS);
                return;
            }

            int elementsCount = Integer.parseInt(elements);
            int threadsCount = Integer.parseInt(threads);

            if (Constants.ZERO == elementsCount && Constants.ZERO == threadsCount) {
                callbackFragment.setErrorToElements(Constants.ERROR_ZERO_ELEMENTS);
                callbackFragment.setErrorToThreads(Constants.ERROR_ZERO_THREADS);
                return;
            }
            if (Constants.ZERO == elementsCount) {
                callbackFragment.setErrorToElements(Constants.ERROR_ZERO_ELEMENTS);
                return;
            }

            if (Constants.ZERO == threadsCount) {
                callbackFragment.setErrorToThreads(Constants.ERROR_ZERO_THREADS);
                return;
            }

            callbackFragment.setProgress(true);
            counter.set(getItems().size());

            threadPool = Executors.newFixedThreadPool(threadsCount);


            for (BenchmarkItem benchmarkItem : getItems()) {
                threadPool.execute(() -> {
                    BenchmarkItem item = measureTime(benchmarkItem, elementsCount);

                    callbackFragment.updateItemInAdaptor(item);
                    counter.addAndGet(-1);
                    if (counter.compareAndSet(0, 0)) {
                        callbackFragment.setProgress(false);
                        callbackFragment.setCheckedButton(false);
                    }
                });

            }
            threadPool.shutdown();

        } else {
            if (threadPool != null || !threadPool.isShutdown() || !threadPool.isTerminated()) {
                threadPool.shutdown();
            }

        }


    }
}


