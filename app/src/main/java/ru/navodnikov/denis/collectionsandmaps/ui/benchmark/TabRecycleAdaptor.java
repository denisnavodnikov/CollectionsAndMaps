package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;

public class TabRecycleAdaptor extends RecyclerView.Adapter<BenchmarkItemViewHolder> {



    private final List<BenchmarkItem> items = new ArrayList<>();

    public List<BenchmarkItem> getItems() {
        return items;
    }

    public void setItems(List<BenchmarkItem> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public TabRecycleAdaptor() {
    }

    @NonNull
    @Override
    public BenchmarkItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BenchmarkItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collections_and_maps, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BenchmarkItemViewHolder holder, int position) {
            BenchmarkItem benchmarkItem = items.get(position);
            holder.bindItem(benchmarkItem);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
