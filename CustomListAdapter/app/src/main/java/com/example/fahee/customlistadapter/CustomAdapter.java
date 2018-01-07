package com.example.fahee.customlistadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by fahee on 12/29/2017.
 */

public class CustomAdapter extends BaseAdapter {

   Context context;
    static LayoutInflater inflater =null;
    int icons[];
    String numbers[];


    CustomAdapter(Context context,int icons[],String numbers[]){
         this.context=context;
        this.icons=icons;
        this.numbers=numbers;
   }

    @Override
    public int getCount() {
        return numbers.length;
    }

    @Override
    public Object getItem(int position) {
        return getItemId(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if(row==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.list_of_rows,null);

        }

        ImageView img = (ImageView) row.findViewById(R.id.imageView);
        TextView tv = (TextView) row.findViewById(R.id.textView);

        img.setImageResource(icons[position]);
        tv.setText(numbers[position]);




        return row;
    }
}
