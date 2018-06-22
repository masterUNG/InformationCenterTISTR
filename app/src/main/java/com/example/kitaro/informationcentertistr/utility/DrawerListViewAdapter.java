package com.example.kitaro.informationcentertistr.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kitaro.informationcentertistr.R;

public class DrawerListViewAdapter extends BaseAdapter{

    private Context context;
    private String[] titleStrings;
    private int[] iconInts;

    public DrawerListViewAdapter(Context context,
                                 String[] titleStrings,
                                 int[] iconInts) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.iconInts = iconInts;
    }

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.listview_drawer, parent, false);

        ImageView imageView = view.findViewById(R.id.imvIcon);
        imageView.setImageResource(iconInts[position]);

        TextView textView = view.findViewById(R.id.txtTitle);
        textView.setText(titleStrings[position]);


        return view;
    }
}
