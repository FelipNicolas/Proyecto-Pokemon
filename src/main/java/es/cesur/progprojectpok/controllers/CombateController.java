package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import es.cesur.progprojectpok.clases.Entrenador;
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
    private ImageView imgPok1;

    @FXML
    private ImageView imgPok2;

    @FXML
    private Label lblComb1;

    @FXML
    private ImageView Pok6;

    @FXML
    private ImageView Pok4;

    @FXML
    private ImageView Pok5;

    @FXML
    private Label lblNvl1;

    @FXML
    private ProgressBar prgrsBar1;

    @FXML
    private ProgressBar prgrsBar2;

    @FXML
    private Label lblNvl2;

    @FXML
    private Label lblNombre2;

    @FXML
    private Label lblNombre1;

    @FXML
    private AnchorPane cerrarCombatePK;

    Entrenador entrenadorCombate;

    Stage stage;


    public Entrenador getEntrenadorCombate() {
        return entrenadorCombate;
    }

    public void setEntrenadorCombate(Entrenador entrenadorCombate) {
        this.entrenadorCombate = entrenadorCombate;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void btnLuchar(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/combate-luchar-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1015, 685);
        stage.setTitle("Combate-view");
        stage.setScene(scene);
        CombateLucharController combateLucharController = fxmlLoader.getController();
        combateLucharController.setEntrenadorCombateLucha(entrenadorCombate);
        stage.show();

        Stage stageAnterior = (Stage) cerrarCombatePK.getScene().getWindow();
        stageAnterior.close();

    }

    @FXML
    void btnPK(ActionEvent event) {

    }

    @FXML
    void btnMochila(ActionEvent event) {

    }

    @FXML
    void btnHuir(ActionEvent event) {

    }

    @FXML
    void btnPokemon(ActionEvent event) {

    }








}