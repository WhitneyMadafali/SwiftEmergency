package com.whitney.swiftemergency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView markertxt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        markertxt = findViewById(R.id.marker);
        //get data from maps activity
        String title = getIntent().getStringExtra("title");
        markertxt.setText(title);
    }

    public void Call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0712345678"));
        startActivity(intent);
    }
}