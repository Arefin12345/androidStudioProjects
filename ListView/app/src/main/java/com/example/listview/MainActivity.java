package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list1);
        final String countrynames[] = getResources().getStringArray(R.array.country_names);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.sample_view,countrynames);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = countrynames[position];

                Toast.makeText(MainActivity.this,value+" "+position,Toast.LENGTH_SHORT).show();
            }
        });


    }
}