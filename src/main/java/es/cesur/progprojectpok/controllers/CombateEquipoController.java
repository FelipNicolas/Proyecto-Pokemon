package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.clases.Entrenador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CombateEquipoController implements Initializable {

    Stage stage = new Stage();
    FXMLLoader fxmlLoader = null;

    private Entrenador entrenadorCombEquipo;

    public Entrenador getEntrenadorCombEquipo() {
        return entrenadorCombEquipo;
    }

    public void setEntrenadorCombEquipo(Entrenador entrenadorCombEquipo) {
        this.entrenadorCombEquipo = entrenadorCombEquipo;
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
    private ImageView img1;

    @FXML
    private ImageView img10;

    @FXML
    private ImageView img11;

    @FXML
    private ImageView img12;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img4;

    @FXML
    private ImageView img5;

    @FXML
    private ImageView img6;

    @FXML
    private ImageView img7;

    @FXML
    private ImageView img8;

    @FXML
    private ImageView img9;

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
    void btnBACK(ActionEvent event) {

    }

    @FXML
    void btnPK1(ActionEvent event) {

    }

    @FXML
    void btnPK2(ActionEvent event) {

    }

    @FXML
    void btnPK3(ActionEvent event) {

    }

    @FXML
    void btnPK4(ActionEvent event) {

    }

    @FXML
    void btnPK5(ActionEvent event) {

    }

    @FXML
    void btnPK6(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}