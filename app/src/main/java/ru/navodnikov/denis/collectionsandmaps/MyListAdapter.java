package ru.navodnikov.denis.collectionsandmaps;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public static List<Item> listOfOperations = new ArrayList<>();

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
        Item record = listOfOperations.get(position);
        holder.applyData(record);
    }

    @Override
    public int getItemCount() {
        return listOfOperations.size();
    }

    private void createCollections() {
        listOfOperations.add(new Item("Adding to start in ArrayList", "N/A ms"));
        listOfOperations.add(new Item("Adding to start in LinkedList", "N/A ms"));
        listOfOperations.add(new Item("Adding to start in CopyOnWriteArrayList", "N/A ms"));
        listOfOperations.add(new Item("Adding to middle in ArrayList", "N/A ms"));
        listOfOperations.add(new Item("Adding to middle in LinkedList", "N/A ms"));
        listOfOperations.add(new Item("Adding to middle in CopyOnWriteArrayList", "N/A ms"));
        listOfOperations.add(new Item("Adding to end in ArrayList", "N/A ms"));
        listOfOperations.add(new Item("Adding to end in LinkedList", "N/A ms"));
        listOfOperations.add(new Item("Adding to end in CopyOnWriteArrayList", "N/A ms"));
        listOfOperations.add(new Item("Search in ArrayList", "N/A ms"));
        listOfOperations.add(new Item("Search in LinkedList", "N/A ms"));
        listOfOperations.add(new Item("Search in CopyOnWriteArrayList", "N/A ms"));
        listOfOperations.add(new Item("Removing from start in ArrayList", "N/A ms"));
        listOfOperations.add(new Item("Removing from start in LinkedList", "N/A ms"));
        listOfOperations.add(new Item("Removing from start in CopyOnWriteArrayList", "N/A ms"));
        listOfOperations.add(new Item("Removing from middle in ArrayList", "N/A ms"));
        listOfOperations.add(new Item("Removing from middle in LinkedList", "N/A ms"));
        listOfOperations.add(new Item("Removing from middle in CopyOnWriteArrayList", "N/A ms"));
        listOfOperations.add(new Item("Removing from end in ArrayList", "N/A ms"));
        listOfOperations.add(new Item("Removing from end in LinkedList", "N/A ms"));
        listOfOperations.add(new Item("Removing from end in CopyOnWriteArrayList", "N/A ms"));

    }

    private void createMaps() {
        listOfOperations.add(new Item("Adding to HashMap", "N/A ms"));
        listOfOperations.add(new Item("Adding to TreeMap", "N/A ms"));
        listOfOperations.add(new Item("Search in HashMap", "N/A ms"));
        listOfOperations.add(new Item("Search in TreeMap", "N/A ms"));
        listOfOperations.add(new Item("Removing from HashMap", "N/A ms"));
        listOfOperations.add(new Item("Removing from TreeMap", "N/A ms"));


    }

}
