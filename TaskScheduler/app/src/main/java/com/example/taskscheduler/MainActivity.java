package com.example.taskscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int number = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("arefin","onTick: I am hero");
            }

            @Override
            public void onFinish() {
                Log.d("finished","has been finished");
            }
        }.start()   ;

        //Task scheduling using handler

//        final Handler handler = new Handler();
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//                number++;
//                Toast.makeText(MainActivity.this, "I'm "+number+"th Toast", Toast.LENGTH_SHORT).show();
//                    handler.postDelayed(this,1000);
//            }
//        };
//        handler.post(run);


    }
}