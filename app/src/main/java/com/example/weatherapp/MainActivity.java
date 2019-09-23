package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView city;
    TextView info;

    public void citySelected(View view){
        String cityName = city.getText().toString();
        City selectedCity = new City(cityName);
        info.setText(selectedCity.getInfo());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.city);
        info = findViewById(R.id.info);

    }
}
