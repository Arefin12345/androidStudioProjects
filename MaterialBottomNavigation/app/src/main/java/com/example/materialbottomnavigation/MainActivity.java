package com.example.materialbottomnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;

public class MainActivity extends AppCompatActivity {

    private BottomAppBar mBottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomAppBar = findViewById(R.id.bottom_app_bar);
        setSupportActionBar(mBottomAppBar);

        mBottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

         super.onCreateOptionsMenu(menu);
         getMenuInflater().inflate(R.menu.bottom_app_bar_menu,menu);
         return true;
    }
}