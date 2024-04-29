package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.ImageData;
import es.cesur.progprojectpok.database.DBConnection;
import es.cesur.progprojectpok.utils.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EquipoController implements Initializable {

    @FXML
    private ImageView equipoPok1;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT IMAGEN FROM POKEDEX WHERE NUM_POKEDEX = 7";

        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            File fileImageFondo = new File("src/main/resources/es/cesur/progprojectpok/images/blastoise-frente.gif");
            equipoPok1.setImage(new Image(fileImageFondo.getAbsolutePath()));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }

    @FXML
    protected void onHelloButtonClick() {

    }


}