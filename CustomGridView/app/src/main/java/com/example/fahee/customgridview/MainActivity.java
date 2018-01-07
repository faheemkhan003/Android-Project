package com.example.fahee.customgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   GridView gridView;

    String letterList[] ={"Pakistan","Australian","india","new zealand","bangladesh","south African","ireland","sri lanka","westen dies","afghanistan"};
    int letterIcon[] = {R.drawable.flagpak1,R.drawable.flagaus2,R.drawable.flagind3,R.drawable.flagnew4,R.drawable.flagban5,R.drawable.flagsou6,R.drawable.flagirland7,R.drawable.flagsirlannk8,R.drawable.flagwed9,R.drawable.flagafg10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);

        CustomAdapter adapter = new CustomAdapter(MainActivity.this,letterIcon,letterList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Select Flag"+letterList[position],Toast.LENGTH_LONG).show();
            }
        });
    }
}
