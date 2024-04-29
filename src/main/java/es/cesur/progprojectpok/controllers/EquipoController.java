package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.ImageData;
import es.cesur.progprojectpok.database.ConfigDB;
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
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img4;

    @FXML
    private ImageView img5;

    @FXML
    private ImageView img6;

    @FXML
    private ImageView imgFinal;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM POKEDEX PO INNER JOIN POKEMON P ON PO.NUM_POKEDEX = P.NUM_POKEDEX WHERE CAJA = 0";


        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            String[] imgPok = new String[5];

            String ImagenUrlPokemonGenerado = "";


            for (int i = 0; i < imgPok.length; i++) {


                while (resultSet.next()) {
                    int NUM_POKEDEX = resultSet.getInt("NUM_POKEDEX");
                    String NOM_POKEMON = resultSet.getString("NOM_POKEMON");
                    String TIPO1 = resultSet.getString("TIPO1");
                    String TIPO2 = resultSet.getString("TIPO2");
                    ImagenUrlPokemonGenerado = resultSet.getString("IMAGEN");
                    String SONIDO = resultSet.getString("SONIDO");
                    int NIVEL_EVOLUCION = resultSet.getInt("NIVEL_EVOLUCION");
                    int NUM_POKEDEX_EVO = resultSet.getInt("NUM_POKEDEX_EVO");

                    //System.out.println(NUM_POKEDEX + " " + NOM_POKEMON + " " + TIPO1 + " " + TIPO2 + " " +
                     //       ImagenUrlPokemonGenerado + " " + SONIDO + " " + NIVEL_EVOLUCION + " " + NUM_POKEDEX_EVO);

                    //Cambio de imagen
                    break;

                }

                imgPok[i] = ConfigDB.URL_POK + ImagenUrlPokemonGenerado;

                System.out.println(imgPok[i].toString());

            }

            File fileImageFondo1 = new File(imgPok[0]);

            System.out.println("Posicion 1 = " + imgPok[0]);
            System.out.println("Posicion 2 = " + imgPok[1]);

            File fileImageFondo2 = new File(imgPok[1]);

            img1.setImage(new Image(fileImageFondo1.getAbsolutePath()));
            img2.setImage(new Image(fileImageFondo2.getAbsolutePath()));


            } catch(SQLException e){
                throw new RuntimeException(e);
            }


        }
    }
