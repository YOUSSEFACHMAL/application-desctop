package com.example.crudd.control;

import com.example.crudd.model.Client;
import com.example.crudd.model.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class clientControl {

    public void insertClient(Client client) throws SQLException {
        Statement statement;
        statement=Connexion.onConnection().createStatement();
        statement.executeUpdate("INSERT INTO `client`(`nom`, `adresse`) VALUES ('"+client.getNom()+"','"+client.getAdresse()+"')");
        Connexion.closeConnection();
    };

    public void modifierClient(Client client) throws SQLException{
        Statement statement;
        statement = Connexion.onConnection().createStatement();
        statement.executeUpdate("UPDATE `client` SET `nom`='" + client.getNom()+ "',`adresse`='" + client.getAdresse()+ "'where id='"+client.getId()+"'");
        Connexion.closeConnection();
    };

    public void SupprimerClient(int id)throws SQLException{
        Statement statement;
        statement=Connexion.onConnection().createStatement();
        statement.executeUpdate("DELETE FROM `client` WHERE id ='"+id+"'");
        Connexion.closeConnection();
    }

    public ObservableList<Client> getAllClient() throws SQLException{
        ObservableList list= FXCollections.observableArrayList();

        Statement statement ;
        statement=Connexion.onConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM `client`");
        while (result.next()){
              Client client =new Client();
    client.setId(result.getInt("id"));
    client.setNom(result.getString("nom"));
    client.setAdresse(result.getString("adresse"));
    list.add(client);
        }
        Connexion.closeConnection();
        return list ;
    }


}
