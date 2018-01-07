package com.example.fahee.contectmanagersqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchData extends AppCompatActivity {

   EditText searchText;
    TextView name,email;
    Button search;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);

        searchText = (EditText) findViewById(R.id.etSearch);
        name= (TextView) findViewById(R.id.tvName);
        email= (TextView) findViewById(R.id.tvEmail);
        search= (Button) findViewById(R.id.btSearch);
        databaseHelper = new DatabaseHelper(this);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Cursor cursor = databaseHelper.getData(searchText.getText().toString());
                while (cursor.moveToNext()){
                    name.setText(cursor.getString(1));
                    email.setText(cursor.getString(3));

                }
            }
        });
    }
}
