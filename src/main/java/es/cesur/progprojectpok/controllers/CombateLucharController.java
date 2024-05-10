package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.ImageData;
import es.cesur.progprojectpok.clases.Entrenador;
import es.cesur.progprojectpok.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class CombateLucharController implements Initializable {

    Stage stage = new Stage();
    FXMLLoader fxmlLoader = null;

    private Entrenador entrenadorCombAtaque;

    public Entrenador getEntrenadorCombAtaqueo() {
        return entrenadorCombAtaque;
    }

    public void setEntrenadorCombAtaque(Entrenador entrenadorCombEquipo) {
        this.entrenadorCombAtaque = entrenadorCombEquipo;
    }

    @FXML
    private ImageView Gender1;

    @FXML
    private ImageView Gender2;

    @FXML
    private ImageView Perso1;

    @FXML
    private ImageView Perso2;

    @FXML
    private ImageView Pok1;

    @FXML
    private ImageView Pok2;

    @FXML
    private ImageView Pok3;

    @FXML
    private ImageView Pok4;

    @FXML
    private ImageView Pok5;

    @FXML
    private ImageView Pok6;

    @FXML
    private ImageView imgATK1;

    @FXML
    private ImageView imgATK2;

    @FXML
    private ImageView imgATK3;

    @FXML
    private ImageView imgATK4;

    @FXML
    private Label lblATK1;

    @FXML
    private Label lblATK2;

    @FXML
    private Label lblATK3;

    @FXML
    private Label lblATK4;

    @FXML
    private Label lblComb1;

    @FXML
    private Label lblNombre1;

    @FXML
    private Label lblNombre2;

    @FXML
    private Label lblNvl1;

    @FXML
    private Label lblNvl2;

    @FXML
    private ProgressBar prgrsBar1;

    @FXML
    private ProgressBar prgrsBar2;

    @FXML
    void btn1(ActionEvent event) {

    }

    @FXML
    void btn2(ActionEvent event) {

    }

    @FXML
    void btn3(ActionEvent event) {

    }

    @FXML
    void btn4(ActionEvent event) {

    }

    @FXML
    void btnBACK(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}