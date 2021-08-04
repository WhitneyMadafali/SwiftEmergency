package com.whitney.swiftemergency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;

public class Services extends AppCompatActivity implements View.OnClickListener {

    public CardView card1, card2, card3, card4, card5, card6;
    String name1, name2, name3, name4, name5, name6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        card1 = (CardView) findViewById(R.id.FIRE);
        card2 = (CardView) findViewById(R.id.POLICE);
        card3 = (CardView) findViewById(R.id.AMBULANCE);
        card4 = (CardView) findViewById(R.id.ROAD_ACCIDENT);
        card5 = (CardView) findViewById(R.id.FLOODS);
        card6 = (CardView) findViewById(R.id.VIOLENCE);

        name1 = "FIRE";
        name2 = "POLICE";
        name3 = "AMBULANCE";
        name4 = "ROAD ACCIDENT";
        name5 = "FLOODS";
        name6 = "VIOLENCE";

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.AMBULANCE:
                i = new Intent(this, Map1.class);
                startActivity(i);
                break;


        }

    }
}
