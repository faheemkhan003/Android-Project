package com.example.fahee.contectmanagersqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    Button insert,searchData,delete,update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        insert = (Button) findViewById(R.id.btnAdd);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddNewContact.class);
                startActivity(intent);
            }
        });

        searchData= (Button) findViewById(R.id.btnSearch);

        searchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SearchData.class);
                startActivity(intent);
            }
        });

        delete= (Button) findViewById(R.id.btnDelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,DeleteData.class);
                startActivity(intent);
            }
        });

        update = (Button) findViewById(R.id.btnUpdate);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UpdateActivity.class);
                startActivity(intent);
            }
        });

    }

}
