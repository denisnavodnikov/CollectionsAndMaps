package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

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
    private final String[] namesOfOperations;

    public BenchmarkItemViewHolder(@NonNull View itemView, int idOfNames) {
        super(itemView);
        nameOfOperations = itemView.findViewById(R.id.name_of_operation);
        timeOfOperation = itemView.findViewById(R.id.time_of_operation);
        progressBar = itemView.findViewById(R.id.progressBar);
        namesOfOperations = BenchmarkApp.getContext().getResources().getStringArray(idOfNames);
    }

    public void bindItem(BenchmarkItem item) {
        nameOfOperations.setText(namesOfOperations[item.getNumberOfOperations()]);

        if (item.getTime() > -1) {
            timeOfOperation.setText(BenchmarkApp.getContext().getResources().getString(R.string.result, item.getTime()));
        } else {
            timeOfOperation.setText(BenchmarkApp.getContext().getResources().getString(R.string.default_time));
        }
        progressBar.animate().alpha(item.isProgress() ? 1f : 0f).start();
    }
}
