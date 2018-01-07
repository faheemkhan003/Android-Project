package com.example.fahee.customlistadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

     ListView lv;
     int icons[]={R.drawable.cc1,R.drawable.cc2,R.drawable.cc3,R.drawable.cc4,R.drawable.cc5};
     String numbers[] = {"ONE","TWO","THREE","FOUR","FIVE"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ListView) findViewById(R.id.list_item);
        lv.setAdapter(new CustomAdapter(MainActivity.this,icons,numbers));
    }
}
