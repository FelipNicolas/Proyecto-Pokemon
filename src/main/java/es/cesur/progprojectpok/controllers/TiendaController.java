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

public class TiendaController implements Initializable {

    Stage stage = new Stage();
    FXMLLoader fxmlLoader = null;

    private Entrenador entrenadorTienda;

    public Entrenador getEntrenadorTienda() {
        return entrenadorTienda;
    }

    public void setEntrenadorTienda(Entrenador entrenadorTienda) {
        this.entrenadorTienda = entrenadorTienda;
    }

    @FXML
    private AnchorPane cerrarTienda;

    @FXML
    void btnEXIT(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view-inventario.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("btn-vuelta");
        stage.setScene(scene);
        MenuInventarioController menuInventarioController = fxmlLoader.getController();
        menuInventarioController.setEntrenadorInventario(entrenadorTienda);
        stage.show();

        Stage stageAnterior = (Stage) cerrarTienda.getScene().getWindow();
        stageAnterior.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}