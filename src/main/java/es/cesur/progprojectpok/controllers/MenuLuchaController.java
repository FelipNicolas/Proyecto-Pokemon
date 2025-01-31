package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import es.cesur.progprojectpok.clases.Entrenador;
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

public class MenuLuchaController implements Initializable {


    Stage stage = new Stage();
    FXMLLoader fxmlLoader = null;

    private Entrenador entrenadorMenuLucha;

    public Entrenador getEntrenadorMenuLucha() {
        return entrenadorMenuLucha;
    }

    public void setEntrenadorMenuLucha(Entrenador entrenadorMenuLucha) {
        this.entrenadorMenuLucha = entrenadorMenuLucha;
    }

    @FXML
    private AnchorPane cerrarLucha;

    @FXML
    void btnBACK(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view-principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("Menu-principal-view");
        stage.setScene(scene);
        MenuMainController menuMainController = fxmlLoader.getController();
        menuMainController.setEntrenadorMenuPrincipal(entrenadorMenuLucha);
        stage.show();

        Stage stageAnterior = (Stage) cerrarLucha.getScene().getWindow();
        stageAnterior.close();
    }

    @FXML
    void btnEntreno(ActionEvent event) {

    }

    @FXML
    void btnCombate(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/combate-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1015, 685);
        stage.setTitle("Combate-view");
        stage.setScene(scene);
        CombateController combateController = fxmlLoader.getController();
        combateController.setEntrenadorCombate(entrenadorMenuLucha);
        stage.show();

        Stage stageAnterior = (Stage) cerrarLucha.getScene().getWindow();
        stageAnterior.close();
    }

    @FXML
    void btnCaptura(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/captura-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1015, 685);
        stage.setTitle("captura-view");
        stage.setScene(scene);
        CapturaController capturaController = fxmlLoader.getController();
        capturaController.setEntrenadorCaptura(entrenadorMenuLucha);
        stage.show();

        Stage stageAnterior = (Stage) cerrarLucha.getScene().getWindow();
        stageAnterior.close();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}