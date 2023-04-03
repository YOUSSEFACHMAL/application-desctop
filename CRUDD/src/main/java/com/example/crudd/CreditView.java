package com.example.crudd;

import com.example.crudd.control.clientControl;
import com.example.crudd.control.creditControl;

import com.example.crudd.model.Client;
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

public class CreditView implements Initializable {
    @FXML
    private Button btnClient;
    @FXML
    private Button btnCredit;
    @FXML
    private Button btnProduit;

    @FXML
    private Button btnCommande;
    @FXML
    private Button btn_ajouter;

    @FXML
    private Button btn_modifier;

    @FXML
    private Button btn_supprimer;

    @FXML
    private TableColumn date;

    @FXML
    private TextField date_credit;
    @FXML
    private TextField id_credit;

    @FXML
    private TableColumn id;

    @FXML
    private TableColumn id_cli;

    @FXML
    private TextField id_cli_credit;
    @FXML
    private TableColumn montanet;

    @FXML
    private TextField montant_credit;

    @FXML
    private TableView table;

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
    creditControl creditcontrol=new creditControl();
    public void ShowA(){
        id.setCellValueFactory(new PropertyValueFactory<Credit,Integer>("id"));
        date.setCellValueFactory(new PropertyValueFactory<Credit,String>("date"));
        montanet.setCellValueFactory(new PropertyValueFactory<Credit,String>("montant"));
        id_cli.setCellValueFactory(new PropertyValueFactory<Credit,Integer>("id_cli"));
        try {
            table.setItems(creditcontrol.getAllCredit());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ShowA();
    }

    public void AjouteCr(Event e) throws SQLException{
          Credit credit=new Credit();
          credit.setId(Integer.parseInt(id_credit.getText()));
        credit.setDate(date_credit.getText());
        credit.setId_cli(Integer.parseInt(id_cli_credit.getText()));
        creditcontrol.insertCredit(credit);
        ShowA();
        id_credit.setText("");
        id_cli_credit.setText("");

        date_credit.setText("");
        montant_credit.setText("");
    }
    public void ModifierCr(Event e) throws SQLException {
        Credit credit=new Credit();
        credit.setId(Integer.parseInt(id_credit.getText()));
        credit.setDate(date_credit.getText());
        credit.setMontant(montant_credit.getText());
        credit.setId_cli(Integer.parseInt(id_cli_credit.getText()));
        creditcontrol.modifierCredit(credit);
        ShowA();
        id_credit.setText("");
        id_cli_credit.setText("");
        date_credit.setText("");
        montant_credit.setText("");
    }
    int ID ;
    public void ClickTable2(Event e){
       Credit credit =(Credit) table.getSelectionModel().getSelectedItem();
        id_credit.setText(String.valueOf(credit.getId()));
        id_cli_credit.setText(String.valueOf(credit.getId_cli()));
        date_credit.setText(credit.getDate());
        montant_credit.setText(credit.getMontant());
        ID= credit.getId();
    }
    public void SuppCr(Event e) throws SQLException {
        creditcontrol.SupprimerCredit(ID);
        ShowA();
        id_credit.setText("");
        id_cli_credit.setText("");
        date_credit.setText("");
        montant_credit.setText("");
    }

}
