package com.example.busservice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.adedom.library.Dru;
import com.adedom.library.ExecuteUpdate;

import java.sql.Connection;
import java.sql.Time;
import java.util.Date;

import static com.example.busservice.DetailActivity.mbus_id;

public class BookingActivity extends AppCompatActivity {
    private TextView Start;
    private TextView destination;
    private DatePicker start_date;
    private DatePicker stop_date;
    private TimePicker start_time;
    private TimePicker stop_time;
    public String bus_id = mbus_id;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Button BtnConfirm = (Button)findViewById(R.id.BtnConfirm);
        Start = findViewById(R.id.EdtStart);
        destination =findViewById(R.id.EdtDestination);
        start_date = findViewById(R.id.EdtDepartureDate);
        stop_date = findViewById(R.id.EdtReturnDate);
        start_time = findViewById(R.id.EdtStartTime);
        stop_time = findViewById(R.id.EdtEndTime);

        BtnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sql = "INSERT INTO booking (Start,destination, start_date,stop_date,start_time,stop_time,bus_id) VALUES ('"+Start+"','"+destination+"', '" + start_date+ "','"+stop_date+"','"+start_time+"','"+stop_time+"','"+mbus_id+"')";
                Dru.connection(Connect.connection())
                        .execute(sql)
                        .commit(new ExecuteUpdate() {
                            @Override
                            public void onComplete() {

                            }

                        });
                Toast.makeText(getApplicationContext(), "จองเรีบยร้อย", Toast.LENGTH_SHORT).show();
            }


        });
    }
}
