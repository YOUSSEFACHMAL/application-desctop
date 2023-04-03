package com.example.crudd;

import com.example.crudd.model.*;
import com.example.crudd.control.produitControl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProduitView implements Initializable{
    @FXML
    private TextField nom_produit;

    @FXML
    private TextField prix_produit;

    @FXML
    private TextField quantite_produit;
    @FXML
    private TextField type_produit;
    @FXML
    private Button ajoute_produit;
    @FXML
    private Button modifier_produit;
    @FXML
    private Button supprimer_produit;
    @FXML
    private Button btnClient;

    @FXML
    private Button btnCredit;

    @FXML
    private Button btnProduit;
    @FXML
    private TableView<Produit>table;
    @FXML
    private TableColumn<Produit,String> nom;
    @FXML
    private TableColumn<Produit,String> type;
    @FXML
    private TableColumn<Produit,String> id;
    @FXML
    private TableColumn<Produit,String> quantite;
    @FXML
    private TableColumn<Produit,String> prix;



    public void  onclikClient(Event se) throws SQLException, IOException {
        Node node=(Node)se.getSource();

        Stage stage =(Stage) node.getScene().getWindow();
        Parent route = FXMLLoader.load(getClass().getResource("Client.fxml"));
        Scene scene = new Scene(route);
        stage.setTitle("client!");
        stage.setScene(scene);
        stage.show();

    }
    public void  onclikProduit(Event se) throws SQLException, IOException {
        Node node=(Node)se.getSource();

        Stage stage =(Stage) node.getScene().getWindow();
        Parent route = FXMLLoader.load(getClass().getResource("Produit.fxml"));
        Scene scene = new Scene(route);
        stage.setTitle("produit!");
        stage.setScene(scene);
        stage.show();

    }
    public void  onclikCredit(Event se) throws SQLException, IOException {
        Node node=(Node)se.getSource();

        Stage stage =(Stage) node.getScene().getWindow();
        Parent route = FXMLLoader.load(getClass().getResource("Credit.fxml"));
        Scene scene = new Scene(route);
        stage.setTitle("credit!");
        stage.setScene(scene);
        stage.show();

    }
    public void  onclikCommande(Event se) throws SQLException, IOException {
        Node node=(Node)se.getSource();

        Stage stage =(Stage) node.getScene().getWindow();
        Parent route = FXMLLoader.load(getClass().getResource("Commande.fxml"));
        Scene scene = new Scene(route);
        stage.setTitle("commande!");
        stage.setScene(scene);
        stage.show();

    }
    produitControl produitControl=new produitControl();
          public void Show(){
              id.setCellValueFactory(new PropertyValueFactory<Produit,String>("id"));
              nom.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom"));
              type.setCellValueFactory(new PropertyValueFactory<Produit,String>("type"));
              quantite.setCellValueFactory(new PropertyValueFactory<Produit,String>("quantite"));
              prix.setCellValueFactory(new PropertyValueFactory<Produit,String>("prix"));
              try {
                  table.setItems(produitControl.getAllProduit());
              } catch (SQLException e) {
                  throw new RuntimeException(e);
              }
          };
   @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
       Show();
   };
    Produit produit=new Produit();
    produitControl produitcontrol=new produitControl();
    public void AjouteP(Event e) throws SQLException{
        produit.setNom(nom_produit.getText());
        produit.setType(type_produit.getText());
        produit.setPrix(prix_produit.getText());
        produit.setQuantite(quantite_produit.getText());
      produitcontrol.insertProduct(produit);
      Show();
        nom_produit.setText("");
        type_produit.setText("");
        quantite_produit.setText("");
        prix_produit.setText("");
    }
      public void ModifierP(Event e) throws SQLException {
          produit.setNom(nom_produit.getText());
          produit.setType(type_produit.getText());
          produit.setPrix(prix_produit.getText());
          produit.setQuantite(quantite_produit.getText());
          produit.setId(ID);
          produitcontrol.modifierProduit(produit);
          Show();
          nom_produit.setText("");
          type_produit.setText("");
          quantite_produit.setText("");
          prix_produit.setText("");
      }
      int ID ;
      public void ClickTable1(Event e){
        Produit produit =(Produit) table.getSelectionModel().getSelectedItem();
          nom_produit.setText(produit.getNom());
        type_produit.setText(produit.getType());
        quantite_produit.setText(produit.getQuantite());
        prix_produit.setText(produit.getPrix());
        ID= produit.getId();
      }
      public void SuppP(Event e) throws SQLException {
          produitControl.SupprimerProduit(ID);
          Show();
          nom_produit.setText("");
          type_produit.setText("");
          quantite_produit.setText("");
          prix_produit.setText("");
      }

      }





