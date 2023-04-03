package com.example.crudd.control;

import com.example.crudd.model.Credit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class creditControl {
    public void insertCredit(Credit credit) throws SQLException {
        Statement statement;
        statement=Connexion.onConnection().createStatement();
        statement.executeUpdate("INSERT INTO `credit`(`id`,`date`, `montant`, `id_cli`) VALUES ('"+credit.getId()+"','"+credit.getDate()+"','"+credit.getMontant()+"','"+credit.getId_cli()+"')");
        Connexion.closeConnection();
    };

    public void modifierCredit(Credit credit) throws SQLException{
        Statement statement;
        statement = Connexion.onConnection().createStatement();
        statement.executeUpdate("UPDATE `credit` SET `montant`='"+credit.getMontant()+"'WHERE`id`='"+credit.getId()+"'");
        Connexion.closeConnection();
    };

    public void SupprimerCredit(int id)throws SQLException{
        Statement statement;
        statement=Connexion.onConnection().createStatement();
        statement.executeUpdate("DELETE FROM `credit` WHERE id ='"+id+"'");
        Connexion.closeConnection();
    }

    public ObservableList<Credit> getAllCredit() throws SQLException{
        ObservableList list= FXCollections.observableArrayList();
        Statement statement ;
        statement=Connexion.onConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM `credit`");
        while (result.next()){
Credit credit=new Credit();
             credit.setId(result.getInt("id"));
            credit.setDate(result.getString("date"));
            credit.setMontant(result.getString("montant"));
            credit.setId_cli(result.getInt("id_cli"));
            list.add(credit);
        }
        Connexion.closeConnection();
        return list ;
    }

}
