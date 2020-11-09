package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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

public abstract class AbstractFragment extends Fragment {


    public static List<BenchmarkItem> listOfCollectionsOrMaps;
    private final Benchmarked benchmarked;
    private final TabRecycleAdaptor tabRecycleAdaptor = new TabRecycleAdaptor(getActivity(), listOfCollectionsOrMaps);

    private Unbinder unbinder;


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindString(R.string.default_time)
    String defaultTime;

    @Nullable
    @BindView(R.id.edit_text_elements)
    EditText editTextElements;
    @Nullable
    @BindView(R.id.edit_text_threads)
    EditText editTextThreads;

    @Nullable
    @BindView(R.id.start_button)
    ToggleButton startButton;



    public AbstractFragment(Benchmarked benchmarked) {
        this.benchmarked = benchmarked;
        listOfCollectionsOrMaps = benchmarked.getItems();

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.collections_or_maps_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        startButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.d("button", "button pressed");
            if (editTextElements.getText().toString().length() == 0)
                editTextElements.setError(getString(R.string.elements_empty));

            if (editTextThreads.getText().toString().length() == 0)
                editTextThreads.setError(getString(R.string.threads_empty));

            if (editTextElements.getText().toString().length() != 0 && editTextThreads.getText().toString().length() != 0) {
                TabRecycleAdaptor.isWorking = true;
                tabRecycleAdaptor.notifyDataSetChanged();
                int elements = Integer.parseInt(editTextElements.getText().toString());
                int threads = Integer.parseInt(editTextThreads.getText().toString());
                benchmarkedCount(elements, threads);
                TabRecycleAdaptor.isWorking = false;
                tabRecycleAdaptor.notifyDataSetChanged();
            }
        });
        return view;
    }

    public abstract void benchmarkedCount(int elements, int threads);

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), benchmarked.getSpanCount()));
        recyclerView.setAdapter(tabRecycleAdaptor);
    }

    

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
