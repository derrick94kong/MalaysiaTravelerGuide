package com.example.d3rrick.malaysiatravelerguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.UnderlineSpan;
import android.widget.ImageView;
import android.widget.TextView;

public class place_info extends AppCompatActivity {

    String index;
    ImageView place_image;
    TextView place_name, place_info;
    DatabaseHelper myDb;

    private static final String STATE_COUNTER = "counter";
    private int mCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_info);

        Intent i = getIntent();
        index = i.getStringExtra("index");
        myDb = new DatabaseHelper(this);

        place_image = (ImageView) findViewById(R.id.place_image);
        getImage(index);

        place_name = (TextView) findViewById(R.id.place_name);
        SpannableString content = new SpannableString(index);
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        place_name.setText(content);

        place_info = (TextView) findViewById(R.id.place_information);
        place_info.setText(myDb.getInfo(index));

        if (savedInstanceState != null) {
            mCounter = savedInstanceState.getInt(STATE_COUNTER, 0);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_COUNTER, mCounter);
    }

    public  void getImage (String place){
        switch(place){
            case "A Famosa":
                place_image.setImageResource(R.drawable.a_famosa);
                break;
            case "Baba Nyonya Heritage Museum":
                place_image.setImageResource(R.drawable.baba_nyonya_heritage_museum);
                break;
            case "Bario":
                place_image.setImageResource(R.drawable.bario);
                break;
            case "Batu Ferringhi":
                place_image.setImageResource(R.drawable.batu_ferringhi);
                break;
            case "Christ Church":
                place_image.setImageResource(R.drawable.christ_church);
                break;
            case "Danum Valley Conservation Area":
                place_image.setImageResource(R.drawable.danum_valley_conservation_area);
                break;
            case "Escape Theme Park":
                place_image.setImageResource(R.drawable.escape_theme_park);
                break;
            case "Gunung Mulu National Park":
                place_image.setImageResource(R.drawable.gunung_mulu_national_park);
                break;
            case "Jonker Walk":
                place_image.setImageResource(R.drawable.jonker_walk);
                break;
            case "Kek Lok Si Temple":
                place_image.setImageResource(R.drawable.kek_lok_si_temple);
                break;
            case "Kinabalu Park":
                place_image.setImageResource(R.drawable.kinabalu_park);
                break;
            case "Kota Kinabalu":
                place_image.setImageResource(R.drawable.kota_kinabalu);
                break;
            case "Kuala Lumpur Tower":
                place_image.setImageResource(R.drawable.kuala_lumpur_tower);
                break;
            case "Kuching":
                place_image.setImageResource(R.drawable.kuching);
                break;
            case "Marudi":
                place_image.setImageResource(R.drawable.marudi);
                break;
            case "Merdeka Square":
                place_image.setImageResource(R.drawable.merdeka_square);
                break;
            case "Penang Hill":
                place_image.setImageResource(R.drawable.penang_hill);
                break;
            case "Petaling Street":
                place_image.setImageResource(R.drawable.petaling_street);
                break;
            case "Petronas Towers":
                place_image.setImageResource(R.drawable.petronas_towers);
                break;
            case "Turtle Islands National Park":
                place_image.setImageResource(R.drawable.turtle_island);
                break;
        }
    }
}
