package com.example.embeddingvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView sample = findViewById(R.id.samplevideoid);
        sample.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.sample);

        //To control video
        MediaController mediaController = new MediaController(this);
        sample.setMediaController(mediaController);
        mediaController.setAnchorView(sample);
        sample.start();

    }
}
