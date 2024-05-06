package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import es.cesur.progprojectpok.ImageData;
import es.cesur.progprojectpok.clases.Entrenador;
import es.cesur.progprojectpok.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.xml.stream.events.EntityReference;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuMainController implements Initializable {


    Stage stage = new Stage();
    FXMLLoader fxmlLoader = null;

    @FXML
    private AnchorPane cerrarMenuMain;

    private Entrenador entrenadorMenuPrincipal;

    public Entrenador getEntrenadorMenuPrincipal() {
        return entrenadorMenuPrincipal;
    }

    public void setEntrenadorMenuPrincipal(Entrenador entrenadorMenuPrincipal) {
        this.entrenadorMenuPrincipal = entrenadorMenuPrincipal;
    }

    @FXML
    void btnLucha(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view-lucha.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("Menu-lucha-view");
        stage.setScene(scene);
        stage.show();

        Stage stageAnterior = (Stage) cerrarMenuMain.getScene().getWindow();
        stageAnterior.close();
    }

    @FXML
    void btnEXIT(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnCentroPK(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view-centropk.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("Menu-CentroPK-view");
        stage.setScene(scene);
        MenuCentroPKController menuCentroPKController = fxmlLoader.getController();
        menuCentroPKController.setEntrenadorMenu(entrenadorMenuPrincipal);
        stage.show();

        Stage stageAnterior = (Stage) cerrarMenuMain.getScene().getWindow();
        stageAnterior.close();
    }

    @FXML
    void btnInventario(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view-inventario.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("Menu-inventario-view");
        stage.setScene(scene);
        stage.show();

        Stage stageAnterior = (Stage) cerrarMenuMain.getScene().getWindow();
        stageAnterior.close();
    }

    @FXML
    void btnPokedex(ActionEvent event) {

    }

    @FXML
    void btnCS(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 925, 580);
        stage.setTitle("CerrarSesion-view");
        stage.setScene(scene);
        stage.show();

        Stage stageAnterior = (Stage) cerrarMenuMain.getScene().getWindow();
        stageAnterior.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}