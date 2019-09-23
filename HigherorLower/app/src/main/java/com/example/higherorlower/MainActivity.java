package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int numberToGuess = 60;

    public int getRandomNumber(){
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }

    public void guess(View view){
        //message to the user
        String message = "";

        //gets the input from the user
        EditText userNumber = (EditText) findViewById(R.id.userNumber);
        int input = Integer.parseInt(userNumber.getText().toString());

        //decides what messages to give
        if(input > numberToGuess){
            message = "LOWER";
        }else if(input < numberToGuess){
            message = "HIGHER";
        }else{
            message = "That's Correct!";
        }

        //Display message
        Toast.makeText(MainActivity.this, message + "", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
