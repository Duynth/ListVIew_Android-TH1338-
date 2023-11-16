package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Listview extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<String> list;
    public Adapter_Listview(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context= context;
        this.resource = resource;
        this.list = (ArrayList<String>) objects;
    }

    private class ViewHolder{
        ImageView img;
        TextView tv;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview,parent,false);

            viewHolder.img =convertView.findViewById(R.id.item_img);
            viewHolder.tv = convertView.findViewById(R.id.item_textview);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        String hoten = list.get(position);
        viewHolder.tv.setText(hoten);

        return  convertView;
    }
}
