package com.lotterica.lotteria;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import javax.swing.text.html.ImageView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 2000;

    Animation topanimation,bottomanimation;
    ImageView image;
    TextView textView1,textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hiding the action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                ,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        topanimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);


        //Hocks
        image = findViewById(R.id.iamgeviewid);
        textView1 = findViewById(R.id.textViewOneId);
        textView2 = findViewById(R.id.textViewTwoId);

        image.setAnimation(topanimation);

        textView2.setAnimation(bottomanimation);
        textView1.setAnimation(bottomanimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Menu.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }


}