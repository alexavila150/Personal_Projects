package com.example.shapenumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Class with the attributes of the numbers.
    class Number{
        //Attributes
        int value;
        boolean isTriangular;
        boolean isSquare;
        boolean isBoth;
        boolean isNone;

        //Constructor
        Number(int n){
            value = n;
            isTriangular = numberIsTriangular(value);
            isSquare = numberIsSquare(value);
            isBoth = isTriangular && isSquare;
            isNone = !isTriangular && !isSquare;
        }
    }

    public boolean numberIsTriangular(int n){
        int triangularNumber = 1;
        int counter = 1;
        while(triangularNumber <= n){
            if(n == triangularNumber){
                return true;
            }
            counter++;
            triangularNumber += counter;
        }
        return false;
    }

    public boolean numberIsSquare(int n){
        if(n <= 0){
            return false;
        }
        int root = (int) Math.sqrt(n);
        int squareOfRoot = root * root;
        return squareOfRoot == n;
    }

    public void toast(String message){
        Toast.makeText(this, message + "", Toast.LENGTH_SHORT).show();
    }

    public void calculate(View view){
        //Gets input from user
        EditText userNumberView = (EditText) findViewById(R.id.userNumber);
        int userNumber = Integer.parseInt(userNumberView.getText().toString());

        //Make number object
        Number number = new Number(userNumber);
        //display message
        if(number.isNone){
            toast("Neither");
        }else if(number.isBoth){
            toast("Both");
        }else if(number.isSquare){
            toast("Is a Square Number");
        }else{
            toast("Is a Triangular Number");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
