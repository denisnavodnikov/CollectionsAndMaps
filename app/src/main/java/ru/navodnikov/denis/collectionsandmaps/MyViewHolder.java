package ru.navodnikov.denis.collectionsandmaps;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {


    private final TextView timeOfOperation;
    private final TextView nameOfOperations;
    private final ProgressBar progressBarId;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nameOfOperations = itemView.findViewById(R.id.name_of_operation);
        timeOfOperation = itemView.findViewById(R.id.time_of_operation);
        progressBarId = itemView.findViewById(R.id.progressBar);
    }
    public void applyData(Model item){
        nameOfOperations.setText(item.getTitle());
        timeOfOperation.setText(String.valueOf(item.getTime()));

    }
}
