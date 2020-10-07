package ru.navodnikov.denis.collectionsandmaps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyFragment extends Fragment {
    public static final int TYPE_COLLECTIONS = 1;
    public static final int TYPE_MAPS = 2;
    private static final int TYPE_UNKNOWN = -1;

    private static int type = TYPE_UNKNOWN;
    public static final String TYPE_KEY = "type";

    private RecyclerView recyclerView;
    private MyListAdapter listAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listAdapter = new MyListAdapter();

        Bundle bundle = getArguments();
        type = bundle.getInt(TYPE_KEY);
        if(type==TYPE_UNKNOWN){
            throw new IllegalArgumentException("Unknown type");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(listAdapter);
    }
}
