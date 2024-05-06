package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.ImageData;
import es.cesur.progprojectpok.clases.Entrenador;
import es.cesur.progprojectpok.database.ConfigDB;
import es.cesur.progprojectpok.database.DBConnection;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

public class CapturaController implements Initializable {


    @FXML
    private Label lblComb1;

    @FXML
    private ImageView pokCap;

    Entrenador entrenadorCaptura;

    public Entrenador getEntrenadorCaptura() {
        return entrenadorCaptura;
    }

    public void setEntrenadorCaptura(Entrenador entrenadorCaptura) {
        this.entrenadorCaptura = entrenadorCaptura;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {




            }


    @FXML
    void btnCapturar(ActionEvent event) {

        Random random = new Random();
        int pokemonRandom = random.nextInt(10);

        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM POKEDEX WHERE NUM_POKEDEX = ?;";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, pokemonRandom);

            System.out.println("sentencia" + sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

           // String nomPokemon = resultSet.getString("NOM_POKEMON");
            String imgPokemon = resultSet.getString("IMAGEN");

            String rutaImgPokemon = ConfigDB.URL_POK + imgPokemon;

            File rutaAbsolutaImgPok = new File(rutaImgPokemon);
            System.out.println("ruta absoluta" + rutaAbsolutaImgPok);


            pokCap.setImage(new Image(rutaAbsolutaImgPok.getAbsolutePath()));



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void btnHuir(ActionEvent event) {

    }









}