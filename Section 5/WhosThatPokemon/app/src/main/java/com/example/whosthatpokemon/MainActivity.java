package com.example.whosthatpokemon;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    //Views
    Button option1;
    Button option2;
    Button option3;
    Button option4;
    Button selectedOption;
    ImageView pokemonPicture;
    ImageView pikachu;

    //Sounds
    MediaPlayer happyPikachuSound;
    MediaPlayer sadPikachuSound;

    //Classes
    Pokedex pokedex;

    public class GetPokemonList extends AsyncTask<String, Void, String[][]>{

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        protected String[][] doInBackground(String... urls) {
            String result = "";
            String result2 = "";
            try {
                URL page1 = new URL(urls[0]);
                URL page2 = new URL(urls[1]);
                HttpURLConnection connectionPage1 = (HttpURLConnection) page1.openConnection();
                HttpURLConnection connectionPage2 = (HttpURLConnection) page2.openConnection();
                connectionPage1.connect();
                connectionPage2.connect();

                //Get input streams from both pages
                InputStream inputPage1 = connectionPage1.getInputStream();
                InputStream inputPage2 = connectionPage2.getInputStream();

                //Convert InputStream of page 1 into a String
                Scanner s = new Scanner(inputPage1).useDelimiter("\\A");
                result = s.hasNext() ? s.next() : "";

                //Convert InputStream of page 2 into a String
                Scanner s2 = new Scanner(inputPage2).useDelimiter("\\A");
                result2 = s2.hasNext() ? s2.next() : "";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return htmlToPokemonList(result + "" + result2);
        }
    }

    public String[][] htmlToPokemonList(String html){
        //2D array that will contain the name and picture of the pokemon
        String[][] pokemonList = new String[2][150];

        //Pattern to find Images
        Pattern pattern = Pattern.compile("<img src=\"(.*?)\" />");
        Matcher matcher = pattern.matcher(html);

        //Get images from the first page
        ArrayList<String> images = new ArrayList<String>();
        while(matcher.find()){
            images.add(matcher.group(1));
        }
        images.remove(0);
        images.remove(100);
        images.remove(100);
        images.remove(150);

        for(int i = 0; i < images.size(); i++){
            Log.i("images<" + i + ">", images.get(i));
        }

        //List to store the pokemon names.
        ArrayList<String> names = new ArrayList<String>();

        //Patttern to find the names of the Pokemon
        Pattern namePattern = Pattern.compile("<h3>(.*?)</h3>");
        matcher = namePattern.matcher(html);
        while(matcher.find()){
            names.add(matcher.group(1));
        }

        for(int i = 0; i < names.size(); i++){
            Log.i("names<" + i + ">", names.get(i));
        }

        //Put both lists into the 2D array
        for(int i = 0; i < 150; i++){
            pokemonList[0][i] = names.get(i);
            pokemonList[1][i] = images.get(i);
        }

        return pokemonList;
    }

    public void choosePokemon(View view){
        selectedOption = (Button) view;
        if(selectedOption.getText().equals(pokedex.correctPokemon.getName())){
            correct();
        }else{
            wrong();
        }
    }

    public void correct(){
        new CountDownTimer(2500, 500) {
            @Override
            public void onTick(long l) {
                pikachu.setImageResource(R.drawable.happy);
                pikachu.setVisibility(View.VISIBLE);
                happyPikachuSound.start();
                setOptionsClickable(false);
            }

            @Override
            public void onFinish() {
                pikachu.setVisibility(View.INVISIBLE);
                setOptionsClickable(true);
                pokedex.generateProblem();
                setPokemonToOptions();
            }
        }.start();
    }

    public void wrong(){
        new CountDownTimer(3500, 500) {
            @Override
            public void onTick(long l) {
                pikachu.setImageResource(R.drawable.sad);
                pikachu.setVisibility(View.VISIBLE);
                sadPikachuSound.start();
                setOptionsClickable(false);
            }

            @Override
            public void onFinish() {
                pikachu.setVisibility(View.INVISIBLE);
                setOptionsClickable(true);
            }
        }.start();
    }

    public void setOptionsClickable(Boolean b){
        option1.setClickable(b);
        option2.setClickable(b);
        option3.setClickable(b);
        option4.setClickable(b);
    }

    public void setPokemonToOptions(){
        //Set 4 pokemon to the option buttons
        Random rand = new Random();

        ArrayList<Pokemon> options = new ArrayList<Pokemon>();
        options.add(pokedex.correctPokemon);
        options.add(pokedex.wrongPokemon1);
        options.add(pokedex.wrongPokemon2);
        options.add(pokedex.wrongPokemon3);

        option1.setText(options.remove(rand.nextInt(options.size())).getName());
        option2.setText(options.remove(rand.nextInt(options.size())).getName());
        option3.setText(options.remove(rand.nextInt(options.size())).getName());
        option4.setText(options.remove(rand.nextInt(options.size())).getName());

        //Set correct Pokemon"s picture
        pokemonPicture.setImageBitmap(pokedex.correctPokemon.getImage());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set values to the sound players
        happyPikachuSound = (MediaPlayer) MediaPlayer.create(this, R.raw.happy);
        sadPikachuSound = (MediaPlayer) MediaPlayer.create(this, R.raw.sad);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        pokemonPicture = findViewById(R.id.pokemonPicture);
        pikachu = findViewById(R.id.pikachu);

        GetPokemonList getPokemonList = new GetPokemonList();

        String[][] pokemonList = new String[2][150];

        try {
            pokemonList = getPokemonList.execute("https://www.giantbomb.com/profile/wakka/lists/the-150-original-pokemon/59579/",
                    "https://www.giantbomb.com/profile/wakka/lists/the-150-original-pokemon/59579/?page=2").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pokedex = new Pokedex(pokemonList);
        pokedex.print();

        setPokemonToOptions();
    }

    public void message(String message){
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
