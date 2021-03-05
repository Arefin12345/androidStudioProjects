package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static com.example.guessinggame.R.id.btnid;
import static com.example.guessinggame.R.id.edittextid;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private Button checkbutton;
    private TextView resulttextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(edittextid);
        checkbutton = (Button) findViewById(btnid);
        resulttextview = (TextView) findViewById(R.id.resulttextid);

        checkbutton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        String guessstring = editText.getText().toString();
        int guess = Integer.parseInt(guessstring);

        //Generating Random Number
        Random random =  new Random();
//        random.nextInt(100)

        int randomNumber = random.nextInt(5);
        if(randomNumber==guess){
            resulttextview.setText("Congrats !!! You Have Won ....");
        }
        else{
            resulttextview.setText("Sorry . Random Number Was "+randomNumber);
        }

    }
}
