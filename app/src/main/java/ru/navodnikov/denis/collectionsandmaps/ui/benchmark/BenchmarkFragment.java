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

public class BenchmarkFragment extends Fragment implements CompoundButton.OnCheckedChangeListener, CallbackFragment {
    private static final String POSITION = "position";

    private final TabRecycleAdaptor tabRecycleAdaptor = new TabRecycleAdaptor();
    private final Handler modelHandler = new Handler(Looper.getMainLooper());

    private BenchmarkedViewModel model;
    private int position;
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

    public static Fragment newInstance(int position) {
        final BenchmarkFragment fragment = new BenchmarkFragment();
        final Bundle args = new Bundle();
        args.putInt(POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    public BenchmarkFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Bundle bundle = this.getArguments();
        if (bundle != null) {
            position = bundle.getInt(POSITION);
        }

        model = ViewModelProviders.of(this, new BenchmarkedModelFactory(position))
                .get(BenchmarkedViewModel.class);
        model.registerCallback(this);
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
    public void setErrorToElements(int error) {
        editTextElements.setError(getString(error));
    }

    @Override
    public void setErrorToThreads(int error) {
        editTextThreads.setError(getString(error));
    }

    @Override
    public void setCheckedButton(boolean isChecked) {
        modelHandler.post(() -> startButton.setChecked(isChecked));
    }

    @Override
    public void updateItemInAdaptor(BenchmarkItem benchmarkItem) {
        modelHandler.post(() -> tabRecycleAdaptor.updateItem(benchmarkItem));
    }

    @Override
    public void setProgress(boolean isProgress) {
        modelHandler.post(() -> tabRecycleAdaptor.setProgressBar(isProgress));
    }
}
