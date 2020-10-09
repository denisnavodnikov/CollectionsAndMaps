package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.Model;

public class MapsFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindArray(R.array.names_maps_list)
    String[] namesMapsList;
    @BindString(R.string.default_time)
    String defaultTime;


    public MapsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items, container, false);
        ButterKnife.bind(this, view);
        List<Model> listOfMaps = new ArrayList<>();


//        for (int i = 0; i < namesMapsList.length; i++) {
//            Model model = new Model(namesMapsList[i], defaultTime);
//            listOfMaps.add(model);
//        }
//
//        recyclerView.setHasFixedSize(true);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        TabRecycleAdaptor tabRecycleAdaptor = new TabRecycleAdaptor(getActivity(), listOfMaps);
//        recyclerView.setAdapter(tabRecycleAdaptor);

        return view;
    }
}
