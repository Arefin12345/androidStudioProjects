package com.example.reycclerviewharry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.reycclerviewharry.data.MyDbHandler;

public class MainActivity extends AppCompatActivity {
    MyDbHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new MyDbHandler(MainActivity.this);
    }
}