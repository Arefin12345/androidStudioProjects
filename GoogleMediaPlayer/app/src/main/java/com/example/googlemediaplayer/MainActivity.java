package com.example.googlemediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Here is an example of how to play audio
//    that's available as a local raw resource (saved in your application's res/raw/


//        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.rare);
//        mediaPlayer.start();
//        mediaPlayer.stop();


//        And here is how you might play from a URI available locally in the system (that you obtained through a Content Resolver, for instance):
//
//        Uri myUri = ....; // initialize Uri here
//        MediaPlayer mediaPlayer = new MediaPlayer();
//        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        mediaPlayer.setDataSource(getApplicationContext(), myUri);
//        mediaPlayer.prepare();
//        mediaPlayer.start();

        String url = "https://www.jango.com/stations/263448190/tunein"; // your URL here
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }
}