package com.example.kitaro.informationcentertistr.utility;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kitaro.informationcentertistr.R;

import java.util.List;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.MyViewHolder>{

    private Context context;
    private List<String> titleStringList, detailStringList;
    private LayoutInflater layoutInflater;
    private OnClickItem onClickItem;


    public ProductRecyclerViewAdapter(Context context,
                                      List<String> titleStringList,
                                      List<String> detailStringList,
                                      OnClickItem onClickItem) {
        this.layoutInflater = LayoutInflater.from(context);
        this.titleStringList = titleStringList;
        this.detailStringList = detailStringList;
        this.onClickItem = onClickItem;
    }   // Constructor

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recyclerview_produce, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        String titleString = titleStringList.get(position);
        String detailString = detailStringList.get(position);

        holder.titleTextView.setText(titleString);
        holder.detailTextView.setText(detailString);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem.onClickItem(v, holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return titleStringList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView titleTextView, detailTextView;

        public MyViewHolder(View itemView) {
            super(itemView);

//            Initial View
            titleTextView = itemView.findViewById(R.id.txtTitle);
            detailTextView = itemView.findViewById(R.id.txtDetail);


        }   // Constructor

    }   // MyViewHolder Class

}   // Main Class
