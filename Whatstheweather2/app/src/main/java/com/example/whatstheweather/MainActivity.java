package com.example.whatstheweather;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;

    public class DownloadTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {

                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }

                return result;

            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),"Could not find weather :(",Toast.LENGTH_SHORT) ;
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject jsonObject = new JSONObject(s);

                String weatherInfo = jsonObject.getString("weather");

                Log.i("arefin", weatherInfo);

                JSONArray arr = new JSONArray(weatherInfo);
                String message = "";

                for (int i=0; i < arr.length(); i++) {
                    JSONObject jsonPart = arr.getJSONObject(i);

                    String main = jsonPart.getString("main");
                    String description = jsonPart.getString("description");

                    if(!main.equals("") && !description.equals("")){
                        message += main + ": "+description+"\r\n";
                    }
                }
                if(!message.equals("")){
                    textView.setText(message);
                }else {
                    Toast.makeText(getApplicationContext(),"Could not find weather :(",Toast.LENGTH_SHORT) ;
                }

            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),"Could not find weather :(",Toast.LENGTH_SHORT) ;

                e.printStackTrace();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextId);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getweather();
            }
        });



    }

    public void getweather(){
        DownloadTask task = new DownloadTask();
        String encodedCityName = null;
        try {
            encodedCityName = URLEncoder.encode(editText.getText().toString(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            Toast.makeText(getApplicationContext(),"Could not find weather :(",Toast.LENGTH_SHORT) ;

            e.printStackTrace();
        }
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(editText.getWindowToken(),0);                                   //To hide the keyboard after clicking edittext

    
        task.execute("http://api.openweathermap.org/data/2.5/weather?q="+encodedCityName+"&appid=f43f034c417bfbc806cbce1d64c2b381");
        // Api key : 26dc83aca949fc054d49ccb2d863d88a
    }}
