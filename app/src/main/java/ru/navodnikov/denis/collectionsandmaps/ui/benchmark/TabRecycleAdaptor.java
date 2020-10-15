package ru.navodnikov.denis.collectionsandmaps.ui.benchmark;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.navodnikov.denis.collectionsandmaps.R;
import ru.navodnikov.denis.collectionsandmaps.dto.Model;

public class TabRecycleAdaptor extends RecyclerView.Adapter<MyViewHolder> {

    public static boolean isWorking = false;
    private Context context;
    private List<Model> CollectionsOrMapsList;

    public TabRecycleAdaptor(Context context, List<Model> collectionsOrMapsList) {
        this.context = context;
        this.CollectionsOrMapsList = collectionsOrMapsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_collections_and_maps, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (holder != null) {
            Model model = CollectionsOrMapsList.get(position);
            if (model.getTime().equals("N/A ms")&&isWorking) {
                holder.getProgressBarId().setVisibility(ProgressBar.VISIBLE);

            } else {
                holder.getProgressBarId().setVisibility(ProgressBar.INVISIBLE);

            }
            holder.bindItem(model);
        }


    }

    @Override
    public int getItemCount() {
        return CollectionsOrMapsList.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
