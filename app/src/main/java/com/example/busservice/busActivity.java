package com.example.busservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.adedom.library.Dru;
import com.adedom.library.ExecuteQuery;
import com.bumptech.glide.Glide;
import com.example.busservice.Bean.BusBean;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class busActivity extends AppCompatActivity {

    private static final String TAG = "busActivity";

    private RecyclerView mRecyclerView;

    private ArrayList<BusBean> items;

    private Chip mChip1;
    private Chip mChip2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        String sql = "SELECT * FROM bus ";
        Dru.connection(Connect.connection())
                .execute(sql)
                .commit(new ExecuteQuery() {
                    @Override
                    public void onComplete(ResultSet resultSet) {
                        try {
                            items = new ArrayList<BusBean>();
                            while (resultSet.next()) {
                                // TODO: 2019-11-10
                                items.add(new BusBean(
                                        resultSet.getString("bus_id"),
                                        resultSet.getString("bus_name"),
                                        resultSet.getString("bus_detail"),
                                        resultSet.getString("images"),
                                        resultSet.getString("price"))
                                );
                            }
                            mRecyclerView.setAdapter(new CustomAdapter());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });


        mChip1 = (Chip) findViewById(R.id.chip1);
        mChip2 = (Chip) findViewById(R.id.chip2);


            mChip1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String sql = "SELECT * FROM bus WHERE type_id ='1'";
                    Dru.connection(Connect.connection())
                            .execute(sql)
                            .commit(new ExecuteQuery() {
                                @Override
                                public void onComplete(ResultSet resultSet) {
                                    try {
                                        items = new ArrayList<BusBean>();
                                        while (resultSet.next()) {
                                            // TODO: 2019-11-10
                                            items.add(new BusBean(
                                                    resultSet.getString("bus_id"),
                                                    resultSet.getString("bus_name"),
                                                    resultSet.getString("bus_detail"),
                                                    resultSet.getString("images"),
                                                    resultSet.getString("price"))
                                            );
                                        }
                                        mRecyclerView.setAdapter(new CustomAdapter());
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                }
            });

            mChip2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String sql = "SELECT * FROM bus WHERE type_id ='2'";
                    Dru.connection(Connect.connection())
                            .execute(sql)
                            .commit(new ExecuteQuery() {
                                @Override
                                public void onComplete(ResultSet resultSet) {
                                    try {
                                        items = new ArrayList<BusBean>();
                                        while (resultSet.next()) {
                                            // TODO: 2019-11-10
                                            items.add(new BusBean(
                                                    resultSet.getString("bus_id"),
                                                    resultSet.getString("bus_name"),
                                                    resultSet.getString("bus_detail"),
                                                    resultSet.getString("images"),
                                                    resultSet.getString("price"))
                                            );
                                        }
                                        mRecyclerView.setAdapter(new CustomAdapter());
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                }
            });



    }
    class CustomAdapter extends RecyclerView.Adapter<CustomHolder> {
        @NonNull
        @Override
        public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bus, parent, false);
            return new CustomHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
            BusBean item = items.get(position);

            holder.bus_name.setText(item.getbus_name());
//

            //image

            Glide.with(holder.itemView)
                    .load(item.getImages())
//                    .circleCrop()
                    .into(holder.images);

            Log.d(TAG, "onBindViewHolder: " + "192.168.1.36/tmk/" + item.getImages());
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }

    class CustomHolder extends RecyclerView.ViewHolder {

        private final TextView bus_name;
        private final ImageView images;

        public CustomHolder(@NonNull View itemView) {
            super(itemView);

            bus_name = (TextView) itemView.findViewById(R.id.tv_bus);
//           tvDetail = (TextView) itemView.findViewById(R.id.tv_detail);
//            tvProvince = (TextView) itemView.findViewById(R.id.tv_province);
            images = (ImageView) itemView.findViewById(R.id.img_pic);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BusBean item = items.get(getAdapterPosition());
                    startActivity(new Intent(getBaseContext(), DetailActivity.class)
                            .putExtra("bus_id", item.getBus_id())
                    );
                }
            });
        }
    }
}
