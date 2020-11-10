package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import butterknife.BindArray;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import butterknife.Unbinder;
import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.core.Benchmarked;
import ru.navodnikov.denis.collectionsandmaps.core.Collections;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;

public class CollectionsFragment extends AbstractFragment {


    public CollectionsFragment(Benchmarked benchmarked) {
        super(benchmarked);
    }

    @Override
    public void benchmarkedCount(int elements, int threads) {
        Collections collections = new Collections();
        ExecutorService threadPool = Executors.newFixedThreadPool(threads);

        for (BenchmarkItem benchmarkItem : listOfCollectionsOrMaps) {
            threadPool.execute(() -> collections.measureTime(benchmarkItem, elements));
        }
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
