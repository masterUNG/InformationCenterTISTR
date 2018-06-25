package com.example.kitaro.informationcentertistr.utility;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kitaro.informationcentertistr.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ExpertRecyclerViewAdapter extends RecyclerView.Adapter<ExpertRecyclerViewAdapter.ExpertViewHolder>{

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

    @NonNull
    @Override
    public ExpertViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recyclerview_expert, parent, false);
        ExpertViewHolder expertViewHolder = new ExpertViewHolder(view);

        return expertViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExpertViewHolder holder, int position) {

        holder.nameTextView.setText(nameStringList.get(position));
        holder.surnameTextView.setText(surnameStringList.get(position));
        holder.specialTextView.setText(specialStringList.get(position));

        Picasso.get()
                .load(pictureStringList.get(position))
                .resize(150,150)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return nameStringList.size();
    }

    public class ExpertViewHolder extends RecyclerView.ViewHolder{

        TextView nameTextView, surnameTextView, specialTextView;
        ImageView imageView;


        public ExpertViewHolder(View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.txtName);
            surnameTextView = itemView.findViewById(R.id.txtSurName);
            specialTextView = itemView.findViewById(R.id.txtSpecial);
            imageView = itemView.findViewById(R.id.imvPicture);

        }
    }




}   // Main Class
