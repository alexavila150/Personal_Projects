package com.example.braintrainer;

import android.widget.TextView;

public class Game {
    int numCorrect;
    int numQuestions;
    int curTime;
    boolean gameOn;

    public Game (){
        numCorrect = 0;
        numQuestions = 0;
        curTime = 30;
        gameOn = false;
    }

    public void decreseOneSecond(){
        if(curTime > 0) curTime--;
    }

    public String getTime(){
        return "" + curTime + "s";
    }

    public String getScore(){
        return numCorrect + "/" + numQuestions;
    }

    public void correctAnswer(){
        numCorrect++;
        numQuestions++;
    }

    public void wrongAnswer(){
        numQuestions++;
    }

    public void start(){
        numQuestions = 0;
        numCorrect = 0;
        curTime = 30;
        gameOn = true;

    }

    public void reset(){
        numCorrect = 0;
        numQuestions = 0;
        curTime = 30;
        gameOn = false;
    }
}
