package com.example.icedup;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewBag extends AppCompatActivity {

    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bag);
        ListView listView;
        listView = findViewById(R.id.ListView);
        myDB = new DatabaseHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        if(data.getCount() == 0) {
            Toast.makeText(this, "database is empty", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "database is loading", Toast.LENGTH_LONG).show();
            while(data.moveToNext()) {
                theList.add(data.getString(2));
                theList.add(data.getString(3));
                theList.add(data.getString(4));
                ListAdapter listAdapter;
                listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listAdapter);
            }
        }
    }
}