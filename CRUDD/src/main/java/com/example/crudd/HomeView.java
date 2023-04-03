package com.example.crudd;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeView implements Initializable {
    @FXML
    private Button btnCommande ;

    @FXML
    private Button btnClient;

    @FXML
    private Button btnCredit;
    @FXML
    private PieChart piechat;
    @FXML
    private BarChart Linechart;

    @FXML
    private Button btnProduit;

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

public void  chart(){
    XYChart.Series series=new XYChart.Series();
    series.getData().add(new XYChart.Data("total",25));
    series.getData().add(new XYChart.Data("client",15));
    series.getData().add(new XYChart.Data("commande",2));
    series.getData().add(new XYChart.Data("produit",10));
    series.getData().add(new XYChart.Data("credit",20));
    Linechart.getData().addAll(series);
}
public void cercle(){
    ObservableList<PieChart.Data> piechart=
            FXCollections.observableArrayList(
                    new PieChart.Data("produit",2),
                    new PieChart.Data("client",10),
                    new PieChart.Data("credit",5),
                    new PieChart.Data("commande",15)
                    );
    piechart.forEach(data -> {
        data.nameProperty().bind(Bindings.concat(data.getName(),"amouant :",data.pieValueProperty()));
    });
    piechat.getData().addAll(piechart);
}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chart();
        cercle();
    }
}