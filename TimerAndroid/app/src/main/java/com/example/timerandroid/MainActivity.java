package com.example.timerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        1st method to handle the time
        new CountDownTimer(10000,100){

            public void onTick(long milliSecondsUntilDone){
                Log.i("Seconds left !", String.valueOf(milliSecondsUntilDone/1000));

            }

            public void onFinish(){
                    Log.i("We're done","No more countdown");
            }   

        };



        //        2nd method to handle the time

        /*
        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Hey, A second passed by", Toast.LENGTH_SHORT).show();
                Log.i("Hey","A second passed by");

                handler.postDelayed(this,1000);
            }
        };
        handler.post(run);

         */

    }
}