package com.example.crudd.control;

import java.sql.Connection;
import java.sql.SQLException;

public class main1 {
    public static void main(String[] args) throws SQLException {
        Connection con=Connexion.onConnection();
        if (con==null){
            System.out.println("connection failed");
        }else {
            System.out.println("connection success");
        }

    }
}
