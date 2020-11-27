package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

        nameOfOperations.setText(item.getTitle());
        timeOfOperation.setText(String.valueOf(item.getTime()));

        float alphaConst = (item.isProgress()) ? 1f : 0f;
        progressBar.animate().alpha(alphaConst).start();

    }
}
