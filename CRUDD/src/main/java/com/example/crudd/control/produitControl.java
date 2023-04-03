package com.example.crudd.control;

import com.example.crudd.model.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class produitControl {

    public void insertProduct(Produit produit) throws SQLException {
        Statement statement;
        statement=Connexion.onConnection().createStatement();
        statement.executeUpdate("INSERT INTO `produits`(`nom`, `type`, `quantite`, `prix`) VALUES ('"+produit.getNom()+"','"+produit.getType()+"','"+produit.getQuantite()+"','"+produit.getPrix()+"')");
    Connexion.closeConnection();
    };

    public void modifierProduit(Produit produit) throws SQLException{
        Statement statement;
            statement = Connexion.onConnection().createStatement();
            statement.executeUpdate("UPDATE `produits` SET `nom`='" + produit.getNom() + "',`type`='" + produit.getType() + "',`quantite`='" + produit.getQuantite() + "',`prix`='" + produit.getPrix() +"' where id ='"+produit.getId()+"'");
            Connexion.closeConnection();
    };

    public void SupprimerProduit(int id)throws SQLException{
        Statement statement;
        statement=Connexion.onConnection().createStatement();
        statement.executeUpdate("DELETE FROM `produits` WHERE id ='"+id+"'");
        Connexion.closeConnection();
    }

    public ObservableList<Produit> getAllProduit() throws SQLException{
        ObservableList list= FXCollections.observableArrayList();

        Statement statement ;
        statement=Connexion.onConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT*FROM `produits`");
        while (result.next()){
             Produit produit=new Produit();
            produit.setId(result.getInt("id"));
            produit.setNom(result.getString("nom"));
            produit.setType(result.getString("type"));
            produit.setQuantite(result.getString("quantite"));
            produit.setPrix(result.getString("prix"));
            list.add(produit);
        }
        Connexion.closeConnection();
        return list ;
    }


}
