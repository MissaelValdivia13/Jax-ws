package com.example.services;

import java.sql.*;

public class DBHandler {
    
    private Connection connection;
    private static String DB_URL = "jdbc:mysql://localhost/willyFactory";
    private static String DB_UserName = "root";
    private static String DB_Password = "";


    public DBHandler(){
        try {
            System.out.println("Connection to MYSQL DB");
            this.connection = DriverManager.getConnection(DB_URL, DB_UserName, DB_Password);
            System.out.println("DB connected");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Failed");
        }
    }

    public Connection getConnection(){
        return this.connection;
    }
}
