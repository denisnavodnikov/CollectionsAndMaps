package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;

public class TabRecycleAdapter extends RecyclerView.Adapter<BenchmarkItemViewHolder> {

    private final List<BenchmarkItem> items = new ArrayList<>();

    public TabRecycleAdapter() {
    }

    public void setItems(List<BenchmarkItem> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BenchmarkItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int idOfNames = 0;
        if (items.size() == 21) {
            idOfNames = R.array.names_collections_list;
        } else {
            idOfNames = R.array.names_maps_list;
        }

        return new BenchmarkItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collections_and_maps, parent, false), idOfNames);
    }

    @Override
    public void onBindViewHolder(@NonNull BenchmarkItemViewHolder holder, int position) {
        holder.bindItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateItem(BenchmarkItem benchmarkItem) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getNumberOfOperations() == benchmarkItem.getNumberOfOperations()) {
                items.set(i, benchmarkItem);
                notifyItemChanged(i);
            }
        }
    }

    public void setProgressBar(boolean isProgress) {
        for (int i = 0; i < items.size(); i++) {
            BenchmarkItem benchmarkItem = items.get(i);
            benchmarkItem.setProgress(isProgress);
            items.set(i, benchmarkItem);
        }
        notifyDataSetChanged();
    }
}
