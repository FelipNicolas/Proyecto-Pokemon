package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import es.cesur.progprojectpok.ImageData;
import es.cesur.progprojectpok.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CentroPokController implements Initializable {

    Stage stage = new Stage();
    FXMLLoader fxmlLoader = null;

    @FXML
    private ImageView cerrarCurar;

    @FXML
    void btnBACK(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view-centropk.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("Menu-lucha-view");
        stage.setScene(scene);
        stage.show();

        Stage stageAnterior = (Stage) cerrarCurar.getScene().getWindow();
        stageAnterior.close();
    }

    @FXML
    private ImageView imgPok1;

    @FXML
    private ImageView imgPok2;

    @FXML
    private ImageView imgPok3;

    @FXML
    private ImageView imgPok4;

    @FXML
    private ImageView imgPok5;

    @FXML
    private ImageView imgPok6;

    @FXML
    private Label lblPok1;

    @FXML
    private Label lblPok2;

    @FXML
    private Label lblPok3;

    @FXML
    private Label lblPok4;

    @FXML
    private Label lblPok5;

    @FXML
    private Label lblPok6;

    @FXML
    private ProgressBar pgrsbar1;

    @FXML
    private ProgressBar pgrsbar2;

    @FXML
    private ProgressBar pgrsbar3;

    @FXML
    private ProgressBar pgrsbar4;

    @FXML
    private ProgressBar pgrsbar5;

    @FXML
    private ProgressBar pgrsbar6;

    @FXML
    void realizarCura(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */


}