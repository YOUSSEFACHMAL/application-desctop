package com.example.crudd.control;

import com.example.crudd.model.Comande;
import com.example.crudd.model.Credit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class comandeControl {
    public void insertComandet(Comande comande) throws SQLException {
        Statement statement;
        statement=Connexion.onConnection().createStatement();
        statement.executeUpdate("INSERT INTO `comande`(`id`, `prix`, `id_cli`) VALUES ('"+comande.getId()+"','"+comande.getPrix()+"','"+comande.getId_cli()+"')");
        Connexion.closeConnection();
    };

    public void modifierComande(Comande comande) throws SQLException{
        Statement statement;
        statement = Connexion.onConnection().createStatement();
        statement.executeUpdate("UPDATE `comande` SET `prix`='"+comande.getPrix()+"' WHERE id='"+comande.getId()+"'");
        Connexion.closeConnection();
    };

    public void SupprimerComande(int id)throws SQLException{
        Statement statement;
        statement=Connexion.onConnection().createStatement();
        statement.executeUpdate("DELETE FROM `comande` WHERE id ='"+id+"'");
        Connexion.closeConnection();
    }

    public ObservableList<Comande> getAllComande() throws SQLException{
        ObservableList list= FXCollections.observableArrayList();
        Statement statement ;
        statement=Connexion.onConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM `comande`");
        while (result.next()){
Comande comande=new Comande() ;
         comande.setId(result.getInt("id"));
            comande.setPrix(result.getString("prix"));
            comande.setId_cli(result.getInt("id_cli"));
            list.add(comande);
        }
        Connexion.closeConnection();
        return list ;
    }

}

