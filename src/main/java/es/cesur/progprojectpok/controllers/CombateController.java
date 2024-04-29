package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import es.cesur.progprojectpok.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CombateController implements Initializable {

    Stage stage = new Stage();
    FXMLLoader fxmlLoader = null;

    @FXML
    private AnchorPane cerrarCombatePK;

    @FXML
    private ImageView Gender1;

    @FXML
    private ImageView Pok2;

    @FXML
    private ImageView Pok3;

    @FXML
    private ImageView Gender2;

    @FXML
    private ImageView Pok1;

    @FXML
    private Label lblComb1;

    @FXML
    private ImageView Pok6;

    @FXML
    private ImageView Pok4;

    @FXML
    private ImageView Pok5;

    @FXML
    private ImageView Perso1;

    @FXML
    private Label lblNvl1;

    @FXML
    private ProgressBar prgrsBar1;

    @FXML
    private ImageView Perso2;

    @FXML
    private ProgressBar prgrsBar2;

    @FXML
    private Label lblNvl2;

    @FXML
    private Label lblNombre2;

    @FXML
    private Label lblNombre1;

    @FXML
    void btnLuchar(ActionEvent event) {

    }

    @FXML
    void btnPK(ActionEvent event) {

    }

    @FXML
    void btnMochila(ActionEvent event) {

    }

    @FXML
    void btnHuir(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view-lucha.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("Menu-lucha-view");
        stage.setScene(scene);
        stage.show();

        Stage stageAnterior = (Stage) cerrarCombatePK.getScene().getWindow();
        stageAnterior.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}