package com.example.fahee.recyclegridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fahee.recyclegridview.Adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GridLayoutManager layoutManager;
    String nameList[]= {"Batsmen1","Batsmen2","Batsmen3","Batsmen4","Batsmen5","Batsmen6","Batsmen7","Batsmen8","Batsmen9","Batsmen10","Batsmen11","Batsmen12"};
    int iconId[] = {R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,R.drawable.c11,R.drawable.c12};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(MainActivity.this,3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this,iconId,nameList);
        recyclerView.setAdapter(myAdapter);
    }
}
