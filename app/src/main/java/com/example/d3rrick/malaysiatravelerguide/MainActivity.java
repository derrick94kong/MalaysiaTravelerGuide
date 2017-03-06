package com.example.d3rrick.malaysiatravelerguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    ArrayAdapter<String> adapter;
    String selected_state;
    DatabaseHelper myDb;

    Button mSearchButton;

    private static final String STATE_COUNTER = "counter";
    private int mCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        final String[] state = myDb.getStates();
        sp = (Spinner) findViewById(R.id.provinces_spinner);
        adapter = new ArrayAdapter<String>(this, R.layout.spinner_layout, R.id.spinner_txt, state);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_state = state[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        mSearchButton = (Button) findViewById(R.id.search_button);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, places_selection.class);
                i.putExtra("index" , selected_state);
                startActivity(i);
            }
        });

        if (savedInstanceState != null) {
            mCounter = savedInstanceState.getInt(STATE_COUNTER, 0);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_COUNTER, mCounter);
    }
}
