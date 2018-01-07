package com.example.fahee.volleyexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String URL = "https://api.github.com/users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView userList = (RecyclerView) findViewById(R.id.userList);
        userList.setLayoutManager(new LinearLayoutManager(this));

        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("CODE",response);
                GsonBuilder gsonbuilder = new GsonBuilder();
                Gson gson = gsonbuilder.create();
                User[] user = gson.fromJson(response,User[].class);
                userList.setAdapter(new GithubAdpater(MainActivity.this,user));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this,"Some thing is wrong",Toast.LENGTH_LONG).show();
            }
        });


        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);

    }

}
