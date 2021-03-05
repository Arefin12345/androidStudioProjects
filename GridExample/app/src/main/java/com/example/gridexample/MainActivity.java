package com.example.gridexample;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void play(View view){
        Button buttonpressed = (Button) view;

        MediaPlayer mediaPlayer = MediaPlayer.create(this,getResources()
                .getIdentifier(buttonpressed.getTag().toString(), "raw",getPackageName()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}