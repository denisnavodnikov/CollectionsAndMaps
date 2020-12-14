package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.navodnikov.denis.collectionsandmaps.BenchmarkApp;
import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.BenchmarkItem;

public class BenchmarkItemViewHolder extends RecyclerView.ViewHolder {

    private final TextView timeOfOperation;
    private final TextView nameOfOperations;
    private final ProgressBar progressBar;

    public BenchmarkItemViewHolder(@NonNull View itemView) {
        super(itemView);
        nameOfOperations = itemView.findViewById(R.id.name_of_operation);
        timeOfOperation = itemView.findViewById(R.id.time_of_operation);
        progressBar = itemView.findViewById(R.id.progressBar);
    }

    public void bindItem(BenchmarkItem item) {
        Context context = itemView.getContext();
        nameOfOperations.setText(context.getString(R.string.name_of_collections_or_maps, context.getString(item.getIdOfOperations()), context.getString(item.getIdOfCollectionsOrMaps())));

        if (item.getTime() > -1) {
            timeOfOperation.setText(context.getString(R.string.result, item.getTime()));
        } else {
            timeOfOperation.setText(context.getString(R.string.default_time));
        }
        progressBar.animate().alpha(item.isProgress() ? 1f : 0f).start();
    }
}
