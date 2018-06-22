package com.example.kitaro.informationcentertistr.utility;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ExpertRecyclerViewAdapter {

    private Context context;
    private List<String> nameStringList, surnameStringList,
            specialStringList, pictureStringList;
    private LayoutInflater layoutInflater;

    public ExpertRecyclerViewAdapter(Context context,
                                     List<String> nameStringList,
                                     List<String> surnameStringList,
                                     List<String> specialStringList,
                                     List<String> pictureStringList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.nameStringList = nameStringList;
        this.surnameStringList = surnameStringList;
        this.specialStringList = specialStringList;
        this.pictureStringList = pictureStringList;
    }

    public class ExpertViewHolder extends RecyclerView.ViewHolder{

        TextView nameTextView, surnameTextView, specialTextView;
        ImageView imageView;


        public ExpertViewHolder(View itemView) {
            super(itemView);



        }
    }




}   // Main Class
