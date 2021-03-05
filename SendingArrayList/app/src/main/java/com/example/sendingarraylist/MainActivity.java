package com.example.sendingarraylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;
    ArrayList<Integer> numbers = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.sendButtonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers.add(1);
                numbers.add(2);
                numbers.add(3);
                numbers.add(4);
                numbers.add(5);
                Intent intent = new Intent(MainActivity.this, ReceiveList.class);
                intent.putExtra("key", numbers);
                startActivity(intent);
            }
        });
    }
}