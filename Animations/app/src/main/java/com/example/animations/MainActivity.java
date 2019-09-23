package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float alphaJotaro = 1;
    float alphaDio = 0;

    public void fade(View view) {
        //flip colors
        //float temp = alphaJotaro;
        //alphaJotaro = alphaDio;
        //alphaDio = temp;

        //set new colors to the images
        ImageView jotaro = (ImageView) findViewById(R.id.jotaro);
        jotaro

        //ImageView dio = (ImageView) findViewById(R.id.dio);
        //dio.animate().alpha(alphaDio).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView jotaro = (ImageView) findViewById(R.id.jotaro);
        jotaro.setTranslationX(-1500f);
    }
}
