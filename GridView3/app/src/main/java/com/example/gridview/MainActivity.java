package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    int flags[] = {R.drawable.afganistan,R.drawable.bangladesh,
            R.drawable.england,
            R.drawable.india,
            R.drawable.pakistan2
    };

    String countrynames[];

    private GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countrynames = getResources().getStringArray(R.array.country_names);

        gridview = (GridView) findViewById(R.id.gridViweId);

//        Creating Adapter
//        CustomAdapter adapter = new CustomAdapter(this,countrynames,flags);
//        gridview.setAdapter(adapter);

    }

}
