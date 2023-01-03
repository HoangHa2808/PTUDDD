package com.example.listviewdemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<String> {
    Activity context;
    String[] titles;
    String[] contents;
    Integer[] imgs;

    public MyAdapter(@NonNull Context context, int resource, Activity context1, String[] titles, String[] contents, Integer[] imgs) {
        
        super(context, resource);
        this.context = context1;
        this.titles = titles;
        this.contents = contents;
        this.imgs = imgs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater= context.getLayoutInflater();
        View itemView= inflater.inflate(R.layout.mylist,null,true );
        ImageView imgIcon=itemView.findViewById(R.id.imageIcon);
        TextView txtViewContent = itemView.findViewById(R.id.txtContent);
        TextView txtViewTitle = itemView.findViewById(R.id.txtTitle);

        imgIcon.setImageResource(imgs[position]);
        txtViewContent.setText(contents.toString());
        txtViewTitle.setText(titles.toString());
        return itemView;
    }
}
