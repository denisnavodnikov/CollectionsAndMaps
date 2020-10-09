package ru.navodnikov.denis.collectionsandmaps;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public static List<Model> listOfCollections = new ArrayList<>();
    public static List<Model> listOfMaps = new ArrayList<>();


    //    TODO: временно содаём лист через конструктор
    public MyListAdapter() {
        createCollections();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collections_and_maps, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model model = listOfCollections.get(position);
        holder.applyData(model);
    }

    @Override
    public int getItemCount() {
        return listOfCollections.size();
    }

    private void createCollections() {
        listOfCollections.add(new Model("Adding to start in ArrayList", "N/A ms"));
        listOfCollections.add(new Model("Adding to start in LinkedList", "N/A ms"));
        listOfCollections.add(new Model("Adding to start in CopyOnWriteArrayList", "N/A ms"));
        listOfCollections.add(new Model("Adding to middle in ArrayList", "N/A ms"));
        listOfCollections.add(new Model("Adding to middle in LinkedList", "N/A ms"));
        listOfCollections.add(new Model("Adding to middle in CopyOnWriteArrayList", "N/A ms"));
        listOfCollections.add(new Model("Adding to end in ArrayList", "N/A ms"));
        listOfCollections.add(new Model("Adding to end in LinkedList", "N/A ms"));
        listOfCollections.add(new Model("Adding to end in CopyOnWriteArrayList", "N/A ms"));
        listOfCollections.add(new Model("Search in ArrayList", "N/A ms"));
        listOfCollections.add(new Model("Search in LinkedList", "N/A ms"));
        listOfCollections.add(new Model("Search in CopyOnWriteArrayList", "N/A ms"));
        listOfCollections.add(new Model("Removing from start in ArrayList", "N/A ms"));
        listOfCollections.add(new Model("Removing from start in LinkedList", "N/A ms"));
        listOfCollections.add(new Model("Removing from start in CopyOnWriteArrayList", "N/A ms"));
        listOfCollections.add(new Model("Removing from middle in ArrayList", "N/A ms"));
        listOfCollections.add(new Model("Removing from middle in LinkedList", "N/A ms"));
        listOfCollections.add(new Model("Removing from middle in CopyOnWriteArrayList", "N/A ms"));
        listOfCollections.add(new Model("Removing from end in ArrayList", "N/A ms"));
        listOfCollections.add(new Model("Removing from end in LinkedList", "N/A ms"));
        listOfCollections.add(new Model("Removing from end in CopyOnWriteArrayList", "N/A ms"));

    }

    private void createMaps() {
        listOfMaps.add(new Model("Adding to HashMap", "N/A ms"));
        listOfMaps.add(new Model("Adding to TreeMap", "N/A ms"));
        listOfMaps.add(new Model("Search in HashMap", "N/A ms"));
        listOfMaps.add(new Model("Search in TreeMap", "N/A ms"));
        listOfMaps.add(new Model("Removing from HashMap", "N/A ms"));
        listOfMaps.add(new Model("Removing from TreeMap", "N/A ms"));


    }

}
