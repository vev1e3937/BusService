package com.example.busservice;

import com.adedom.library.Dru;

import java.sql.Connection;

public class Connect {
    public static Connection connection(){
        return Dru.connection("192.168.43.86","micky1","1111","appdb");
    }
}
