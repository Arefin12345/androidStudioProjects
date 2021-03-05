package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String value;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText1  = findViewById(R.id.editTextTwoId);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){
            value = bundle.getString("value");
            editText1.setText(value);
        }

        ListView listView = findViewById(R.id.listViewId);
        //ArrayList of Java
        ArrayList<Integer> grocery = new ArrayList<>();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SecondActivity.this, "Parent is ", Toast.LENGTH_SHORT).show();
            }
        });

        editText1.setInputType(InputType.TYPE_CLASS_TEXT);
        String test = editText1.getText().toString();
        String[] integerStrings1 = test.split(",");
        int[] integers1 = new int[integerStrings1.length];

        for (int i = 0; i < integers1.length; i++) {
            integers1[i] = Integer.parseInt(integerStrings1[i].toString());
        }

        for (int i = 0; i <integers1.length ; i++) {
            grocery.add(integers1[i]);
        }


        editText1.setText("");
    }

}