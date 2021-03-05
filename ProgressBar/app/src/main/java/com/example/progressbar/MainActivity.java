package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewDebug;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBarid);

        Thread thread = new Thread(new Runnable() {


            @Override
            public void run() {
                doWork();
            }
        });
        thread.start();
    }
        public void doWork(){
        for(progress=10;progress<=100;progress=progress+30) {
        //After 40 1s After 70 1s

            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }

    }

