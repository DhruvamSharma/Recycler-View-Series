package com.dhruvam.recyclerviewseries.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.dhruvam.recyclerviewseries.R;
import com.dhruvam.recyclerviewseries.data.ImageListAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView mMainList;
    ImageListAdapter mListAdapter;

    //Variable to store brightness value
    private int brightness;
    //Content resolver used as a handle to the system's settings
    private ContentResolver cResolver;
    //Window object, that will store a reference to the current window
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if(Settings.System.canWrite(this)) {
//                Settings.System.putInt(getContentResolver(),
//                        Settings.System.SCREEN_BRIGHTNESS,
//                        255);
//            } else {
//                startActivity( new Intent(this, android.settings.action.MANAGE_WRITE_SETTINGS));
//            }
//
//        } else {
//            Settings.System.putInt(getContentResolver(),
//                    Settings.System.SCREEN_BRIGHTNESS,
//                    255);
//        }

        recyclerviewSetup();
    }

    private void recyclerviewSetup() {
        mMainList = findViewById(R.id.main_list);
        mListAdapter = new ImageListAdapter(this);
        mMainList.setAdapter(mListAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        mMainList.setLayoutManager(manager);

        RecyclerView.ItemDecoration itemDecoration = new
                com.dhruvam.recyclerviewseries.data.DividerItemDecoration(getResources().getDrawable(R.drawable.divider));
        //mMainList.addItemDecoration(itemDecoration);
    }
}
