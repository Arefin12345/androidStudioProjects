package com.example.lottery2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class  MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 2000;

    Animation topanimation, bottomanimation;
    private ImageView imageView;
    private TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        topanimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomanimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        imageView = findViewById(R.id.iamgeviewid);
        textView1 = findViewById(R.id.textViewOneId);
        textView2 = findViewById(R.id.textViewTwoId);

        imageView.setAnimation(topanimation);
        textView1.setAnimation(bottomanimation);
        textView2.setAnimation(bottomanimation);

        Intent intent = new Intent(MainActivity.this, mainmenu.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,mainmenu.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }

}