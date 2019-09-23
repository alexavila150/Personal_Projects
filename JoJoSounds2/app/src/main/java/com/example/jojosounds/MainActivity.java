package com.example.jojosounds;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer muda;
    MediaPlayer ora;
    MediaPlayer kono;
    MediaPlayer yare;
    MediaPlayer wry;
    MediaPlayer ohno;
    MediaPlayer nice;
    MediaPlayer zawarudo;


    public void playSound(View view){
        switch(view.getId()){
            case R.id.muda:
                muda.start();
                break;
            case R.id.ora:
                ora.start();
                break;
            case R.id.kono:
                kono.start();
                break;
            case R.id.yare:
                yare.start();
                break;
            case R.id.wry:
                wry.start();
                break;
            case R.id.ohno:
                ohno.start();
                break;
            case R.id.nice:
                nice.start();
                break;
            case R.id.zawarudo:
                zawarudo.start();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        muda     = MediaPlayer.create(this, R.raw.muda    );
        ora      = MediaPlayer.create(this, R.raw.ora     );
        kono     = MediaPlayer.create(this, R.raw.kono    );
        yare     = MediaPlayer.create(this, R.raw.yare    );
        wry      = MediaPlayer.create(this, R.raw.wry     );
        ohno     = MediaPlayer.create(this, R.raw.ohno    );
        nice     = MediaPlayer.create(this, R.raw.joseph  );
        zawarudo = MediaPlayer.create(this, R.raw.zawarudo);


    }
}
