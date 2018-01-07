package com.example.fahee.baseadapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listview);
        list.setAdapter(new VivzAdapter(this));
    }

}
 class SingleRow{
     String title;
     String description;
     int image;
     SingleRow(String titles,String description,int images){
       this.title=titles;
         this.description=description;
         this.image = images;
     }
 }

  class VivzAdapter extends BaseAdapter{
     ArrayList<SingleRow>list;
      Context context;
       VivzAdapter(Context c){
           context=c;
          list= new ArrayList<SingleRow>();
           Resources res = c.getResources();
           String[] titles = res.getStringArray(R.array.titles);
           String[] description = res.getStringArray(R.array.descriptions);
           int images[]={R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,R.drawable.c11,R.drawable.c12};
         for(int i=0; i<12; i++){
             list.add(new SingleRow(titles[i],description[i],images[i]));

         }
       }

      @Override
      public int getCount() {
          return list.size();
      }

      @Override
      public Object getItem(int i) {
          return list.get(i);
      }

      @Override
      public long getItemId(int i) {
          return i;
      }

      @Override
      public View getView(int i, View convertView, ViewGroup parent) {

          LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          View row = inflater.inflate(R.layout.single_row,parent,false);
          TextView title= (TextView) row.findViewById(R.id.textView);
          TextView description = (TextView) row.findViewById(R.id.textView2);
          ImageView image = (ImageView) row.findViewById(R.id.imageView);

          SingleRow temp=list.get(i);
          title.setText(temp.title);
          description.setText(temp.description);
          //Log.d((""), "getView: "+temp.images);
          //image.setImageResource(temp.image);
          return row;
      }
  }