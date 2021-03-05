package com.lotterica.lotteria;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HowTo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to);


        //initialize and assign variable;
        BottomNavigationView bottomNavigationView = findViewById(R.id.howto_navigation);

        //Set howto Selected
        bottomNavigationView.setSelectedItemId(R.id.howto);

        //Perform Item Selected Listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),   //Ask google
                                Menu.class));
                        overridePendingTransition(0, 0); //Ask google
                        return true;

                    case R.id.howto:
                        return true;

                    case R.id.save:
                        startActivity(new Intent(getApplicationContext(),   //Ask google
                                Saved.class));
                        overridePendingTransition(0, 0); //Ask google
                        return true;
                }
                return false;
            }
        });
    }
}