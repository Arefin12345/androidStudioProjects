package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         editText1 = findViewById(R.id.edidTextId);
         editText2 = findViewById(R.id.edidTextId);
        Button button = findViewById(R.id.doneButtonId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumbers();
            }
        });
    }


    private void showNumbers() {
        String value = editText1.getText().toString();

        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("value",value);
        startActivity(intent);
        editText1.setText("");

        String value2 = editText1.getText().toString();
        Intent intent2 = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("value2",value2);
        startActivity(intent2);
        editText2.setText("");
    }
}

