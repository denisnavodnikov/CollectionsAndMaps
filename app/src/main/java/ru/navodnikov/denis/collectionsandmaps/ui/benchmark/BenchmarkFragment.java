package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
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

    private final TabRecycleAdapter tabRecycleAdapter = new TabRecycleAdapter();
    private BenchmarkedViewModel model;
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
        int position = 0;
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
        tabRecycleAdapter.setItems(model.getItems());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), model.getSpanCount()));

        recyclerView.setAdapter(tabRecycleAdapter);

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
        startButton.setChecked(isChecked);
    }

    @Override
    public void updateItemInAdaptor(BenchmarkItem benchmarkItem) {
        tabRecycleAdapter.updateItem(benchmarkItem);
    }

    @Override
    public void setProgress(boolean isProgress) {
        tabRecycleAdapter.setProgressBar(isProgress);
    }

    @Override
    public void showMessage(int message) {
        Toast.makeText(getActivity(), getActivity().getString(message), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setDefaultTime() {
        tabRecycleAdapter.setItems(model.getItems());
    }

    @Override
    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editTextThreads.getWindowToken(), 0);
    }

}
