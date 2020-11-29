package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;


import android.text.TextUtils;

import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.dto.Constants;
import ru.navodnikov.denis.collectionsandmaps.models.Benchmarked;

public class BenchmarkedViewModel extends ViewModel {

    private final Benchmarked benchmarked;

    private CallbackFragment callbackFragment;
    private ExecutorService threadPool;
    private final AtomicInteger counter = new AtomicInteger();

    public BenchmarkedViewModel(Benchmarked benchmarked) {
        this.benchmarked = benchmarked;
    }

    public void registerCallback(CallbackFragment callbackFragment) {
        this.callbackFragment = callbackFragment;
    }

    public List<BenchmarkItem> getItems() {
        return benchmarked.getItems();
    }

    public int getSpanCount() {
        return benchmarked.getSpanCount();
    }


    public void onButtonClicked(String elements, String threads, boolean isChecked) {
        if (isChecked) {
            if (TextUtils.isEmpty(elements)) {
                callbackFragment.setErrorToElements(R.string.elements_empty);
            }
            if (TextUtils.isEmpty(threads)) {
                callbackFragment.setErrorToThreads(R.string.threads_empty);
            }
            if (TextUtils.isEmpty(elements) || TextUtils.isEmpty(threads)) {
                callbackFragment.setCheckedButton(false);
                return;
            }

            final int elementsCount = Integer.parseInt(elements);
            final int threadsCount = Integer.parseInt(threads);

            if (Constants.ZERO == elementsCount) {
                callbackFragment.setErrorToElements(R.string.elements_zero);
            }

            if (Constants.ZERO == threadsCount) {
                callbackFragment.setErrorToThreads(R.string.threads_zero);
            }
            if (Constants.ZERO == elementsCount || Constants.ZERO == threadsCount) {
                callbackFragment.setCheckedButton(false);
                return;
            }

            callbackFragment.setProgress(true);
            counter.set(getItems().size());

            threadPool = Executors.newFixedThreadPool(threadsCount);


            for (BenchmarkItem benchmarkItem : getItems()) {
                threadPool.execute(() -> {

                    callbackFragment.updateItemInAdaptor(benchmarked.measureTime(benchmarkItem, elementsCount));
                    counter.addAndGet(-1);
                    if (counter.compareAndSet(0, 0)) {
                        callbackFragment.setProgress(false);
                        callbackFragment.setCheckedButton(false);
                    }
                });

            }
            threadPool.shutdown();

        } else if (threadPool != null) {
            if (!threadPool.isShutdown() || !threadPool.isTerminated()) {
                threadPool.shutdown();
            }
        }
    }
}


