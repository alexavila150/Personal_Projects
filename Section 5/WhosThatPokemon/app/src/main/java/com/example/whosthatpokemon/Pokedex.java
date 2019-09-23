package com.example.whosthatpokemon;

import android.graphics.Bitmap;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class Pokedex {
    Pokemon[] pokemons;
    Pokemon correctPokemon;
    Pokemon wrongPokemon1;
    Pokemon wrongPokemon2;
    Pokemon wrongPokemon3;
    private Bitmap bitmap;

    public Pokedex(String[][] pokemonList){
        pokemons = new Pokemon[150];
        for(int i = 0; i < 150; i++){
            Log.i("i", "" + i);
            pokemons[i] = new Pokemon(pokemonList[0][i], pokemonList[1][i]);
        }
        generateProblem();
    }

    public void generateProblem(){
        Random rand = new Random();
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
        for(int i = 0; i < 150; i++){
            randomNumbers.add(i);
        }
        int randomNumber = randomNumbers.remove(rand.nextInt(randomNumbers.size()));
        correctPokemon = pokemons[randomNumber];
        randomNumber = randomNumbers.remove(rand.nextInt(randomNumbers.size()));
        wrongPokemon1 = pokemons[randomNumber];
        randomNumber = randomNumbers.remove(rand.nextInt(randomNumbers.size()));
        wrongPokemon2 = pokemons[randomNumber];
        randomNumber = randomNumbers.remove(rand.nextInt(randomNumbers.size()));
        wrongPokemon3 = pokemons[randomNumber];
    }

    public Bitmap getBitmap() {
        return correctPokemon.getImage();
    }

    public void print(){
        for(int i = 0; i < 150; i++){
            Log.i(pokemons[i].getName(), pokemons[i].imageUrl);
        }
    }
}
