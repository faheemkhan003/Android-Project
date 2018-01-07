package com.example.fahee.contectmanagersqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewContact extends AppCompatActivity {

    EditText name,mobile_number,email;
    Button save;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        name= (EditText) findViewById(R.id.etName);
        mobile_number= (EditText) findViewById(R.id.etMobileNumber);
        email= (EditText) findViewById(R.id.etEmail);
        save= (Button) findViewById(R.id.btnSave);
        databaseHelper = new DatabaseHelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             boolean result= databaseHelper.insertData(name.getText().toString(),Integer.parseInt(mobile_number.getText().toString()),email.getText().toString());

                if(result)
                    Toast.makeText(AddNewContact.this,"DATA INSERTED",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(AddNewContact.this,"DATA NOT INSERTED",Toast.LENGTH_LONG).show();

            }
        });
    }
}
