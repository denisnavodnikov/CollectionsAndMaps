package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.core.Benchmarked;
import ru.navodnikov.denis.collectionsandmaps.core.Collections;
import ru.navodnikov.denis.collectionsandmaps.core.Maps;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkedModelFactory;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkedViewModel;
import ru.navodnikov.denis.collectionsandmaps.ui.MainPageAdapter;

public abstract class AbstractFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    private final TabRecycleAdaptor tabRecycleAdaptor = new TabRecycleAdaptor();
    private int position;
    private BenchmarkedViewModel model;
    private BenchmarkedModelFactory benchmarkedModelFactory;


    private Unbinder unbinder;


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Nullable
    @BindView(R.id.edit_text_elements)
    EditText editTextElements;
    @Nullable
    @BindView(R.id.edit_text_threads)
    EditText editTextThreads;

    @Nullable
    @BindView(R.id.start_button)
    ToggleButton startButton;


    public AbstractFragment() {
    }

    public static Fragment newInstance(int position) {
        if (position == 0) {
            AbstractFragment collectionsFragment = new CollectionsFragment();
            Bundle args = new Bundle();
            args.putInt("position", Pages.PAGE_COLLECTIONS);
            collectionsFragment.setArguments(args);
            return collectionsFragment;
        } else if (position == 1) {
            AbstractFragment mapsFragment = new MapsFragment();
            Bundle args = new Bundle();
            args.putInt("position", Pages.PAGE_MAPS);
            mapsFragment.setArguments(args);
            return mapsFragment;
        }
        return new CollectionsFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.collections_or_maps_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            position = bundle.getInt("position");
        }
        if (position == Pages.PAGE_COLLECTIONS) {
            benchmarkedModelFactory = new BenchmarkedModelFactory(Pages.PAGE_COLLECTIONS);
        } else if (position == Pages.PAGE_MAPS) {
            benchmarkedModelFactory = new BenchmarkedModelFactory(Pages.PAGE_MAPS);
        }

        model = ViewModelProviders.of(getActivity(), benchmarkedModelFactory)
                .get(BenchmarkedViewModel.class);


        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabRecycleAdaptor.setItems(model.getBenchmarked().getItems());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), model.getBenchmarked().getSpanCount()));

        recyclerView.setAdapter(tabRecycleAdaptor);

        startButton.setOnCheckedChangeListener(this);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Log.d("button", "button pressed");
        String elements = editTextElements.getText().toString();
        String threads = editTextThreads.getText().toString();
        if (TextUtils.isEmpty(elements)) {
            editTextElements.setError(getString(R.string.elements_empty));
        }

        if (TextUtils.isEmpty(threads)) {
            editTextThreads.setError(getString(R.string.threads_empty));
        }

        if (!TextUtils.isEmpty(elements) && !TextUtils.isEmpty(threads)) {

            int elementsCount = Integer.parseInt(elements);
            int threadsCount = Integer.parseInt(threads);
            ExecutorService threadPool = Executors.newFixedThreadPool(threadsCount);

            for (BenchmarkItem benchmarkItem : model.getBenchmarked().getItems()) {
                threadPool.execute(() -> model.getBenchmarked().measureTime(benchmarkItem, elementsCount));
            }
            threadPool.shutdown();
            try {
                threadPool.awaitTermination(20, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tabRecycleAdaptor.notifyDataSetChanged();
        }
    }
}
