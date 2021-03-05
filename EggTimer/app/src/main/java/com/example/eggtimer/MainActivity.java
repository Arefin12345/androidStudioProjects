package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    SeekBar timerSeekBar;
    Button button;
    TextView timerTextView;
    CountDownTimer countDownTimer;
    Boolean counterIsActive = false;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView = findViewById(R.id.textViewTime);
        button = findViewById(R.id.buttonId);
        timerSeekBar = findViewById(R.id.seekBar);

        timerSeekBar.setMax(600); //That means 10 minutes
        timerSeekBar.setProgress(30); //That mens starting time will be 30 seconds
        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimer(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void resetTimer(){
        timerTextView.setText("0:30");
        timerSeekBar.setProgress(30);
        timerSeekBar.setEnabled(true);
        countDownTimer.cancel();
        counterIsActive = false;
        button.setText("GO!");
        mediaPlayer.stop();
    }
    //After The Button is clicked start counting time
    public void runbutton(View view){
        if(counterIsActive){
            resetTimer();

        }else {
            counterIsActive = true;
            timerSeekBar.setEnabled(false);
            button.setText("Stop!");

             countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {
                @Override
                public void onTick(long l) {
                    updateTimer((int) l / 1000);
                }

                @Override
                public void onFinish() {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarm);
                    mediaPlayer.start();
                }
            }.start();
        }

    }



    public void updateTimer(int secondsLeft){

        int minute = secondsLeft/60;
        int seconds = secondsLeft - (minute*60);

        String secondString = Integer.toString(seconds);

//        if (secondString.equals("0")){
//            secondString = "00";
//        }

        if(seconds <= 9){
            secondString = "0"+secondString;
        }
        timerTextView.setText(Integer.toString(minute)+":"+secondString);

    }
}