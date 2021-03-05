package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.imageview.R.layout.customtoastlayout;

//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public class MainActivity extends AppCompatActivity  {
//    private ImageView imageView1;
    private Button clickbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickbutton = (Button) findViewById(R.id.clickme);

        clickbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = getLayoutInflater();

                View customview = inflater.inflate(R.layout.customtoastlayout, (ViewGroup) findViewById(R.id.customtoastid));
                Toast toast = new Toast(MainActivity.this);

                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.setView(customview);
                toast.show();


            }
        });

//        imageView1 = (ImageView) findViewById(R.id.image1);

//        imageView1.setOnClickListener(this);
    }

//    @Override
//    public void onClick(View v) {
//        if(v.getId() == R.id.image1){
//            Toast.makeText(MainActivity.this,"Arefin",Toast.LENGTH_SHORT).show();
//        }
//
//    }
}
