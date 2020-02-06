package com.example.busservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class GroupbusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupbus);

        ImageButton Img1 = (ImageButton)findViewById(R.id.Img1);
        Img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GroupbusActivity.this,DetailActivity.class);
                startActivity(i);
            }
        });
    }
}
