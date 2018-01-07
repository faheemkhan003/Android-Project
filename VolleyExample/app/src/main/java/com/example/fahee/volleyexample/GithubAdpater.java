package com.example.fahee.volleyexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * Created by fahee on 1/6/2018.
 */

public class GithubAdpater extends RecyclerView.Adapter<GithubAdpater.GithubViewHolder>{

    private Context context;
    private User[] data;
    public GithubAdpater(Context context,User[] data){

        this.context = context;
        this.data = data;
    }
    @Override
    public GithubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user_layout,parent,false);
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GithubViewHolder holder, int position) {

        final User user = data[position];
        holder.txtUser.setText(user.getLogin());
        Glide.with(holder.imgUser.getContext()).load(user.getAvatarUrl()).into(holder.imgUser);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,user.getLogin() + "was Click", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class GithubViewHolder extends RecyclerView.ViewHolder{

        ImageView imgUser;
        TextView txtUser;

        public GithubViewHolder(View itemView) {
            super(itemView);

            imgUser = (ImageView) itemView.findViewById(R.id.imgUser);
            txtUser = (TextView) itemView.findViewById(R.id.txtUser);
        }
    }
}
