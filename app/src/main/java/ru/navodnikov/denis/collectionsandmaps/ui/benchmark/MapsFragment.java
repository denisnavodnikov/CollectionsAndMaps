package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import butterknife.Unbinder;
import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.core.Maps;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;

public class MapsFragment extends Fragment {

    private TabRecycleAdaptor tabRecycleAdaptor;
    public static List<BenchmarkItem> listOfMaps;

    private Unbinder unbinder;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindArray(R.array.names_maps_list)
    String[] namesMapsList;
    @BindString(R.string.default_time)
    String defaultTime;

    @Nullable
    @BindView(R.id.maps_edit_text_elements)
    EditText mapsEditTextElements;
    @Nullable
    @BindView(R.id.maps_edit_text_threads)
    EditText mapsEditTextThreads;

    @Nullable
    @BindView(R.id.maps_start_button)
    Button mapsStartButton;


    public MapsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.maps_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        listOfMaps = new ArrayList<>();


        for (int i = 0; i < namesMapsList.length; i++) {
            BenchmarkItem benchmarkItem = new BenchmarkItem(namesMapsList[i], defaultTime);
            listOfMaps.add(benchmarkItem);
        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        tabRecycleAdaptor = new TabRecycleAdaptor(getActivity(), listOfMaps);
        recyclerView.setAdapter(tabRecycleAdaptor);

        return view;
    }

    @Optional
    @OnClick(R.id.maps_start_button)
    public void onClick() {
        Log.d("button", "button - collections");
        TabRecycleAdaptor.isWorking = true;


        if (mapsEditTextElements.getText().toString().length() == 0)
            mapsEditTextElements.setError(getString(R.string.elements_empty));

        if (mapsEditTextThreads.getText().toString().length() == 0)
            mapsEditTextThreads.setError(getString(R.string.threads_empty));

        if (mapsEditTextElements.getText().toString().length() != 0 && mapsEditTextThreads.getText().toString().length() != 0) {
            TabRecycleAdaptor.isWorking = true;
            tabRecycleAdaptor.notifyDataSetChanged();
            int elements = Integer.parseInt(mapsEditTextElements.getText().toString());
            int threads = Integer.parseInt(mapsEditTextThreads.getText().toString());
            Maps maps = new Maps(elements, threads);
            maps.mapsOperations();
            TabRecycleAdaptor.isWorking = false;
            tabRecycleAdaptor.notifyDataSetChanged();
        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
