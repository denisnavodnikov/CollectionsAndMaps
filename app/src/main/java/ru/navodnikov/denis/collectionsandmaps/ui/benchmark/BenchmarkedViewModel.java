package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.schedulers.Schedulers;
import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.dto.Constants;
import ru.navodnikov.denis.collectionsandmaps.models.Benchmarked;

public class BenchmarkedViewModel extends ViewModel {

    private final Benchmarked benchmarked;
    private CallbackFragment callbackFragment;
    private Disposable disposable = Disposables.disposed();

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


    @SuppressLint("CheckResult")
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

            final List<BenchmarkItem> items = benchmarked.getItems();
            final Scheduler scheduler = Schedulers.from(Executors.newFixedThreadPool(threadsCount));

            disposable = Observable.fromIterable(items)
                    .subscribeOn(scheduler)
                    .map(benchmarkItem -> benchmarked.measureTime(benchmarkItem, elementsCount))
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(item -> {
                        callbackFragment.setProgress(true);
                        callbackFragment.hideKeyboard();
                    })
                    .doOnComplete(() -> callbackFragment.showMessage(R.string.calculation_is_finished))
                    .doFinally(() -> {
                        callbackFragment.setProgress(false);
                        callbackFragment.setCheckedButton(false);
                    })
                    .doOnDispose(() -> {
                        callbackFragment.showMessage(R.string.calculation_is_stopped);
                        callbackFragment.setDefaultTime();
                    })
                    .subscribe(benchmarkItem -> callbackFragment.updateItemInAdaptor(benchmarkItem));
        } else if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}


