package com.example.listviewandarrayadapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //Until what time splash screen will be here
    private static int SPLASH_SCREEN = 2500;

    ImageView imageView;
    TextView textView1,textView2;
    Animation top,bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView = (ImageView) findViewById(R.id.iamgeviewid);
        textView1 = (TextView) findViewById(R.id.textviewid);
        textView2 = (TextView) findViewById(R.id.textviewid2);

        top = AnimationUtils.loadAnimation(this,R.anim.top);
        bottom = AnimationUtils.loadAnimation(MainActivity.this,R.anim.bottom);

        imageView.setAnimation(top);
        textView1.setAnimation(bottom);
        textView2.setAnimation(bottom);

        //Start another activity

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,MainMenu.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

        setContentView(R.layout.activity_main);
    }
}
