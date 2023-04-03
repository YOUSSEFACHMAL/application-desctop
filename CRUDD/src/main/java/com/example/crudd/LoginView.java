package com.example.crudd;



import com.example.crudd.HelloApplication;
import com.example.crudd.model.Login;
import com.example.crudd.control.loginControl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.Event;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginView{
    @FXML
    private Button log;

    @FXML
    private TextField pass;

    @FXML
    private TextField user;
    @FXML
            private Label lab ;
    Login lg=new Login();
    loginControl lgC=new loginControl();

    public void  sing(Event e) throws SQLException, IOException {
        lg.setUsername(user.getText());
        lg.setPassword(pass.getText());
        if(lgC.islogin(lg)){
            Node node=(Node)e.getSource();

            Stage stage =(Stage) node.getScene().getWindow();
            Parent route = FXMLLoader.load(getClass().getResource("home.fxml"));
            Scene scene = new Scene(route);
            stage.setTitle("home !");
            stage.setScene(scene);
            stage.show();

        }else{
    lab.setText("erreur! username or password is incorect");
        }
    };
}
