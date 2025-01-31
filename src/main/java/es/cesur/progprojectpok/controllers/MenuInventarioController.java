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

public class MenuInventarioController implements Initializable {


    Stage stage = new Stage();
    FXMLLoader fxmlLoader = null;

    private Entrenador entrenadorInventario;

    public Entrenador getEntrenadorInventario() {
        return entrenadorInventario;
    }

    public void setEntrenadorInventario(Entrenador entrenadorInventario) {
        this.entrenadorInventario = entrenadorInventario;
    }

    @FXML
    private AnchorPane carrarInventario;

    @FXML
    void btnBACK(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view-principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("boton-vuelta");
        stage.setScene(scene);
        MenuMainController menuMainController = fxmlLoader.getController();
        menuMainController.setEntrenadorMenuPrincipal(entrenadorInventario);
        stage.show();

        Stage stageAnterior = (Stage) carrarInventario.getScene().getWindow();
        stageAnterior.close();
    }

    @FXML
    void btnMochilla(ActionEvent event) {

    }

    @FXML
    void btnTienda(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/tienda-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1065, 600);
        stage.setTitle("Tienda-view");
        stage.setScene(scene);
        TiendaController tiendaController = fxmlLoader.getController();
        tiendaController.setEntrenadorTienda(entrenadorInventario);
        stage.show();

        Stage stageAnterior = (Stage) carrarInventario.getScene().getWindow();
        stageAnterior.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}