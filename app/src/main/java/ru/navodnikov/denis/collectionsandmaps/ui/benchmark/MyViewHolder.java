package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.Model;

public class MyViewHolder extends RecyclerView.ViewHolder {

    private final TextView timeOfOperation;
    private final TextView nameOfOperations;
    private final ProgressBar progressBarId;

    public MyViewHolder(@NonNull View itemView, TextView timeOfOperation, TextView nameOfOperations, ProgressBar progressBarId) {
        super(itemView);
        this.timeOfOperation = timeOfOperation;
        this.nameOfOperations = nameOfOperations;
        this.progressBarId = progressBarId;
    }

    public ProgressBar getProgressBarId() {
        return progressBarId;
    }

    public TextView getTimeOfOperation() {
        return timeOfOperation;
    }

    public TextView getNameOfOperations() {
        return nameOfOperations;
    }


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nameOfOperations = itemView.findViewById(R.id.name_of_operation);
        timeOfOperation = itemView.findViewById(R.id.time_of_operation);
        progressBarId = itemView.findViewById(R.id.progressBar);
    }

    public void bindItem(Model item) {
        nameOfOperations.setText(item.getTitle());
        timeOfOperation.setText(String.valueOf(item.getTime()));
    }
}
