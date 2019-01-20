package com.dhruvam.recyclerviewseries.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhruvam.recyclerviewseries.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageListViewHolder> {

    ArrayList<String> data = new ArrayList<>();

    public ImageListAdapter() {
        for(int i = 0; i< 50 ;i ++) {
            data.add("hello");
        }
    }

    @NonNull
    @Override
    public ImageListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ImageListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListViewHolder holder, int position) {
        holder.listItemText.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ImageListViewHolder extends RecyclerView.ViewHolder{
        TextView listItemText;
        public ImageListViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemText = itemView.findViewById(R.id.list_item_text);
        }
    }
}
