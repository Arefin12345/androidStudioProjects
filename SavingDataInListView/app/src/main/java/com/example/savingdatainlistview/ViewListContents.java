package com.example.savingdatainlistview;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewListContents extends AppCompatActivity {
    DatabaseHelper mydb;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents);

        ListView listView = (ListView) findViewById(R.id.listviewcontentId);
        mydb = new DatabaseHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = mydb.getListContents();

        if(data.getCount() == 0){
            Toast.makeText(this, "The Database Was Empty :(", Toast.LENGTH_SHORT).show();
        }
        else{
            while(data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);

            }
        }
    }
}
