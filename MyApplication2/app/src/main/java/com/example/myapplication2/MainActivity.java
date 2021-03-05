package com.example.myapplication2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void sendnow(View view){
        Toast.makeText(this,"sending data from app.",Toast.LENGTH_SHORT).show();

    }

    public void receivenow(View view){
        Toast.makeText(this,"receiving data from app.",Toast.LENGTH_SHORT).show();

    }

    public void deletenow(View view){
        Toast.makeText(this,"deleting data from app.",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
