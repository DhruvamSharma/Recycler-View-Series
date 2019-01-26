package com.dhruvam.recyclerviewseries.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dhruvam.recyclerviewseries.R;
import com.dhruvam.recyclerviewseries.data.ImageListAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView mMainList;
    ImageListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerviewSetup();
    }


    private void recyclerviewSetup() {
        mMainList = findViewById(R.id.main_list);
        mListAdapter = new ImageListAdapter();
        mMainList.setAdapter(mListAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        mMainList.setLayoutManager(manager);

        RecyclerView.ItemDecoration itemDecoration = new
                com.dhruvam.recyclerviewseries.data.DividerItemDecoration(getResources().getDrawable(R.drawable.divider));
        //mMainList.addItemDecoration(itemDecoration);
    }
}
