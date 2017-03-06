package com.example.d3rrick.malaysiatravelerguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class places_selection extends AppCompatActivity {

    String index;
    DatabaseHelper myDb;
    ListView lv;
    SearchView sv;
    ArrayAdapter<String> adapter;
    String selected_place;

    private static final String STATE_COUNTER = "counter";
    private int mCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_selection);

        Intent i = getIntent();
        index = i.getStringExtra("index");
        myDb = new DatabaseHelper(this);
        final String[] places = myDb.getPlaces(index);

        lv= (ListView) findViewById(R.id.place_listview);
        adapter = new ArrayAdapter<String>(this, R.layout.listview_layout, R.id.listview_txt, places);
        lv.setAdapter(adapter);

       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               selected_place = places[position];
               Intent i = new Intent(places_selection.this, place_info.class);
               i.putExtra("index" , selected_place);
               startActivity(i);
           }
       });

        sv= (SearchView)findViewById(R.id.search_input);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        if (savedInstanceState != null) {
            mCounter = savedInstanceState.getInt(STATE_COUNTER, 0);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_COUNTER, mCounter);
    }
}
