package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView[] redImages = new ImageView[9];
    ImageView[] blackImages = new ImageView[9];
    Piece[] redPieces = new Piece[9];
    Piece[] blackPieces = new Piece[9];
    ImageView tableImage;
    Table table;

    public void placeAt1(View view){
        table.placeAt1();
        checkForWinner();
    }

    public void placeAt2(View view){
        table.placeAt2();
        checkForWinner();
    }

    public void placeAt3(View view){
        table.placeAt3();
        checkForWinner();
    }

    public void placeAt4(View view){
        table.placeAt4();
        checkForWinner();
    }

    public void placeAt5(View view){
        table.placeAt5();
        checkForWinner();
    }

    public void placeAt6(View view){
        table.placeAt6();
        checkForWinner();
    }

    public void placeAt7(View view){
        table.placeAt7();
        checkForWinner();
    }

    public void placeAt8(View view){
        table.placeAt8();
        checkForWinner();
    }

    public void placeAt9(View view){
        table.placeAt9();
        checkForWinner();
    }


    public void checkForWinner(){
        //if red wins print RED
        if(table.isRedWinner()){
            ImageView redWins = findViewById(R.id.redWins);
            redWins.setAlpha(1f);
            return;
        }
        //if blue wins print BLUE
        if(table.isBlackWinner()){
            ImageView blackWins = findViewById(R.id.blackWins);
            blackWins.setAlpha(1f);
            return;
        }
        //if tied print
        if(table.isIied()){
            ImageView tied = findViewById(R.id.tied);
            tied.setAlpha(1f);
        }
    }

    /*****************************************************************************
     *                          ON CREATE
     *****************************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create ImageViews
        //Red Pieces
        redImages[0] = findViewById(R.id.red1);
        redImages[1] = findViewById(R.id.red2);
        redImages[2] = findViewById(R.id.red3);
        redImages[3] = findViewById(R.id.red4);
        redImages[4] = findViewById(R.id.red5);
        redImages[5] = findViewById(R.id.red6);
        redImages[6] = findViewById(R.id.red7);
        redImages[7] = findViewById(R.id.red8);
        redImages[8] = findViewById(R.id.red9);

        //Black Pieces
        blackImages[0] = findViewById(R.id.black1);
        blackImages[1] = findViewById(R.id.black2);
        blackImages[2] = findViewById(R.id.black3);
        blackImages[3] = findViewById(R.id.black4);
        blackImages[4] = findViewById(R.id.black5);
        blackImages[5] = findViewById(R.id.black6);
        blackImages[6] = findViewById(R.id.black7);
        blackImages[7] = findViewById(R.id.black8);
        blackImages[8] = findViewById(R.id.black9);

        //Creates Piece Objects
        for(int i = 0; i < 9; i++){
            redPieces[i] = new Piece(redImages[i], 0f, "OFF");
            blackPieces[i] = new Piece(blackImages[i], 0f, "OFF");
        }

        //Creates table for the game.
        tableImage = (ImageView) findViewById(R.id.imageView);
        table = new Table(tableImage, redPieces, blackPieces);


    }

    public void toast(String message){
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
