package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView myFriendList = (ListView) findViewById(R.id.myFriendList);
        final ArrayList<String> myFriends = new ArrayList<String>();

        myFriends.add("Matthew");
        myFriends.add("Eddie");
        myFriends.add("Irvin");
        myFriends.add("Grecia");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFriends);
        myFriendList.setAdapter(arrayAdapter);
        myFriendList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "" + myFriends.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
