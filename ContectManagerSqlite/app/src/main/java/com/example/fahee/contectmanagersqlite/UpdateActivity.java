package com.example.fahee.contectmanagersqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    EditText name,email,number;
    Button update;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        databaseHelper= new DatabaseHelper(this);
        name= (EditText) findViewById(R.id.etName);
        email= (EditText) findViewById(R.id.etEmail);
        number= (EditText) findViewById(R.id.etNumber);
        update = (Button) findViewById(R.id.btnUpdate);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseHelper.updateData(number.getText().toString(),name.getText().toString(),email.getText().toString());
            }
        });
    }
}
