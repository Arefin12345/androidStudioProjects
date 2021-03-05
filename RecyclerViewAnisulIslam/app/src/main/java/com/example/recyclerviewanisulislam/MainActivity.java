package com.example.recyclerviewanisulislam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    MyAdapter myAdapter;

    int[] images = {
            R.drawable.fallout,R.drawable.football,R.drawable.hulk,R.drawable.images,
            R.drawable.ironman,R.drawable.simpson
    };
    RecyclerView recyclerView;

    String[] title,desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewmainId);

        //Getting strings-array form xml file
        title = getResources().getStringArray(R.array.names);
        desc = getResources().getStringArray(R.array.names_desc);

        myAdapter = new MyAdapter(this,title,desc,images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}