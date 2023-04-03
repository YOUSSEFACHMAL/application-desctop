package com.example.crudd;

import com.example.crudd.control.comandeControl;
import com.example.crudd.model.Comande;
import com.example.crudd.model.Credit;
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

public class CommandeView implements Initializable {
    @FXML
    private Button btnCredit;

    @FXML
    private Button btnClient;

    @FXML
    private Button btnProduit;

    @FXML
    private Button ajouetC;

    @FXML
    private Button suprimerC;

    @FXML
    private Button modifierC;

    @FXML
    private TextField prix_comande;

    @FXML
    private TextField id_cli_comande;
    @FXML
    private TextField id_comande;

    @FXML
    private TableView  table;

    @FXML
    private TableColumn  id;

    @FXML
    private TableColumn prix;

    @FXML
    private TableColumn id_cli;

    @FXML
    private Button btnCommande;




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
    comandeControl comandeControl =new comandeControl() ;
    public void ShowA(){
        id.setCellValueFactory(new PropertyValueFactory<Credit,Integer>("id"));
        prix.setCellValueFactory(new PropertyValueFactory<Credit,String>("prix"));
        id_cli.setCellValueFactory(new PropertyValueFactory<Credit,Integer>("id_cli"));
        try {
            table.setItems(comandeControl.getAllComande());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ShowA();
    }

    public void AjouteCom(Event e) throws SQLException{
Comande comande =new Comande();
comande.setId(Integer.valueOf(id_comande.getText()));
comande.setPrix(prix_comande.getText());
comande.setId_cli(Integer.valueOf(id_cli_comande.getText()));
        comandeControl.insertComandet(comande);
        ShowA();
        id_comande.setText("");
        id_cli_comande.setText("");
       prix_comande.setText("");
    }
    public void ModifierCom(Event e) throws SQLException {
        Comande comande =new Comande();
        comande.setId(Integer.valueOf(id_comande.getText()));
        comande.setPrix(prix_comande.getText());
        comande.setId_cli(Integer.valueOf(id_cli_comande.getText()));
        comandeControl.modifierComande(comande);
        ShowA();
        id_comande.setText("");
        id_cli_comande.setText("");
        prix_comande.setText("");
    }
    int ID ;
    public void ClickTable3(Event e){
        Comande comande =(Comande) table.getSelectionModel().getSelectedItem();
        id_comande.setText(String.valueOf(comande.getId()));
        prix_comande.setText(comande.getPrix());
        id_cli_comande.setText(String.valueOf(comande.getId_cli()));
        ID= comande.getId();
    }
    public void SuppCom(Event e) throws SQLException {
        comandeControl.SupprimerComande(ID);
        ShowA();
        id_comande.setText("");
        id_cli_comande.setText("");
        prix_comande.setText("");
    }

}
