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

public class ListViewNotification extends Activity{

    ListView listView;
    CustomObject co;
    CustomAdapter customAdapter;

//    ArrayList<CustomObject> objects = new ArrayList<CustomObject>();
//    CustomAdapter customAdapter = new CustomAdapter(this, objects);
//    final LayoutInflater mInflator;
    //    @Override
String[] values1 = new String[]{"Hey! Your Getaway Cafe is on the way!", "Hey! Your Getaway Cafe is on the way!\n10 minutes ago"};
    String[] values2 = new String[]{"Hey! Your BCD tofu house is on the way!", "Hey! Your BCD tofu house is on the way\nMarch 3rd, 2018"};
    String[] values3 = new String[]{"Hey! Your Ruth's Chris Steak House is on the way!", "Hey! Your Ruth's Chris Steak House is on the way!\nJanuary 29th, 2018"};
    String[] values4 = new String[]{"Hey! Your Nobu Malibu is on the way!", "Hey! Your Nobu Malibu is on the way!\nNow"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_listview);
        listView = (ListView) findViewById(R.id.mlistview);

//        String[] first1 = new String[] {  "Hey! Your Getaway Cafe is on the way!", "Hey! Your BCD tofu house is on the way!" ,"Hey! Your Ruth's Chris Steak House is on the way!"};
//        String[] first2 = new String[] {"10 minutes ago","March 3rd, 2018", "January 29th, 2018"};
//        final LayoutInflater mInflator = LayoutInflater.from(this);
//        ListView lv = (ListView) find

//        Log.d("Test", " This is working?" + this.toString());
        ArrayList<CustomObject> objects = new ArrayList<CustomObject>();
        co = new CustomObject(values4[0],values4[1]);
        objects.add(co);
        Log.d("Test", " This is working??" + objects.get(0).getProp1() + " " + objects.get(0).getProp2());
        co = new CustomObject(values1[0],values1[1]);

        objects.add(co);
        co = new CustomObject(values2[0],values2[1]);
        objects.add(co);
        co = new CustomObject(values3[0],values3[1]);
        objects.add(co);
        customAdapter = new CustomAdapter(ListViewNotification.this, objects);
//        customAdapter.notifyDataSetChanged();
        listView.setAdapter(customAdapter);
        Log.d("Test", " This is working" + objects.get(3).getProp1() + " " + objects.get(3).getProp2());
//        listView = (ListView) findViewById(R.id.listview);



//        final ArrayList
//        listView = getListView();
//        listView.setAdapter(new ArrayAdapter<String>(this,R.layout.item,values1));
//        listView.setOnItemClickListener(this);
//        listView.setAdapter(new ArrayAdapter<String>(this,R.layout.item,values2));
//        listView.setOnItemClickListener(this);
//listView.setAdapter(new ArrayAdapter<String>(this,R.layout.item,values3));
//        listView.setOnItemClickListener(this);



//        co.setProp(values1[0], values1[1]);
//        listView.setAdapter();
//        listView.setAdapter(customAdapter);

//        display();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);

    }
    //    private void display()
    /*
    public View getView (int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = convertView;
//        ViewHolder holder = null;

        listView = (ListView) findViewById(R.id.listview);
        System.out.println("Enters");
//        if(convertView == null)
//        {
//            convertView = LayoutInflater.from(this).inflate(R.layout.item, null);
//
//        }
//        Log.d("Test",values1[0] + " " + values1[1]);
//        ((TextView) convertView.findViewById(R.id.firstLine)).setText(values1[0]);
//        ((TextView) convertView.findViewById(R.id.secondLine)).setText(values1[1]);
//        listView.setAdapter(customAdapter);
//        return convertView;
    }*/
}
