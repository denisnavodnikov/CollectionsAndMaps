package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

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
import ru.navodnikov.denis.collectionsandmaps.dto.Model;

public class MapsFragment extends Fragment {

    TabRecycleAdaptor tabRecycleAdaptor;
    public static List<Model> listOfMaps;

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
            Model model = new Model(namesMapsList[i], defaultTime);
            listOfMaps.add(model);
        }

        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
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
            mapsEditTextElements.setError("Amount of elements must not be empty");

        if (mapsEditTextThreads.getText().toString().length() == 0)
            mapsEditTextThreads.setError("Amount of threads must not be empty");

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
