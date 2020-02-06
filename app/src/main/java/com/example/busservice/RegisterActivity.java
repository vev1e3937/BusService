package com.example.busservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.Statement;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

//    @SuppressLint("ResourceType")
//    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle saveInstanceState) {
//        return inflater.inflate(R.id.Sinup,container,false);
//    }

    EditText Username;
    EditText Password;
    EditText FirstName;
    EditText LastName;
    EditText Telephone;
    EditText Email;

    Button Confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

   /*     Button btnsup = (Button)findViewById(R.id.sinup);

     btnsup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(Sinup.this,MainActivity.class);
                startActivity(ii);
            }
        });*/

    }

    private void init() {
        Username = (EditText) findViewById(R.id.EdtUsername);
        Password = (EditText) findViewById(R.id.EdtPassword);
        Email = (EditText) findViewById(R.id.EdtEmail);
        FirstName = (EditText) findViewById(R.id.EdtFirstname);
        LastName = (EditText) findViewById(R.id.EdtLastname);
        Telephone = (EditText) findViewById(R.id.EdtTelephone);

        Confirm = (Button) findViewById(R.id.BtnConfirm);
        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**/


                switch (v.getId()) {
                    case R.id.BtnConfirm:
                        String username = Username.getText().toString();
                        String password = Password.getText().toString();
                        String email1 = Email.getText().toString();
                        String firstname = FirstName.getText().toString();
                        String lastname = LastName.getText().toString();
                        String telephone = Telephone.getText().toString();
                        //System.out.println(email1+" : " +phone1);
                        Pattern pusername = Pattern.compile("^[A-Za-z0-9 _]");
                        Pattern ppassword = Pattern.compile("^[A-Za-z0-9!@#$%^&*(())?>]");
                        Pattern ptelephone = Pattern.compile("^\\d{10}$");
//                        if (!pusername.matcher(username).find()) {
//                            Toast.makeText(getApplicationContext(), "รูปแบบid", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//                        if (!ppassword.matcher(password).find()) {
//                            Toast.makeText(getApplicationContext(), "รูปแบบpass", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//                        if (!Pattern.compile("^((\"[\\w-\\s]+\")|([\\w-]+(?:\\.[\\w-]+)*)|(\"[\\w-\\s]+\")([\\w-]+(?:\\.[\\w-]+)*))(@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$)|(@\\[?((25[0-5]\\.|2[0-4][0-9]\\.|1[0-9]{2}\\.|[0-9]{1,2}\\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\]?$)").matcher(email1).find()) {
//                            Toast.makeText(getApplicationContext(), "รูปแบบemail", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//                        if (!pusername.matcher(firstname).find()) {
//                            Toast.makeText(getApplicationContext(), "รูปแบบname", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//                        if (!ptelephone.matcher(lastname).find()) {
//                            Toast.makeText(getApplicationContext(), "รูปแบบlast", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//                        if (!ptelephone.matcher(telephone).find()) {
//                            Toast.makeText(getApplicationContext(), "รูปแบบphone", Toast.LENGTH_SHORT).show();
//                            return;
//                        }


                        System.out.println("Connect database");

                        try {
                            Connection conn = Connect.connection();
                            if (conn != null) {
//                                        Statement scheat = conn.createStatement();
//                                        ResultSet rs = scheat.executeQuery("Select Username from customers where Username ='"+user+"'");
//                                        while(rs.next()){
//                                            if(rs.getString("Username") != "")
//                                                return;
//                                        }
//                                        scheat.close();
                                System.out.println("Connect database");
                                String sql = "INSERT INTO `customer`( `first_name`, `last_name`, `username`, `password`, `email`, `telephone`) VALUES ('" + firstname + "','" + lastname + "','" + username + "','" + password + "','" + email1 + "','" + telephone + "')";
                                Statement statement = conn.createStatement();
                                statement.execute(sql);
                                Intent k = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(k);
                                Toast.makeText(getApplicationContext(), "สมัครสำเร็จ", Toast.LENGTH_SHORT).show();
                                Username.setText("");
                                Password.setText("");
                                FirstName.setText("");
                                LastName.setText("");
                                Email.setText("");
                                Telephone.setText("");
                                return;
                            } else {
                                System.out.println("NOT Connect database");
                            }


                        } catch (Exception e) {
                        }
                }
            }
        });
    }

    // TODO: 1/28/2020
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BtnConfirm:
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                String email = Email.getText().toString();
                String firstname = FirstName.getText().toString();
                String lastname = LastName.getText().toString();
                String telephone = Telephone.getText().toString();


                System.out.println("Connect database");

        }
    }
}
