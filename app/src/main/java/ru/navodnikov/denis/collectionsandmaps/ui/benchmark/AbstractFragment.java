package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkedModelFactory;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkedViewModel;
import ru.navodnikov.denis.collectionsandmaps.dto.CallbackFragment;

public class AbstractFragment extends Fragment implements CompoundButton.OnCheckedChangeListener, CallbackFragment {

    private final TabRecycleAdaptor tabRecycleAdaptor = new TabRecycleAdaptor();
    private int position;
    private BenchmarkedViewModel model;
    private Handler modelHandler = new Handler(Looper.getMainLooper());


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

    public BenchmarkedViewModel getModel() {
        return model;
    }

    public void setModel(BenchmarkedViewModel model) {
        this.model = model;
    }

    public AbstractFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            position = bundle.getInt("position");
        }


        model = ViewModelProviders.of(this, new BenchmarkedModelFactory(position))
                .get(BenchmarkedViewModel.class);
        model.registerCallback(this);
    }

    public static Fragment newInstance(int position) {
        if (position == 0) {
            AbstractFragment collectionsFragment = new AbstractFragment();
            Bundle args = new Bundle();
            args.putInt("position", Constants.PAGE_COLLECTIONS);
            collectionsFragment.setArguments(args);
            return collectionsFragment;
        } else if (position == 1) {
            AbstractFragment mapsFragment = new AbstractFragment();
            Bundle args = new Bundle();
            args.putInt("position", Constants.PAGE_MAPS);
            mapsFragment.setArguments(args);
            return mapsFragment;
        }
        return new AbstractFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.collections_or_maps_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);


        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabRecycleAdaptor.setItems(model.getItems());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), model.getSpanCount()));

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
        model.onButtonClicked(elements, threads, isChecked);


    }


    @Override
    public void setError(int error) {
        if (error == Constants.ERROR_EMPTY_ELEMENTS) {
            editTextElements.setError(getString(R.string.elements_empty));
        }
        if (error == Constants.ERROR_EMPTY_THREADS) {
            editTextThreads.setError(getString(R.string.threads_empty));
        }
        if (error == Constants.ERROR_ZERO_ELEMENTS) {
            editTextElements.setError(getString(R.string.elements_zero));
        }
        if (error == Constants.ERROR_ZERO_THREADS) {
            editTextThreads.setError(getString(R.string.threads_zero));
        }
    }

    @Override
    public void updateTabRecycleAdaptor(BenchmarkItem benchmarkItem) {
        modelHandler.post(() -> tabRecycleAdaptor.updateItem(benchmarkItem));

    }

    @Override
    public void setProgress(boolean isProgress) {
        if (isProgress) {
            tabRecycleAdaptor.setProgressBar(isProgress);
            tabRecycleAdaptor.notifyDataSetChanged();
        } else {
            modelHandler.post(() -> {
                tabRecycleAdaptor.setProgressBar(isProgress);
                startButton.setChecked(false);
            });
        }
    }
}