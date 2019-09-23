package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    //Views
    TextView option1;
    TextView option2;
    TextView option3;
    TextView option4;
    TextView selectedOption;
    TextView equation;
    TextView score;
    TextView timer;
    TextView judge;
    TextView start;
    Button playAgain;

    //Class Objects
    Problem problem;
    Game game;
    CountDownTimer countDownTimer;

    public void start(View view){
        option1.setVisibility(View.VISIBLE);
        option2.setVisibility(View.VISIBLE);
        option3.setVisibility(View.VISIBLE);
        option4.setVisibility(View.VISIBLE);
        equation.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        timer.setVisibility(View.VISIBLE);
        start.setVisibility(View.INVISIBLE);
        playAgain.setVisibility(View.INVISIBLE);

        game.start();
        createProblem();
        updateGame();
        judge.setText("");
        setControlsClickable(true);

        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                game.curTime = (int) l / 1000;
                timer.setText(game.getTime());
            }

            @Override
            public void onFinish() {
                game.curTime = 0;
                timer.setText(game.getTime());
                judge.setText("Your Score Is " + game.getScore());
                playAgain.setVisibility(View.VISIBLE);
                setControlsClickable(false);
            }
        }.start();
    }



    public void option1Pressed(View view){
        selectedOption = (TextView) view;
        checkIfOptionWasCorrect();
    }

    public void option2Pressed(View view){
        selectedOption = (TextView) view;
        checkIfOptionWasCorrect();
    }

    public void option3Pressed(View view){
        selectedOption = (TextView) view;
        checkIfOptionWasCorrect();
    }

    public void option4Pressed(View view){
        selectedOption = (TextView) view;
        checkIfOptionWasCorrect();
    }

    public void setControlsClickable(Boolean b){
        option1.setClickable(b);
        option2.setClickable(b);
        option3.setClickable(b);
        option4.setClickable(b);
    }

    public void checkIfOptionWasCorrect(){
        if(selectedOption.getText().equals(problem.correctAnswer + "")){
            Log.i("option", "correct");
            game.correctAnswer();
            judge.setText("Correct!");

        }else{
            Log.i("option","incorrect");
            game.wrongAnswer();
            judge.setText("Wrong!");
        }
        judge.setVisibility(View.VISIBLE);
        createProblem();
        updateGame();
    }

    public void updateGame(){
        score.setText(game.getScore());
        equation.setText(problem.getEquation());
    }

    public void createProblem(){
        problem = new Problem();

        //Set the 4 options into an ArrayList
        ArrayList<Integer> options = new ArrayList<Integer>();
        options.add(problem.correctAnswer);
        options.add(problem.wrongAnswer1);
        options.add(problem.wrongAnswer2);
        options.add(problem.wrongAnswer3);

        //choose random answer for each option
        Random rand = new Random();
        option1.setText("" + options.remove(rand.nextInt(4)));
        option2.setText("" + options.remove(rand.nextInt(3)));
        option3.setText("" + options.remove(rand.nextInt(2)));
        option4.setText("" + options.remove(rand.nextInt(1)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        option1  = findViewById(R.id.option1);
        option2  = findViewById(R.id.option2);
        option3  = findViewById(R.id.option3);
        option4  = findViewById(R.id.option4);
        equation = findViewById(R.id.equation);
        score    = findViewById(R.id.score);
        timer    = findViewById(R.id.timer);
        judge    = findViewById(R.id.judge);
        start    = findViewById(R.id.start);
        playAgain = findViewById(R.id.playAgain);

        game = new Game();

        option1.setVisibility(View.INVISIBLE);
        option2.setVisibility(View.INVISIBLE);
        option3.setVisibility(View.INVISIBLE);
        option4.setVisibility(View.INVISIBLE);
        equation.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);
        timer.setVisibility(View.INVISIBLE);
        judge.setVisibility(View.INVISIBLE);

        createProblem();
        updateGame();
    }
}
