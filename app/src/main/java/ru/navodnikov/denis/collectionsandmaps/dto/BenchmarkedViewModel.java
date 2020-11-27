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

    private AtomicInteger counter;
    private CallbackFragment callbackFragment;
    private ExecutorService threadPool;

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
            if (TextUtils.isEmpty(elements) || elements.equals(Constants.ZERO)) {
                callbackFragment.setError(Constants.ERROR_EMPTY_ELEMENTS);
                return;
            }

            if (TextUtils.isEmpty(threads) || threads.equals(Constants.ZERO)) {
                callbackFragment.setError(Constants.ERROR_EMPTY_THREADS);
                return;
            }

            int elementsCount = Integer.parseInt(elements);
            int threadsCount = Integer.parseInt(threads);

            if (elementsCount == Constants.ZERO) {
                callbackFragment.setError(Constants.ERROR_ZERO_ELEMENTS);
                return;
            }

            if (threadsCount == Constants.ZERO) {
                callbackFragment.setError(Constants.ERROR_ZERO_THREADS);
                return;
            }

            callbackFragment.setProgress(true);

            threadPool = Executors.newFixedThreadPool(threadsCount);
            counter = new AtomicInteger(getItems().size());

            for (BenchmarkItem benchmarkItem : getItems()) {
                threadPool.execute(() -> {
                    BenchmarkItem item = measureTime(benchmarkItem, elementsCount);

                  callbackFragment.updateTabRecycleAdaptor(item);
                    counter.addAndGet(-1);
                    if (counter.compareAndSet(0,0)) {
                        callbackFragment.setProgress(false);
                    }
                });

            }
            threadPool.shutdown();

        }else if (!threadPool.isShutdown()) {
            threadPool.shutdown();
        }


    }
}


