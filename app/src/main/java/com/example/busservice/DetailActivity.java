package com.example.busservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.adedom.library.Dru;
import com.adedom.library.ExecuteQuery;
import com.bumptech.glide.Glide;
import com.example.busservice.Bean.BusBean;
import com.example.busservice.util.ResultSetConvert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";

    private TextView bus_detail;
    private TextView price;
    private ImageView images;
    public static String mbus_id;
    private ArrayList<BusBean> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        bus_detail = findViewById(R.id.bus_detail);
        price = findViewById(R.id.price);
        images = findViewById(R.id.img_pic);


        Button BtnBooking = (Button)findViewById(R.id.BtnBooking);
        BtnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailActivity.this,BookingActivity.class);
                startActivity(i);
            }
        });

        String bus_id = getIntent().getStringExtra("bus_id");

        String sql = " SELECT * FROM bus WHERE bus_id = '" + bus_id + "'";
        Dru.connection(Connect.connection())
                .execute(sql)
                .commit(new ExecuteQuery() {
                    @Override
                    public void onComplete(ResultSet resultSet) {
                        try {
                            HashMap mapping = new HashMap();
                            mapping = ResultSetConvert.ConvertToMap(resultSet);
                            mbus_id = mapping.get("bus_id").toString();
                            bus_detail.setText((String) mapping.get("bus_detail"));
                            price.setText((String) mapping.get("price"));

                            System.out.println((String) mapping.get("bus"));
                            Glide.with(images.getRootView())
                                    .load((String) mapping.get("images"))
                                    .into(images);
//
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                });



    }
}
