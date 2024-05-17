package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import es.cesur.progprojectpok.clases.Entrenador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PcController implements Initializable {


    Stage stage = new Stage();
    FXMLLoader fxmlLoader = null;

    private Entrenador entrenadorPc;

    public Entrenador getEntrenadorPc() {
        return entrenadorPc;
    }

    public void setEntrenadorPc(Entrenador entrenadorPc) {
        this.entrenadorPc = entrenadorPc;
    }

    @FXML
    private ImageView cerrarPC;
    @FXML
    void btnBACK(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view-centropk.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("volver-btn");
        stage.setScene(scene);
        MenuCentroPKController centroPKController = fxmlLoader.getController();
        centroPKController.setEntrenadorMenu(entrenadorPc);
        stage.show();

        Stage stageAnterior = (Stage) cerrarPC.getScene().getWindow();
        stageAnterior.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}