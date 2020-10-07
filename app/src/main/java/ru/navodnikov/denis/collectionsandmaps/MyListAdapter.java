package ru.navodnikov.denis.collectionsandmaps;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public List<Item> listOfOperations = new ArrayList<>();

//    TODO: временно содаём лист через конструктор
    public MyListAdapter() {
        createOperations();
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
    private void createOperations() {
        listOfOperations.add(new Item("Adding to start in ArrayList", "200"));
        listOfOperations.add(new Item("Adding to start in LinkedList", "200"));
        listOfOperations.add(new Item("Adding to start in CopyOnWriteArrayList", "200"));
        listOfOperations.add(new Item("Adding to middle in ArrayList", "200"));
        listOfOperations.add(new Item("Adding to middle in LinkedList", "200"));
        listOfOperations.add(new Item("Adding to middle in CopyOnWriteArrayList", "200"));
        listOfOperations.add(new Item("Adding to end in ArrayList", "200"));
        listOfOperations.add(new Item("Adding to end in LinkedList", "200"));
        listOfOperations.add(new Item("Adding to end in CopyOnWriteArrayList", "200"));
        listOfOperations.add(new Item("Search in ArrayList", "200"));
        listOfOperations.add(new Item("Search in LinkedList", "200"));
        listOfOperations.add(new Item("Search in CopyOnWriteArrayList", "200"));
        listOfOperations.add(new Item("Removing from start in ArrayList", "200"));
        listOfOperations.add(new Item("Removing from start in LinkedList", "200"));
        listOfOperations.add(new Item("Removing from start in CopyOnWriteArrayList", "200"));
        listOfOperations.add(new Item("Removing from middle in ArrayList", "200"));
        listOfOperations.add(new Item("Removing from middle in LinkedList", "200"));
        listOfOperations.add(new Item("Removing from middle in CopyOnWriteArrayList", "200"));
        listOfOperations.add(new Item("Removing from end in ArrayList", "200"));
        listOfOperations.add(new Item("Removing from end in LinkedList", "200"));
        listOfOperations.add(new Item("Removing from end in CopyOnWriteArrayList", "200"));

    }

}
