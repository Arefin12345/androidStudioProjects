package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton playbutton, pausebutton;
    private MediaPlayer mediaPlayer;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playbutton = (ImageButton) findViewById(R.id.playbuttonid);
        pausebutton = (ImageButton) findViewById(R.id.pausebuttonid);
        mediaPlayer = MediaPlayer.create(this, R.raw.lily);

        playbutton.setOnClickListener(this);
        pausebutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.playbuttonid) {

            if (mediaPlayer != null) {

                mediaPlayer.start();
                int duration = mediaPlayer.getDuration()/1000;
                Toast.makeText(MainActivity.this, "Now playing lily for "+
                        duration/60 +""
                        +":"+duration%60+" minutes", Toast.LENGTH_SHORT).show();

            }
        }

        if (v.getId() == R.id.pausebuttonid) {

            if (mediaPlayer != null) {
                mediaPlayer.pause();
                Toast.makeText(MainActivity.this, "Music paused", Toast.LENGTH_SHORT).show();
            }

        }

    }

    @Override
    protected void onDestroy() {

        if(mediaPlayer!=null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
        super.onDestroy();
    }
}






