package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import es.cesur.progprojectpok.clases.Entrenador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TiendaController implements Initializable {


    Stage stage = new Stage();
    FXMLLoader fxmlLoader = null;


    @FXML
    private AnchorPane cerrarTienda;

    @FXML
    private ImageView imgObj3;

    @FXML
    private ImageView imgObj2;

    @FXML
    private ImageView imgObj1;


    @FXML
    private Label lblNombrePrecio;

    @FXML
    private ImageView imgObjetoComprar;

    @FXML
    private Label lblDescripcion;

    @FXML
    private ImageView imgObj8;

    @FXML
    private ImageView imgObj7;

    @FXML
    private ImageView imgObj6;

    @FXML
    private Label lblCantidadObj;

    @FXML
    private ImageView imgObj5;

    @FXML
    private ImageView imgObj4;

    @FXML
    void btnSumarCant(ActionEvent event) {

    }

    @FXML
    void btnRestarCant(ActionEvent event) {

    }

    @FXML
    void mostrarObj1(MouseEvent event) {

        imgObjetoComprar.setImage(imgObj1.getImage());

    }

    @FXML
    void mostrarObj2(ActionEvent event) {

    }

    @FXML
    void mostrarObj3(ActionEvent event) {

    }

    @FXML
    void mostrarObj4(ActionEvent event) {

    }

    @FXML
    void mostrarObj5(ActionEvent event) {

    }

    @FXML
    void mostrarObj6(ActionEvent event) {

    }

    @FXML
    void mostrarObj7(ActionEvent event) {

    }

    @FXML
    void mostrarObj8(ActionEvent event) {

    }



    Entrenador entrenadorTienda;

    public Entrenador getEntrenadorTienda() {
        return entrenadorTienda;
    }

    public void setEntrenadorTienda(Entrenador entrenadorTienda) {
        this.entrenadorTienda = entrenadorTienda;
    }

    @FXML
    void btnEXIT(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view-inventario.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("Menu-inventario-view");
        stage.setScene(scene);
        stage.show();

        Stage stageAnterior = (Stage) cerrarTienda.getScene().getWindow();
        stageAnterior.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {




    }
}