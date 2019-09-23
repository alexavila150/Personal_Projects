package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Views
    Button startBotton;
    Button stopBotton;
    TextView clockView;
    ImageView dio;
    SeekBar seekBar;
    MediaPlayer kono;

    //Attributes
    long curTime = 30000;
    boolean timerIsOn = false;
    CountDownTimer timer;

    // Starts the timer with the click of start button
    public void startTimer(View view){
        //if timer is off turn it on
        if(!timerIsOn){
            //change botton text to stop
            startBotton.setVisibility(View.INVISIBLE);
            stopBotton.setVisibility(View.VISIBLE);

            timer = new CountDownTimer(curTime, 1000) {
                @Override
                public void onTick(long l) {
                    clockView.setText(millisecondsToClock(l));
                    curTime = l;
                    seekBar.setProgress((int) (curTime));
                }

                @Override
                public void onFinish() {
                    clockView.setText(millisecondsToClock(0));
                    curTime = 0;
                    seekBar.setProgress((int) (curTime));
                    timerIsOn = false;
                    startBotton.setVisibility(View.VISIBLE);
                    stopBotton.setVisibility(View.INVISIBLE);
                    kono.start();
                    dio.setVisibility(View.VISIBLE);
                }
            }.start();

            //turn on timer
            timerIsOn = true;
        }
    }

    public void stopTimer(View view){
        timer.cancel();
        startBotton.setVisibility(View.VISIBLE);
        stopBotton.setVisibility(View.INVISIBLE);
        timerIsOn = false;
    }

    public void updateTime(){

    }

    /*
    Converts milliseconds to clock reading
    Ex:
    input: 90000
    output: 1:30
     */
    public String millisecondsToClock(long milliseconds){
        //convert milliseconds to minutes
        int minutes = (int) (milliseconds / 60000);

        //get the remainder to convert them into seconds
        milliseconds = milliseconds % 60000;
        int seconds = (int) (milliseconds / 1000);

        //return in 10:10 format
        if(seconds < 10){
            return minutes + ":0" + seconds;
        }
        return minutes + ":" + seconds;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kono = MediaPlayer.create(this, R.raw.dioda);
        dio = findViewById(R.id.dio);
        startBotton = findViewById(R.id.startBotton);
        stopBotton = findViewById(R.id.stopBotton);
        clockView = findViewById(R.id.clockView);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setProgress(30000);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                curTime = seekBar.getProgress();
                clockView.setText(millisecondsToClock(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    /*
        Print Message in Toast
     */
    public void message(String s){
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }
}
