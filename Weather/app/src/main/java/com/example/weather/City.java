package com.example.weather;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class City {
    String name;
    double temperatureC;
    double temperatureF;
    String humidity;
    String description;
    String cityUrl;

    public City(String name){
        this.name = name;
        cityUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + name + "&APPID=0697fcbd0157bf54c81316d4a75b4b83";
        DownloadTask task = new DownloadTask();


        try {
            String result = task.execute(cityUrl).get();

            //Get Description
            JSONObject jsonObject = new JSONObject(result);
            String weather = jsonObject.getString("weather");
            Log.i("weather", weather);

            JSONArray weatherArray = new JSONArray(weather);
            description = weatherArray.getJSONObject(0).getString("description");


            //Get Temperature
            String main = jsonObject.getString("main");
            Log.i("main", main);

            JSONObject JSONMain = new JSONObject(main);
            Double temperatureK = Double.parseDouble(JSONMain.getString("temp"));
            temperatureC = (temperatureK - 273);
            temperatureF = (temperatureC * (9.0/5.0) + 32);

            //Get Humidity
            humidity = JSONMain.getString("humidity");

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getInfo(){
        int C = (int) temperatureC;
        int F = (int) temperatureF;
        String nameString = "Name: " + name + "\n";
        String temperatureString = "Temperature: " + C + "C or " + F + "F\n";
        String humidityString = "Humidity: " + humidity + "%\n";
        String descriptionString = "Description: " + description;

        return nameString + temperatureString + humidityString + descriptionString;
    }

    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls){
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();

                Scanner s = new Scanner(inputStream).useDelimiter("\\A");
                String result = s.hasNext() ? s.next() : "";
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
        }
    }
}
