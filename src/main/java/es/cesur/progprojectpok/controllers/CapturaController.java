package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import es.cesur.progprojectpok.ImageData;
import es.cesur.progprojectpok.clases.Entrenador;
import es.cesur.progprojectpok.clases.Pokemon;
import es.cesur.progprojectpok.database.ConfigDB;
import es.cesur.progprojectpok.database.DBConnection;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

public class CapturaController implements Initializable {

    @FXML
    private ImageView imgEntrenador;

    @FXML
    private Button btnNo;

    @FXML
    private Button btnSi;

    @FXML
    private ImageView cerrarCaptura;

    @FXML
    private AnchorPane menuMote;


    @FXML
    private TextField txtMote;

    @FXML
    private TextField txtPreguntaMote;


    @FXML
    private Label lblCaptura;

    @FXML
    private ImageView pokCap;

    Entrenador entrenadorCaptura;

    Random random = new Random();

    private int pokemonRandom;

    private Connection connection;

    Stage stage = new Stage();





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
    void btnGenerarPok(ActionEvent event) {

        pokemonRandom = random.nextInt(10);

        connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM POKEDEX WHERE NUM_POKEDEX = ?;";

        //String sqlPokRandom = "SELECT * FROM POKEDEX ORDER BY RAND() LIMIT 1;";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, pokemonRandom);

            System.out.println("sentencia" + sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            String nomPokemon = resultSet.getString("NOM_POKEMON");
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
    void btnCapturar(ActionEvent event) {

            int probCaptura = random.nextInt(1,4);

            System.out.println(probCaptura);

            if (probCaptura == 1 || probCaptura == 2) {

                Pokemon pokemonCap = new Pokemon();

                int[] statsAlmacenadas = new int[5];

                for (int i = 0; i < statsAlmacenadas.length; i++) {

                    int statsPok = random.nextInt(1,11);

                    statsAlmacenadas[i] = statsPok;

                    System.out.println("Stat = " + statsAlmacenadas[i]);
                }

                pokemonCap.setPtsAtaque(statsAlmacenadas[0]);
                pokemonCap.setPtsAtaqueEsp(statsAlmacenadas[1]);
                pokemonCap.setPtsDefensa(statsAlmacenadas[2]);
                pokemonCap.setPtsDefensaEsp(statsAlmacenadas[3]);
                pokemonCap.setVelocidadPok(statsAlmacenadas[4]);


                String sqlCapturaPok = "INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO) VALUES (?, ?, NULL, 1, ?, ?, ?, ?, ?, 1, 5, 'M', 'Saludable', 0, 100, NULL)";

                lblCaptura.setText("La captura fue un éxito");

                PreparedStatement statementInsertPok = null;

                try {
                    statementInsertPok = connection.prepareStatement(sqlCapturaPok);


                statementInsertPok.setInt(1, entrenadorCaptura.getIdEntrenador());
                statementInsertPok.setInt(2, pokemonRandom);
                statementInsertPok.setInt(3, pokemonCap.getPtsAtaque());
                statementInsertPok.setInt(4, pokemonCap.getPtsAtaqueEsp());
                statementInsertPok.setInt(5, pokemonCap.getPtsDefensa());
                statementInsertPok.setInt(6, pokemonCap.getPtsDefensaEsp());
                statementInsertPok.setInt(7, pokemonCap.getVelocidadPok());

                statementInsertPok.executeUpdate();


                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }





            }else lblCaptura.setText("La captura fallo ");


    }

    @FXML
    void btnHuir(ActionEvent event) throws IOException {

        vueltaMenuLucha();
    }

    private void vueltaMenuLucha() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view-lucha.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("boton-huir-view");
        stage.setScene(scene);
        MenuLuchaController menuLuchaController = fxmlLoader.getController();
        menuLuchaController.setEntrenadorMenuLucha(entrenadorCaptura);
        stage.show();

        Stage stageAnterior = (Stage) cerrarCaptura.getScene().getWindow();
        stageAnterior.close();
    }




    }

















