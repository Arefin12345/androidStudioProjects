package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText1,editText2;
    private Button addButton,subButton;
    private TextView resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.edit_text1);
        editText2 = (EditText) findViewById(R.id.edit_text2);

        addButton = (Button) findViewById(R.id.button);
        subButton = (Button) findViewById(R.id.button2);

        resultText = (TextView) findViewById(R.id.sum);


        addButton.setOnClickListener(this);
        subButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
    String number1 = editText1.getText().toString();
    String number2 = editText2.getText().toString();

    //converting to double
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);

        if(v.getId() == R.id.button){
            double sum = num1+num2;
            resultText.setText("Result : "+sum);

        }

        if(v.getId() == R.id.button){
            if(num1<num2){
                double sum = num2-num1;
                resultText.setText("Result : "+sum);
            }

            if(num1>num2){
                double sum = num1-num2;
                resultText.setText("Result : "+sum);
            }
        }

    }
}
