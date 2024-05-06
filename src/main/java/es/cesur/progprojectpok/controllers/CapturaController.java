package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.ImageData;
import es.cesur.progprojectpok.clases.Entrenador;
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
import java.util.Random;
import java.util.ResourceBundle;

public class CapturaController implements Initializable {


    @FXML
    private Label lblComb1;

    @FXML
    private ImageView pokCap;

    Entrenador entrenadorCaptura = new Entrenador();


    @Override
    public void initialize(URL location, ResourceBundle resources) {




            }


    @FXML
    void btnCapturar(ActionEvent event) {

        Random random = new Random();
        int probabilidadDeCaptura = random.nextInt(5) + 1;

    }

    @FXML
    void btnHuir(ActionEvent event) {

    }









}