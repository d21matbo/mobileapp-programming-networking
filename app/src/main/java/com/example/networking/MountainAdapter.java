package com.example.networking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MountainAdapter extends RecyclerView.Adapter<MountainAdapter.MountainAdapterViewHolder> {

    private List<String> mountains;

    public MountainAdapter(List<String> mountains) {
        this.mountains = mountains;
    }

    @NonNull
    @Override
    public MountainAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MountainAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MountainAdapterViewHolder holder, int position) {
        holder.mountainName.setText(mountains.get(position));
    }

    @Override
    public int getItemCount() {
        return mountains.size();
    }

    public class MountainAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView mountainName;

        public MountainAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            mountainName = itemView.findViewById(R.id.mountain_name);
        }
    }
}
