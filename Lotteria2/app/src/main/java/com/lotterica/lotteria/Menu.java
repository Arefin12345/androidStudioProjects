package com.lotterica.lotteria;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import hotchemi.android.rate.AppRate;

public class Menu extends AppCompatActivity implements RewardedVideoAdListener{
//public class Menu extends AppCompatActivity implements RewardedVideoAd {
     RewardedVideoAd mRewardedVideoAd;

    ArrayList<Integer> numbers = new ArrayList<>();

    public static final int REQUEST_CODE_GETMESSAGE = 1014;

    //old
    TextView textView,textview2;
    private EditText editText1,editText2;
    private Button savebutton1,savebutton2,scanbutton1,scanbutton2,checkbutton;

    Boolean result = false;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        //App rating
        AppRate.with(this)
                .setInstallDays(2)
                .setLaunchTimes(10)
                .setRemindInterval(6)
                .monitor();
        AppRate.showRateDialogIfMeetsConditions(this);
        AppRate.with(this).clearAgreeShowDialog();


        //initialize and assign variable;
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        //Perform Item Selected Listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.home:
                        return true;

                    case R.id.howto:
                        startActivity(new Intent(getApplicationContext(),   //Ask google
                                HowTo.class));
                        overridePendingTransition(0, 0); //Ask google
                        return true;

                    case R.id.save:
                        startActivity(new Intent(getApplicationContext(),   //Ask google
                                Saved.class));
                        overridePendingTransition(0, 0); //Ask google
                        return true;
                }
                return false;
            }
        });

        textView = (TextView) findViewById(R.id.textViewTwoId);
        textview2 = (TextView) findViewById(R.id.textviewshwId);

        editText1 = (EditText) findViewById(R.id.editTextone);
        editText2 = (EditText) findViewById(R.id.editTextTwo);


        checkbutton = (Button) findViewById(R.id.checkbuttonid);

        scanbutton1 = (Button) findViewById(R.id.scanbuttononeid);
        scanbutton2 = (Button) findViewById(R.id.scanbuttonidtwo);

         final String getedit1 = editText1.getText().toString();
        String getedit2 = editText1.getText().toString();


        checkbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(rewardedVideoAd.isLoaded()){
//                    rewardedVideoAd.show();
//                }
                if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }
                else{
                    matchResult();
                }



            }
        });


        //AddMob
        MobileAds.initialize(this, "ca-app-pub-6655915462369163~3065958608");
        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();




       scanbutton1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (mRewardedVideoAd.isLoaded()) {
                   mRewardedVideoAd.show();

               }
               else{
                   Intent intent = new Intent(Menu.this, Scanner.class);
                   startActivityForResult(intent, 1);
               }
           }
       });

       //Uncomment if scanbutton1 is successfull

       scanbutton2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (mRewardedVideoAd.isLoaded()) {
                   mRewardedVideoAd.show();
               }
               else{
                   Intent intenttwo = new Intent(Menu.this,ScannerTwo.class);
                   startActivityForResult(intenttwo,2);
               }

           }
       });



    }


    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-6655915462369163/6394172981",
                new AdRequest.Builder().build());
    }

    @Override
    public void onRewardedVideoAdLoaded() {
//        Toast.makeText(this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdOpened() {
//        Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoStarted() {
//        Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onRewardedVideoAdClosed() {
        // Load the next rewarded video ad.
        loadRewardedVideoAd();
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
//        Toast.makeText(this, "onRewardedVideoCompleted", Toast.LENGTH_SHORT).show();
        matchResult();

    }
    @Override
    public void onResume() {
        mRewardedVideoAd.resume(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        mRewardedVideoAd.pause(this);
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mRewardedVideoAd.destroy(this);
        super.onDestroy();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1) {
            if (resultCode == RESULT_OK) {
//                String result = data.getStringExtra("value");
                String str = data.getStringExtra("value");
                editText1.setText(str);
            }
        }

        if(requestCode == 2) {
            if (resultCode == 3) {
//                String result = data.getStringExtra("value");
                String str2 = data.getStringExtra("value2");
                editText2.setText(str2);
            }
        }
    }

    private void matchResult() {


        editText1 = findViewById(R.id.editTextone);
        editText2 = findViewById(R.id.editTextTwo);
        textView = findViewById(R.id.textviewidresult);


        editText1.setInputType(InputType.TYPE_CLASS_TEXT);
        String test = editText1.getText().toString();

        editText2.setInputType(InputType.TYPE_CLASS_TEXT);
        String test2 = editText2.getText().toString();



            String[] integerStrings1 = test.split(",");
            int[] integers1 = new int[integerStrings1.length];

            for (int i = 0; i < integers1.length; i++) {
                integers1[i] = Integer.parseInt(integerStrings1[i].toString());
            }

            String[] integerStrings2 = test2.split(",");
            int[] integers2 = new int[integerStrings2.length];

            for (int i = 0; i < integers2.length; i++) {
                integers2[i] = Integer.parseInt(integerStrings2[i].toString());
            }

            ArrayList<Integer> numbers = new ArrayList<>();

            for (int i = 0; i < integers1.length; i++) {
                for (int j = 0; j < integers2.length; j++) {
                    if (integers1[i] == integers2[j]) {
                        numbers.add(integers1[i]);
                        result = true;

                    }
                }
            }

            if (result) {
                Toast.makeText(this, "Match Found", Toast.LENGTH_SHORT).show();
                //send result to result activity
                Intent intent = new Intent(Menu.this, Result.class);
                intent.putExtra("key", numbers);
                startActivity(intent);
                result = false;
            } else {
                Toast.makeText(this, "No Match Found", Toast.LENGTH_SHORT).show();
                textView.setText("");
            }

            editText1.setText("");
            editText2.setText("");
    }



}


