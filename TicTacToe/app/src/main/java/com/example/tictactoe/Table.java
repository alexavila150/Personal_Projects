package com.example.tictactoe;

import android.widget.ImageView;

public class Table {
    private ImageView tableImage;
    private Piece[] redPieces;
    private Piece[] blackPieces;
    private int turn = 1;
    private boolean[] avaliable = new boolean[9];

    public Table(){}

    public Table(ImageView tableImage, Piece[] redPieces, Piece[] blackPieces){
        this.tableImage = tableImage;
        this.redPieces = redPieces;
        this.blackPieces = blackPieces;
        for(int i = 0; i < 9; i++){
            avaliable[i] = true;
        }
    }

    public void placeAt1(){
        if(avaliable[0]){
            if(isRedTurn()){
                redPieces[0].placePiece();
            }else{
                blackPieces[0].placePiece();
            }
            turn++;
            avaliable[0] = false;
        }
    }

    public void placeAt2(){
        if(avaliable[1]){
            if(isRedTurn()){
                redPieces[1].placePiece();
            }else{
                blackPieces[1].placePiece();
            }
            turn++;
            avaliable[1] = false;
        }
    }

    public void placeAt3(){
        if(avaliable[2]){
            if(isRedTurn()){
                redPieces[2].placePiece();
            }else{
                blackPieces[2].placePiece();
            }
            turn++;
            avaliable[2] = false;
        }
    }

    public void placeAt4(){
        if(avaliable[3]){
            if(isRedTurn()){
                redPieces[3].placePiece();
            }else{
                blackPieces[3].placePiece();
            }
            turn++;
            avaliable[3] = false;
        }
    }

    public void placeAt5(){
        if(avaliable[4]){
            if(isRedTurn()){
                redPieces[4].placePiece();
            }else{
                blackPieces[4].placePiece();
            }
            turn++;
            avaliable[4] = false;
        }
    }

    public void placeAt6(){
        if(avaliable[5]){
            if(isRedTurn()){
                redPieces[5].placePiece();
            }else{
                blackPieces[5].placePiece();
            }
            turn++;
            avaliable[5] = false;
        }
    }

    public void placeAt7(){
        if(avaliable[6]){
            if(isRedTurn()){
                redPieces[6].placePiece();
            }else{
                blackPieces[6].placePiece();
            }
            turn++;
            avaliable[6] = false;
        }
    }

    public void placeAt8(){
        if(avaliable[7]){
            if(isRedTurn()){
                redPieces[7].placePiece();
            }else{
                blackPieces[7].placePiece();
            }
            turn++;
            avaliable[7] = false;
        }
    }

    public void placeAt9(){
        if(avaliable[8]){
            if(isRedTurn()){
                redPieces[8].placePiece();
            }else{
                blackPieces[8].placePiece();
            }
            turn++;
            avaliable[8] = false;
        }
    }

    public boolean isRedTurn(){
        return 0 == turn % 2;
    }



    public boolean isRedWinner(){
        if(redPieces[0].getStatus().equals("ON")){
            if(redPieces[1].getStatus().equals("ON")){
                if(redPieces[2].getStatus().equals("ON")){
                    return true;
                }
            }

            if(redPieces[3].getStatus().equals("ON")){
                if(redPieces[6].getStatus().equals("ON")){
                    return true;
                }
            }

            if(redPieces[4].getStatus().equals("ON")){
                if(redPieces[8].getStatus().equals("ON")){
                    return true;
                }
            }
        }

        if(redPieces[8].getStatus().equals("ON")){
            if(redPieces[6].getStatus().equals("ON")){
                if(redPieces[7].getStatus().equals("ON")){
                    return true;
                }
            }

            if(redPieces[2].getStatus().equals("ON")){
                if(redPieces[5].getStatus().equals("ON")){
                    return true;
                }
            }
        }

        if(redPieces[4].getStatus().equals("ON")){
            if(redPieces[3].getStatus().equals("ON")){
                if(redPieces[5].getStatus().equals("ON")){
                    return true;
                }
            }

            if(redPieces[1].getStatus().equals("ON")){
                if(redPieces[7].getStatus().equals("ON")){
                    return true;
                }
            }

            if(redPieces[6].getStatus().equals("ON")){
                if(redPieces[2].getStatus().equals("ON")){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBlackWinner(){
        if(blackPieces[0].getStatus().equals("ON")){
            if(blackPieces[1].getStatus().equals("ON")){
                if(blackPieces[2].getStatus().equals("ON")){
                    return true;
                }
            }

            if(blackPieces[3].getStatus().equals("ON")){
                if(blackPieces[6].getStatus().equals("ON")){
                    return true;
                }
            }

            if(blackPieces[4].getStatus().equals("ON")){
                if(blackPieces[8].getStatus().equals("ON")){
                    return true;
                }
            }
        }

        if(blackPieces[8].getStatus().equals("ON")){
            if(blackPieces[6].getStatus().equals("ON")){
                if(blackPieces[7].getStatus().equals("ON")){
                    return true;
                }
            }

            if(blackPieces[2].getStatus().equals("ON")){
                if(blackPieces[5].getStatus().equals("ON")){
                    return true;
                }
            }
        }

        if(blackPieces[4].getStatus().equals("ON")){
            if(blackPieces[3].getStatus().equals("ON")){
                if(blackPieces[5].getStatus().equals("ON")){
                    return true;
                }
            }

            if(blackPieces[1].getStatus().equals("ON")){
                if(blackPieces[7].getStatus().equals("ON")){
                    return true;
                }
            }

            if(blackPieces[6].getStatus().equals("ON")){
                if(blackPieces[2].getStatus().equals("ON")){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isIied(){
        for(int i = 0; i < 9; i++){
            if(avaliable[i]){
                return false;
            }
        }
        return true;
    }
}
