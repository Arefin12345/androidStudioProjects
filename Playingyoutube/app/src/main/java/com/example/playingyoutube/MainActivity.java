package com.example.playingyoutube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String video_path = "http://www.youtube.com/watch?v=opZ69P-0Jbc";
        Uri uri = Uri.parse(video_path);
        // With this line the YouTube application, if installed, will launch immediately.
        // Without it you will be prompted with a list of applications to choose from.
        uri = Uri.parse("vnd.youtube:" + uri.getQueryParameter("v"));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }
}