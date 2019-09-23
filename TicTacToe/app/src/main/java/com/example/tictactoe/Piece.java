package com.example.tictactoe;

import android.widget.ImageView;

public class Piece {
    private ImageView image;
    private float alpha;
    private String status = "OFF";

    public Piece(){}

    public Piece(ImageView image, float alpha, String status){
        this.image = image;
        this.alpha = alpha;
        this.status = status;
    }

    /**************************************************************
     *                      GETTERS
     *************************************************************/

    public ImageView getImage(){
        return image;
    }

    public float getAlpha(){
        return alpha;
    }

    public String getStatus(){
        return status;
    }

    /**************************************************************
     *                      SETTERS
     *************************************************************/

    public void setImage(ImageView image){
        this.image = image;
    }

    public void setAlpha(float alpha){
        this.alpha = alpha;
    }

    public void setStatus(String status){
        this.status = status;
    }

    /**************************************************************
     *                      ACTUATORS
     *************************************************************/

    public void placePiece(){
        alpha = 1f;
        status = "ON";
        image.setAlpha(alpha);
    }

    public void unplacePiece(){
        alpha = 0f;
        status = "OFF";
        image.setAlpha(alpha);
    }
}
