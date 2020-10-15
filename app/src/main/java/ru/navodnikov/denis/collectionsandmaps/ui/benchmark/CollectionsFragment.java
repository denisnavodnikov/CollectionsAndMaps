package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import ru.navodnikov.denis.collectionsandmaps.core.Collections;
import ru.navodnikov.denis.collectionsandmaps.dto.Model;

public class CollectionsFragment extends Fragment {

    TabRecycleAdaptor tabRecycleAdaptor;
    public static List<Model> listOfCollections;

    private Unbinder unbinder;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindArray(R.array.names_collections_list)
    String[] namesCollectionsList;
    @BindString(R.string.default_time)
    String defaultTime;

    @Nullable
    @BindView(R.id.collections_edit_text_elements)
    EditText collectionsEditTextElements;
    @Nullable
    @BindView(R.id.collections_edit_text_threads)
    EditText collectionsEditTextThreads;


    public CollectionsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.collections_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listOfCollections = new ArrayList<>();

        for (int i = 0; i < namesCollectionsList.length; i++) {
            Model model = new Model(namesCollectionsList[i], defaultTime);
            listOfCollections.add(model);
        }

        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        tabRecycleAdaptor = new TabRecycleAdaptor(getActivity(), listOfCollections);
        recyclerView.setAdapter(tabRecycleAdaptor);
    }

    @Optional
    @OnClick(R.id.collections_start_button)
    public void onClick() {
        Log.d("button", "button - collections");


        if (collectionsEditTextElements.getText().toString().length() == 0)
            collectionsEditTextElements.setError("Amount of elements must not be empty");

        if (collectionsEditTextThreads.getText().toString().length() == 0)
            collectionsEditTextThreads.setError("Amount of threads must not be empty");

        if (collectionsEditTextElements.getText().toString().length() != 0 && collectionsEditTextThreads.getText().toString().length() != 0) {
        TabRecycleAdaptor.isWorking = true;
        tabRecycleAdaptor.notifyDataSetChanged();
            int elements = Integer.parseInt(collectionsEditTextElements.getText().toString());
            int threads = Integer.parseInt(collectionsEditTextThreads.getText().toString());
            Collections collections = new Collections(elements, threads);
            collections.collectionOperations();
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
