package com.example.numberguessing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    EditText editText;
    Button button;

    public void guess(){
        Random rand = new Random();
        randomNumber = rand.nextInt(20)+1;
        String number = editText.getText().toString();

        int guessedNumber = Integer.parseInt(number);

        if(guessedNumber<randomNumber){
            Toast.makeText(MainActivity.this, "Lower", Toast.LENGTH_SHORT).show();

        }else if(guessedNumber>randomNumber){
            Toast.makeText(MainActivity.this, "Opps ! Higher", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, "You Won", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edittextId);
        button = findViewById(R.id.buttonId);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guess();
            }
        });
    }
}