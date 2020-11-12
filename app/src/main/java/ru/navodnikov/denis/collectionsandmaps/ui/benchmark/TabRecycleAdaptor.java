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


    private final List<BenchmarkItem> collectionsOrMapsList = new ArrayList<>();

    public void setCollectionsOrMapsList(List<BenchmarkItem> collectionsOrMapsList) {
        collectionsOrMapsList.addAll(collectionsOrMapsList);
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
            BenchmarkItem benchmarkItem = collectionsOrMapsList.get(position);
            if (benchmarkItem.isProgress()==true){
                holder.getProgressBar().setVisibility(ProgressBar.VISIBLE);
            }
//            if (benchmarkItem.getTime().equals("N/A ms")&&isWorking) {
//                holder.getProgressBar().setVisibility(ProgressBar.VISIBLE);
//            } else {
//                holder.getProgressBar().setVisibility(ProgressBar.INVISIBLE);
//            }
            holder.bindItem(benchmarkItem);

    }

    @Override
    public int getItemCount() {
        return collectionsOrMapsList.size();
    }


}
