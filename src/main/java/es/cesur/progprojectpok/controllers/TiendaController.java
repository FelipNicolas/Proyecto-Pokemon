package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import es.cesur.progprojectpok.clases.Entrenador;
import es.cesur.progprojectpok.clases.Objeto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static es.cesur.progprojectpok.clases.Objeto.*;

public class TiendaController implements Initializable {


    Stage stage;
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

    int contador = 1;

    Objeto pivoteObj;

    



    @FXML
    void btnSumarCant(ActionEvent event) {

        contador++;
        lblCantidadObj.setText(String.valueOf(contador));


    }

    @FXML
    void btnRestarCant(ActionEvent event) {

        if (contador > 1) {
            contador--;
            lblCantidadObj.setText(String.valueOf(contador));
        }

    }

    public void infoTienda(Objeto objeto, ImageView img) {


        imgObjetoComprar.setImage(img.getImage());
        lblNombrePrecio.setText("Nombre: " + objeto.getNombre() + "\n"
                + "Precio: " + objeto.getPrecio());
        lblCantidadObj.setText(String.valueOf(1));
        lblDescripcion.setText(objeto.getDescripcion());


    }


    @FXML
    void mostrarObj1(MouseEvent event) {

        contador = 0;
        pivoteObj = POKEBALL;

        this.infoTienda(pivoteObj, imgObj1);

    }
    @FXML
    void mostrarObj2(MouseEvent event) {
        contador = 0;
        pivoteObj = CHALECO;
        this.infoTienda(pivoteObj, imgObj2);

    }

    @FXML
    void mostrarObj3(MouseEvent event) {
        contador = 0;
        pivoteObj = ANILLO;
        this.infoTienda(pivoteObj, imgObj3);

    }

    @FXML
    void mostrarObj4(MouseEvent event) {
        contador = 0;
        pivoteObj = ETER;
        this.infoTienda(pivoteObj, imgObj4);

    }

    @FXML
    void mostrarObj5(MouseEvent event) {
        contador = 0;
        pivoteObj = BASTON;
        this.infoTienda(pivoteObj, imgObj5);


    }

    @FXML
    void mostrarObj6(MouseEvent event) {
        contador = 0;
        pivoteObj = PILA;
        this.infoTienda(pivoteObj, imgObj6);

    }

    @FXML
    void mostrarObj7(MouseEvent event) {
        contador = 0;
        pivoteObj = PLUMA;
        this.infoTienda(pivoteObj, imgObj7);

    }

    @FXML
    void mostrarObj8(MouseEvent event) {
        contador = 0;
        pivoteObj = PESA;
        this.infoTienda(pivoteObj, imgObj8);

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