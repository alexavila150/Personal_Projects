package com.example.braintrainer;

import java.util.Random;

import static java.lang.Math.*;

public class Problem {
    int correctAnswer;
    int wrongAnswer1;
    int wrongAnswer2;
    int wrongAnswer3;
    int sum1;
    int sum2;

    public Problem(){
        Random rand = new Random();
        correctAnswer = rand.nextInt(100) + 1;

        //assign random values to the wrong answers until they are different
        while(answersAreNotDifferent()){
            wrongAnswer1 = rand.nextInt(100) + 1;
            wrongAnswer2 = rand.nextInt(100) + 1;
            wrongAnswer3 = rand.nextInt(100) + 1;
        }

        sum1 = rand.nextInt(100) + 1;
        sum2 = correctAnswer - sum1;
    }

    //Returns equation to solve for correct answer.
    public String getEquation(){
        if(sum2 >= 0){
            return sum1 + " + " + sum2;
        }
        return sum1 + " - " + Math.abs(sum2);
    }

    public boolean answersAreNotDifferent(){

        //if correct Answer is equal to one of the other answers
        //then the answers are not different
        if(     correctAnswer == wrongAnswer1 ||
                correctAnswer == wrongAnswer2 ||
                correctAnswer == wrongAnswer3){
            return true;
        }

        //if wrongAnswer1 is equal to one of the other answers
        //then the answers are not different
        if(     wrongAnswer1 == wrongAnswer2 ||
                wrongAnswer1 == wrongAnswer3){
            return true;
        }

        //if wrongAnswer2 is equal to wrongAnswer3
        //then answers are not different.
        if(wrongAnswer2 == wrongAnswer3){
            return true;
        }

        return false;
    }
}
