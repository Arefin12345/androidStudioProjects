package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox milk,hotdog;
    private Button button;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        milk = (CheckBox) findViewById(R.id.checkBox1);
        hotdog = (CheckBox) findViewById(R.id.checkBox2);

        button = (Button) findViewById(R.id.btn);
        text = (TextView) findViewById(R.id.resulttext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringbuilder = new StringBuilder();

                if(milk.isChecked()){
                    String res =  milk.getText().toString();
                    stringbuilder.append(res + " is ordered\n");
                }

                if(hotdog.isChecked()){
                    String res =  hotdog.getText().toString();
                    stringbuilder.append(res + " is ordered\n");
                }

                text.setText(stringbuilder);
            }
        });

    }
}
