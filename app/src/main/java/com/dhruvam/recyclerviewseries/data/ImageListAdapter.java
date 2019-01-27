package com.dhruvam.recyclerviewseries.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhruvam.recyclerviewseries.R;
import com.dhruvam.recyclerviewseries.ui.RewardDetail;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageListViewHolder> {

    ArrayList<String> data = new ArrayList<>();
    private Context context;

    public ImageListAdapter(Context context) {
        for(int i = 0; i< 2 ;i ++) {
            data.add("hello");
        }
        this.context = context;
    }

    @NonNull
    @Override
    public ImageListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ImageListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListViewHolder holder, int position) {
        if(position%2 == 0) {
            holder.reward.setImageResource(R.drawable.free_drink_mug);
            holder.listItemText.setText(context.getResources().getString(R.string.free_drink_text));
            holder.listItemCaption.setText(context.getResources().getString(R.string.free_drink_caption_text));
        } else {
            holder.reward.setImageResource(R.drawable.size_upgrade_mug);
            holder.listItemText.setText(context.getResources().getString(R.string.size_upgrade_text));
            holder.listItemCaption.setText(context.getResources().getString(R.string.size_upgrade_caption_text));
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ImageListViewHolder extends RecyclerView.ViewHolder{
        TextView listItemText, listItemCaption;
        ImageView reward;
        public ImageListViewHolder(@NonNull final View itemView) {
            super(itemView);
            reward = itemView.findViewById(R.id.list_item_cup_iv);
            listItemText = itemView.findViewById(R.id.list_item_reward_headline_tv);
            listItemCaption = itemView.findViewById(R.id.list_item_reward_caption_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        reward.setTransitionName("heroTransition");
                        Pair<View, String> pair = Pair.create((View) reward, reward.getTransitionName());
                        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, pair);
                        context.startActivity(new Intent(context, RewardDetail.class), optionsCompat.toBundle());
                    }
                }
            });
        }
    }
}
