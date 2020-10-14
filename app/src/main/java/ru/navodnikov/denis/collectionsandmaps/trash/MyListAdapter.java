package ru.navodnikov.denis.collectionsandmaps.trash;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.Model;
import ru.navodnikov.denis.collectionsandmaps.ui.benchmark.MyViewHolder;

public class MyListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public static List<Model> items = new ArrayList<>();

    public MyListAdapter() {
        items.addAll(createCollections());
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collections_and_maps, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private List<Model> createCollections() {
        final List<Model> datas = new ArrayList<>();
        datas.add(new Model("Adding to start in ArrayList", "N/A ms"));
        datas.add(new Model("Adding to start in LinkedList", "N/A ms"));
        datas.add(new Model("Adding to start in CopyOnWriteArrayList", "N/A ms"));
        datas.add(new Model("Adding to middle in ArrayList", "N/A ms"));
        datas.add(new Model("Adding to middle in LinkedList", "N/A ms"));
        datas.add(new Model("Adding to middle in CopyOnWriteArrayList", "N/A ms"));
        datas.add(new Model("Adding to end in ArrayList", "N/A ms"));
        datas.add(new Model("Adding to end in LinkedList", "N/A ms"));
        datas.add(new Model("Adding to end in CopyOnWriteArrayList", "N/A ms"));
        datas.add(new Model("Search in ArrayList", "N/A ms"));
        datas.add(new Model("Search in LinkedList", "N/A ms"));
        datas.add(new Model("Search in CopyOnWriteArrayList", "N/A ms"));
        datas.add(new Model("Removing from start in ArrayList", "N/A ms"));
        datas.add(new Model("Removing from start in LinkedList", "N/A ms"));
        datas.add(new Model("Removing from start in CopyOnWriteArrayList", "N/A ms"));
        datas.add(new Model("Removing from middle in ArrayList", "N/A ms"));
        datas.add(new Model("Removing from middle in LinkedList", "N/A ms"));
        datas.add(new Model("Removing from middle in CopyOnWriteArrayList", "N/A ms"));
        datas.add(new Model("Removing from end in ArrayList", "N/A ms"));
        datas.add(new Model("Removing from end in LinkedList", "N/A ms"));
        datas.add(new Model("Removing from end in CopyOnWriteArrayList", "N/A ms"));
        return datas;

    }

    private List<Model> createMaps() {
        final List<Model> datas = new ArrayList<>();
        datas.add(new Model("Adding to HashMap", "N/A ms"));
        datas.add(new Model("Adding to TreeMap", "N/A ms"));
        datas.add(new Model("Search in HashMap", "N/A ms"));
        datas.add(new Model("Search in TreeMap", "N/A ms"));
        datas.add(new Model("Removing from HashMap", "N/A ms"));
        datas.add(new Model("Removing from TreeMap", "N/A ms"));
        return datas;
    }

}
