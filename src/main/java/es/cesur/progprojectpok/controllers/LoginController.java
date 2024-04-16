package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.ImageData;
import es.cesur.progprojectpok.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button exitBtn;



    @FXML
    private PasswordField passUser;


    @FXML
    private CheckBox rememberBtn;

    @FXML
    private TextField userId;

    @FXML
    private Label usuarioCorrecto;


    @FXML
    void loginUser(ActionEvent event) {
        if(userId.getText().equals("felipe") || passUser.getText().equals("1234")) {


        }



    }

    @FXML
    void registerUser(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    protected void onHelloButtonClick() {

    }


}