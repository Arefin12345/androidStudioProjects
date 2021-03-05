package com.lotterica.lotteria;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Saved extends AppCompatActivity implements RewardedVideoAdListener {
    RewardedVideoAd mRewardedVideoAd1;

    private EditText editText;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        //initialize and assign variable;
        BottomNavigationView bottomNavigationView = findViewById(R.id.saved_navigation);

        //Set save Selected
        bottomNavigationView.setSelectedItemId(R.id.save);
        button = findViewById(R.id.savebuttonid);
        editText =findViewById(R.id.editTextid);


        //Perform Item Selected Listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),   //Ask google
                                Menu.class));
                        overridePendingTransition(0, 0); //Ask google
                        return true;

                    case R.id.howto:
                        startActivity(new Intent(getApplicationContext(),   //Ask google
                                HowTo.class));
                        overridePendingTransition(0, 0); //Ask google
                        return true;

                    case R.id.save:
                        return true;
                }
                return false;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add
                if (mRewardedVideoAd1.isLoaded()) {
                    mRewardedVideoAd1.show();
                }

                String text = editText.getText().toString();
                if(text != null){
                    writeToFile(text);
                    Toast.makeText(Saved.this, "Successfully saved!", Toast.LENGTH_SHORT).show();
                }
                else if(text==null){
                    Toast.makeText(getApplicationContext(),"Please Put Some Notes",Toast.LENGTH_LONG).show();

                }
            }
        });
        //AddMob
        MobileAds.initialize(this, "ca-app-pub-6655915462369163~3065958608");
        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd1 = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd1.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();

        try {
            readfromfile();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    private void loadRewardedVideoAd() {
        mRewardedVideoAd1.loadAd("ca-app-pub-6655915462369163/6394172981",
                new AdRequest.Builder().build());
    }

//
//    private void loadData() {
//
//
//
//    }

public void writeToFile(String text){
    try {
        FileOutputStream fileOutputStream = openFileOutput("diary.txt", Context.MODE_PRIVATE);
        fileOutputStream.write(text.getBytes());
        fileOutputStream.close();

    }catch (FileNotFoundException e){
        e.printStackTrace();

    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public void readfromfile() throws IOException {
        FileInputStream fileInputStream = openFileInput("diary.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        StringBuffer stringBuffer = new StringBuffer();

        //Reading Strings From Bufferreader
        while((line = bufferedReader.readLine())!=null){
            stringBuffer.append(line+"\n");
        }
        editText.setText(stringBuffer.toString());
    }


    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }
}