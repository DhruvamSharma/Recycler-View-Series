package com.dhruvam.recyclerviewseries.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.widget.ImageView;

import com.dhruvam.recyclerviewseries.R;

public class RewardDetail extends AppCompatActivity {

    ImageView reward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_detail);

        reward = findViewById(R.id.starbucks_reward_image_iv);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.shared_reward_transition));
            reward.setTransitionName("rewardTransition");
        }
    }
}
