package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuCentroPKController implements Initializable {


    Stage stage = new Stage();
    FXMLLoader fxmlLoader = null;

    @FXML
    private AnchorPane cerrarCentroPK;

    @FXML
    void btnBACK(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view-principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("Menu-principal-view");
        stage.setScene(scene);
        stage.show();

        Stage stageAnterior = (Stage) cerrarCentroPK.getScene().getWindow();
        stageAnterior.close();
    }

    @FXML
    void btnEquipo(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/equipo-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 925, 580);
        stage.setTitle("Menu-principal-view");
        stage.setScene(scene);
        stage.show();

        Stage stageAnterior = (Stage) cerrarCentroPK.getScene().getWindow();
        stageAnterior.close();
    }

    @FXML
    void btnPC(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/pc-pokemon-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 925, 580);
        stage.setTitle("Menu-principal-view");
        stage.setScene(scene);
        stage.show();

        Stage stageAnterior = (Stage) cerrarCentroPK.getScene().getWindow();
        stageAnterior.close();
    }

    @FXML
    void btnCurar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/centro-pokemon-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 925, 580);
        stage.setTitle("Menu-principal-view");
        stage.setScene(scene);
        stage.show();

        Stage stageAnterior = (Stage) cerrarCentroPK.getScene().getWindow();
        stageAnterior.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}