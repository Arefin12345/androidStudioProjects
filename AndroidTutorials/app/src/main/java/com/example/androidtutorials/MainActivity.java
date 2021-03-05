package com.example.androidtutorials;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webview = (WebView) findViewById(R.id.webviewid);


        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //To link new
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("https://www.spongebobshop.com/");


    }

    @Override
    public void onBackPressed() {
    if(webview.canGoBack()){
        webview.goBack();
    }

    else{
            super.onBackPressed();
        }



    }
}
