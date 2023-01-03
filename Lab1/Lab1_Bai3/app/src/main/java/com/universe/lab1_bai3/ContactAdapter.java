package com.universe.lab1_bai3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends BaseAdapter {

    private ArrayList<MyContact> contacts;
    private Activity activity;

    public ContactAdapter(Activity activity, ArrayList<MyContact> values){
        this.contacts = values;
        this.activity = activity;
    }
    @Override
    public int getCount() {
        return this.contacts.size();
    }

    @Override
    public Object getItem(int i) {
        return contacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.contact_item, null);
        TextView txtContactName = view.findViewById(R.id.txtContactName);
        txtContactName.setText(contacts.get(i).toString());

        return view;
    }
}
