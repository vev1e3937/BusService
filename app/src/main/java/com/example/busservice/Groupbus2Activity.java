package com.example.busservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Groupbus2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupbus2);

        ImageButton Img2 = (ImageButton)findViewById(R.id.Img2);
        Img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Groupbus2Activity.this,DetailActivity.class);
                startActivity(i);
            }
        });
    }
}
