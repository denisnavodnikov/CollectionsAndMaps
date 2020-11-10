package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;

public class TabRecycleAdaptor extends RecyclerView.Adapter<RecyclerViewHolder> {


    private List<BenchmarkItem> collectionsOrMapsList;

    public void setCollectionsOrMapsList(List<BenchmarkItem> collectionsOrMapsList) {
        this.collectionsOrMapsList = collectionsOrMapsList;
    }

    public TabRecycleAdaptor(List<BenchmarkItem> collectionsOrMapsList) {
        this.collectionsOrMapsList = collectionsOrMapsList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collections_and_maps, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        if (holder != null) {
            BenchmarkItem benchmarkItem = collectionsOrMapsList.get(position);
//            if (benchmarkItem.getTime().equals("N/A ms")&&isWorking) {
//                holder.getProgressBar().setVisibility(ProgressBar.VISIBLE);
//            } else {
//                holder.getProgressBar().setVisibility(ProgressBar.INVISIBLE);
//            }
            holder.bindItem(benchmarkItem);
        }


    }

    @Override
    public int getItemCount() {
        return collectionsOrMapsList.size();
    }


}
