package com.example.busservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.adedom.library.Dru;
import com.adedom.library.ExecuteQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity {

    private Button Login;
    private Button Register;
    private EditText Userneme;
    private EditText Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (Connect.connection() == null) {
            Dru.failed(getBaseContext());
        } else {
            Dru.completed(getBaseContext());
        }

        Userneme = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);
        Login = (Button) findViewById(R.id.Login);
        Register = (Button) findViewById(R.id.Register);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String sql = "SELECT * FROM `customer` WHERE `username`='" + Userneme.getText().toString().trim() + "'AND`password`='" + Password.getText().toString().trim() + "'";
                Dru.connection(Connect.connection())
                        .execute(sql)
                        .commit(new ExecuteQuery() {
                            @Override
                            public void onComplete(ResultSet resultSet) {
                                try {
                                    Connection conn = Connect.connection();
                                    if (resultSet.next()) {
                                        // TODO: 11/6/2019
                                        String id = resultSet.getString(1);
                                        Toast.makeText(getBaseContext(), "เข้าสู่ระบบ", Toast.LENGTH_SHORT).show();

                                        startActivity(new Intent(getApplication(), busActivity.class)
                                        );
                                    } else {
                                        Toast.makeText(getBaseContext(), "รหัสไม่ถูกต้อง", Toast.LENGTH_SHORT).show();
                                    }

                                } catch (SQLException e) {
                                    e.printStackTrace();

                                }
                            }
                        });

            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), RegisterActivity.class));

            }
        });

    }
}
