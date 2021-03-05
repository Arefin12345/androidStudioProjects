package com.example.lottery;
import java.lang.String;
import java.lang.Integer;
import java.util.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Menu extends AppCompatActivity {
    TextView textView;
    private EditText editText1, editText2;
    private Button savebutton1, savebutton2, scanbuttonone1, scanbutton2, checkbutton;

    Boolean result = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //initialize and assign variable;
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //Perform Item Selected Listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.home:
                        return true;

                    case R.id.howto:
                        startActivity(new Intent(getApplicationContext(),   //Ask google
                                HowTo.class));
                        overridePendingTransition(0, 0); //Ask google
                        return true;

                    case R.id.information:
                        startActivity(new Intent(getApplicationContext(),   //Ask google
                                info.class));
                        overridePendingTransition(0, 0); //Ask google
                        return true;
                }
                return false;
            }
        });

        textView = (TextView) findViewById(R.id.textViewTwoId);

        editText1 = (EditText) findViewById(R.id.editTextone);
        editText2 = (EditText) findViewById(R.id.editTextTwo);
        savebutton1 = (Button) findViewById(R.id.savebuttononeid);
        checkbutton = (Button) findViewById(R.id.checkbuttonid);



//        savebutton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });

        checkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumbers();
            }
        });
    }

    private void showNumbers() {
        editText1.setInputType(InputType.TYPE_CLASS_TEXT);
        String test = editText1.getText().toString();
        String[] integerStrings1 = test.split(",");
        int[] integers1 = new int[integerStrings1.length];

        for (int i = 0; i < integers1.length; i++) {
            integers1[i] = Integer.parseInt(integerStrings1[i].toString());
        }

        editText2.setInputType(InputType.TYPE_CLASS_TEXT);
        String test2 = editText2.getText().toString();
        String[] integerStrings2 = test2.split(",");
        int[] integers2 = new int[integerStrings2.length];

        for (int i = 0; i < integers2.length; i++) {
            integers2[i] = Integer.parseInt(integerStrings2[i].toString());
        }



        for (int i = 0; i < integers1.length; i++) {
            for (int j = 0; j < integers2.length; j++) {
                if(integers1[i]==integers2[j]){
                    result = true;
                    break;
                }
            }
        }
        if(result){
            Toast.makeText(this, "Match Found", Toast.LENGTH_SHORT).show();
            result = false;
        }
        else{
            Toast.makeText(this, "No Match Found", Toast.LENGTH_SHORT).show();
        }

        editText1.setText("");
        editText2.setText("");
    }
}


