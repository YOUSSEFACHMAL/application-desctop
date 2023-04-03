package com.example.crudd.control;

import com.example.crudd.model.Login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginControl {
    Statement statement ;
    public boolean islogin(Login lg) throws SQLException {
        statement=Connexion.onConnection().createStatement();
        ResultSet res= statement.executeQuery("select * from admin where username='"+lg.getUsername()+"'and password ='"+lg.getPassword()+"'");
    if (res.next())
        return true;
    return false ;
    }
}
