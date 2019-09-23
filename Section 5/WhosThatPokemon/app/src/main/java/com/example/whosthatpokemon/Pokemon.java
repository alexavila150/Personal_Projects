package com.example.whosthatpokemon;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class Pokemon {
    private String name;
    String imageUrl;
    private Bitmap imageBitmap = null;

    public Pokemon(String name, String imageUrl){
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public class ConvertUrlToBitmap extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... imageUrls) {
            Bitmap imageBitmap = null;

            try {
                URL url = new URL(imageUrls[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                imageBitmap = BitmapFactory.decodeStream(inputStream);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return imageBitmap;
        }
    }

    public String getName(){
        return name;
    }

    public Bitmap getImage(){
        //if there is no bitmap then convert the URL to Bitmap
        if(imageBitmap == null){
            ConvertUrlToBitmap task = new ConvertUrlToBitmap();
            try {
                imageBitmap = task.execute(imageUrl).get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //return the bitmap
        return imageBitmap;
    }
}
