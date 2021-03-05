package com.example.downloadingwebcontent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    public class DownloadTask extends AsyncTask<String,Void,String>{


        @Override
        protected String doInBackground(String... strings) {
            Log.i("ArefinPre","Prexecute run");
            String result = "";
            URL url;
            HttpURLConnection conn;
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("ArefinPost","Post Execute");
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i("ArefinPre","Prexecute run");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
}