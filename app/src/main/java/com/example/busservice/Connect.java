package com.example.busservice;

import com.adedom.library.Dru;

import java.sql.Connection;

public class Connect {
    public static Connection connection(){
        return Dru.connection("172.20.10.9","micky1","1111","appdb");
    }
}
