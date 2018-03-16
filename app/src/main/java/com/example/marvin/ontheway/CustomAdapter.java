package com.example.marvin.ontheway;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Judy Lee on 3/13/2018.
 */

public class CustomAdapter extends BaseAdapter{

    ListView listView;
    final LayoutInflater mInflator;

    String[] values1 = new String[] {  "Hey! Your Getaway Cafe is on the way!", "10 minutes ago"};
    String[] values2 = new String[] {  "Hey! Your Getaway Cafe is on the way!", "March 3rd, 2018"};
    String[] values3 = new String[] {  "Hey! Your Getaway Cafe is on the way!", "January 29th, 2018"};
    String[] values4 = new String[] {  "Hey! Your Nobu Malibu is on the way!", "Now"};
    private ArrayList<CustomObject> objects;
    private class ViewHolder
    {
        TextView textView1;
        TextView textView2;
    }
    public CustomAdapter(Context context, ArrayList<CustomObject> objects) {
        mInflator = LayoutInflater.from(context);
//        super(context, objects);
        this.objects = objects;
    }
    public int getCount() {
        return objects.size();
    }

    public CustomObject getItem(int position) {
        return objects.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder = null;
        if(convertView == null) {
            holder = new ViewHolder();
            convertView = mInflator.inflate(R.layout.item, null);
//            holder.textView1 = (TextView) convertView.findViewById(R.id.messages);

            holder.textView2 = (TextView) convertView.findViewById(R.id.secondLine);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
//        holder.textView1.setText(objects.get(position).getProp1());
        Log.d("Test" , "heyy " + objects.get(position).getProp1());
        holder.textView2.setText(objects.get(position).getProp2());

        return convertView;
    }
}
