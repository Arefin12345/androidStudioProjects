package com.example.savingdatainlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


//paste these code to Menu
public class MainActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    Button btnAdd,btnView;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editTextId);
        btnAdd = (Button) findViewById(R.id.buttonAddId);
        btnView = (Button) findViewById(R.id.buttonCheckId);
        mydb = new DatabaseHelper(this);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewListContents.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if(editText.length() != 0){
                    AddData(newEntry);
                    editText.setText("");
                }else{
                    Toast.makeText(MainActivity.this, "You Must Put Something In The Text Field", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AddData(String newEntry) {
        boolean insertData = mydb.addData(newEntry);

        if(insertData == true){
            Toast.makeText(MainActivity.this, "Success !!!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

        }
    }

}