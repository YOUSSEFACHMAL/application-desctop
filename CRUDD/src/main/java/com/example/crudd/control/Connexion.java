package com.example.crudd.control;
import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static Connection con=null;
    private static String username="root";
    private static String password="";
    private static String url="jdbc:mysql://localhost/myprojets";
    public static Connection onConnection() throws SQLException {
        if (con==null)
            con= DriverManager.getConnection(url,username,password);
        return con;

    }
    public  static  void closeConnection() throws SQLException{
        if (con!=null)
            con=null ;

    }
}
