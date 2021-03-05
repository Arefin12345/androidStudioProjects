package com.example.sendingdatasecondtofirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("Second Activity");
        Intent intent = getIntent();

        editText = (EditText) findViewById(R.id.editTextTwoId);


        button = findViewById(R.id.buttonSecondId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = editText.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("value",value);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });
    }
}