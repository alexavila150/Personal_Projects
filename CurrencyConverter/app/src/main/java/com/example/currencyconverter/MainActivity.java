package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertToPesos(View view){
        //Calculate amount of pesos
        EditText userDollars = (EditText) findViewById(R.id.dollars);
        String dollarString = userDollars.getText().toString();
        double dollars = Double.parseDouble(dollarString);
        double pesos = 18.20 * dollars;

        //Display message with pesos
        Toast.makeText(MainActivity.this, "$" + pesos + " Pesos", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
