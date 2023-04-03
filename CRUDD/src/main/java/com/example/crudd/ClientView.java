package com.example.crudd;

import com.example.crudd.control.clientControl;
import com.example.crudd.control.produitControl;
import com.example.crudd.model.Client;
import com.example.crudd.model.Produit;
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

public class ClientView implements  Initializable{
    @FXML
    private TableColumn<Client, String> adresse;

    @FXML
    private TextField adresse_cli;

    @FXML
    private Button ajoute_cli;



    @FXML
    private TableColumn<Client, Integer> id;

    @FXML
    private Button modifier_cli;

    @FXML
    private TextField nom_cli;

    @FXML
    private TableColumn<Client, String> telephone;
    @FXML
    private TableView<Client> table;

    @FXML
    private Button suprimer_cli;

    @FXML
    private TextField tele_cli;
    @FXML
    private Button btnClient;

    @FXML
    private Button btnCredit;

    @FXML
    private Button btnProduit;
    @FXML
    private TableColumn<Client, String> nom;


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
    clientControl clientControl = new clientControl();
    public void ShowA(){
        id.setCellValueFactory(new PropertyValueFactory<Client,Integer>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
        adresse.setCellValueFactory(new PropertyValueFactory<Client,String>("adresse"));
        try {
            table.setItems(clientControl.getAllClient());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ShowA();
    }

    public void AjouteCLi(Event e) throws SQLException{
        Client client=new Client();

        client.setNom(nom_cli.getText());
        client.setAdresse(adresse_cli.getText());
      clientControl.insertClient(client);
        ShowA();
        nom_cli.setText("");
        adresse_cli.setText("");
    }
    public void ModifierCli(Event e) throws SQLException {
        Client client=new Client();

        client.setNom(nom_cli.getText());
        client.setAdresse(adresse_cli.getText());
        client.setId(ID);
        clientControl.modifierClient(client);

        ShowA();
        nom_cli.setText("");
        adresse_cli.setText("");
    }
    int ID ;
    public void ClickTable(Event e){
        Client client =(Client) table.getSelectionModel().getSelectedItem();
        nom_cli.setText(client.getNom());
         adresse_cli.setText(client.getAdresse());
        ID= client.getId();
    }
    public void SuppCl(Event e) throws SQLException {
        clientControl.SupprimerClient(ID);
        ShowA();
        nom_cli.setText("");
        adresse_cli.setText("");
    }



}
