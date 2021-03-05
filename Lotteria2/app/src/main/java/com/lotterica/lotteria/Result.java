package com.lotterica.lotteria;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Result extends AppCompatActivity {



    String value;
    String value2;
    boolean result = false;
    EditText editText1, editText2;
    TextView textView;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        listView = findViewById(R.id.listViewIdresult);
        ArrayList<Integer> numbers = (ArrayList<Integer>)getIntent().getSerializableExtra("key");

        ArrayAdapter <Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,numbers);
        listView.setAdapter(adapter);
    }
}