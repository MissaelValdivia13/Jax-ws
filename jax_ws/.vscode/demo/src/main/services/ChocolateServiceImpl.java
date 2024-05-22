package com.example.services;

import javax.jws.WebService;
import java.sql.*;


@WebService(endpointInterface ="com.example.services.ChocolateService")
public class ChocolateServiceImpl implements ChocolateService{
    
    @Override
    public String createChocolateDataBase(){
        try {
            DbHandler handler = new DBHandler();
            Connection con  =  handler.getConnection();
            Statement statement =  con.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS chocolate (id int not null auto_increment primary key, name varchar(70) not null, price int not null);";
            int count = statement.executeUpdate(sql);
            return "Create table succes with return value:" + cont;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return ""+e.getMessage();
        }
    }

    @Override
    public String addChocolate(String name, int cost){

    }
}
