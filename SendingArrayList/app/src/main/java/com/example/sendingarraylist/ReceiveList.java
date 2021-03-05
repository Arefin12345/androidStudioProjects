package com.example.sendingarraylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.AllocationAdapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReceiveList extends AppCompatActivity {
    ListView listView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_list);

        listView = findViewById(R.id.listViewId);
        ArrayList<Integer> numbers = (ArrayList<Integer>)getIntent().getSerializableExtra("key");

        ArrayAdapter <Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,numbers);
        listView.setAdapter(adapter);

//        textView = findViewById(R.i.textVieid);
//
//        textView.setText(String.valueOf(numbers));

    }

}