package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.TestSubscriber;
import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.models.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class BenchmarkedViewModelTest {
    private Collections collections;
    private BenchmarkedViewModel viewModel;
    private List<BenchmarkItem> items;
    private CallbackFragment callbackFragment;
    private Disposable disposable = Disposables.disposed();
    private int threadsCount = 3;
    private int elementsCount = 100000;


    @Before
    public void setUp() {
        callbackFragment = mock(CallbackFragment.class);
        collections = new Collections();
        viewModel = new BenchmarkedViewModel(collections);
        items = collections.getItems();
        viewModel.registerCallback(callbackFragment);

    }

    @Rule
    public final RxImmediateSchedulerRule schedulers = new RxImmediateSchedulerRule();

    @Test
    public void onButtonClicked() {

        final Scheduler scheduler = Schedulers.from(Executors.newFixedThreadPool(threadsCount));
        disposable = Observable.fromIterable(items)
                .subscribeOn(scheduler)
                .map(benchmarkItem -> collections.measureTime(benchmarkItem, elementsCount))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(item -> callbackFragment.setProgress(true))
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
    }
}