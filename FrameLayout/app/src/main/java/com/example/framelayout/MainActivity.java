package com.example.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView image1,image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = (ImageView) findViewById(R.id.img1);
        image2 = (ImageView) findViewById(R.id.img2);

        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.img1){
            image1.setVisibility(view.GONE);
            image2.setVisibility(view.VISIBLE);
        }

        else if(view.getId()==R.id.img2){
            image1.setVisibility(view.VISIBLE);
            image2.setVisibility(view.GONE);
        }

    }
}
