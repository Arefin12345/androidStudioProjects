package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageViewbart,imageViewHomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewbart = findViewById(R.id.imageViewbartid);
        imageViewHomer = findViewById(R.id.imageViewHomerId);

         imageViewbart.setX(-1000);
        imageViewbart.animate().translationXBy(1000).rotation(3600).setDuration(2000);
        imageViewbart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewbart.animate().scaleX(0.5f).scaleY(0.5f).setDuration(1000);

//                imageViewbart.animate().alpha(0).setDuration(1000);
//                imageViewbart.animate().translationYBy(-2000).setDuration(1000);
//                imageViewbart.animate().translationYBy(4000).setDuration(1000);
//                imageViewHomer.animate().alpha(1).setDuration(3000);
            }
        });

    }
}