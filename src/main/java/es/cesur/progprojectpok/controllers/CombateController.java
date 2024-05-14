package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import es.cesur.progprojectpok.clases.Entrenador;
import es.cesur.progprojectpok.clases.Pokemon;
import es.cesur.progprojectpok.clases.Tipos;
import es.cesur.progprojectpok.database.ConfigDB;
import es.cesur.progprojectpok.database.DBConnection;
import es.cesur.progprojectpok.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

public class CombateController implements Initializable {


    @FXML
    private ImageView Gender1;

    @FXML
    private ImageView Pok2;

    @FXML
    private ImageView Pok3;

    @FXML
    private ImageView Gender2;

    @FXML
    private ImageView Pok1;

    @FXML
    private ImageView imgPok1;

    @FXML
    private ImageView imgPok2;

    @FXML
    private Label lblComb1;

    @FXML
    private ImageView Pok6;

    @FXML
    private ImageView Pok4;

    @FXML
    private ImageView Pok5;

    @FXML
    private Label lblNvl1;

    @FXML
    private ProgressBar prgrsBar1;

    @FXML
    private ProgressBar prgrsBar2;

    @FXML
    private Label lblNvl2;

    @FXML
    private Label lblNombre2;

    @FXML
    private Label lblNombre1;

    @FXML
    private AnchorPane cerrarCombatePK;

    Entrenador entrenadorCombate;

    Stage stage;




    private String imagenUrlPokemonGenerado = "";

    private String[] nomPokemon = new String[6];

    private String[] tipo1 = new String[6];
    private String[] tipo2 = new String[6];

    private int[] VIDA = new int[6];
    private Random random = new Random();
    private int pokemonRandom;
    private Connection connection;





    public Entrenador getEntrenadorCombate() {
        return entrenadorCombate;
    }

    public void setEntrenadorCombate(Entrenador entrenadorCombate) {
        this.entrenadorCombate = entrenadorCombate;
    }


    @FXML
    void btnLuchar(ActionEvent event) {


    }

    @FXML
    void btnPK(ActionEvent event) {

    }

    @FXML
    void btnMochila(ActionEvent event) {

    }

    @FXML
    void btnHuir(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view-lucha.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("boton-huir-view");
        stage.setScene(scene);
        MenuLuchaController menuLuchaController = fxmlLoader.getController();
        menuLuchaController.setEntrenadorMenuLucha(entrenadorCombate);
        stage.show();

        Stage stageAnterior = (Stage) cerrarCombatePK.getScene().getWindow();
        stageAnterior.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pokemonRandom = random.nextInt(25);

        connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM POKEDEX WHERE NUM_POKEDEX = ?;";

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

            imgPok2.setImage(new Image(rutaAbsolutaImgPok.getAbsolutePath()));

            prgrsBar1.setProgress(1);

            lblNombre1.setText(nomPokemon);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnPokemon(ActionEvent event)  {

        System.out.println("id equipo" + entrenadorCombate);

        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM POKEDEX PO INNER JOIN POKEMON P ON PO.NUM_POKEDEX = P.NUM_POKEDEX WHERE CAJA = 0 AND ID_USER = ?;";

        String[] imgPok = new String[6];


        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entrenadorCombate.getIdEntrenador());

            ResultSet resultSet = preparedStatement.executeQuery();


            for (int i = 0; i < imgPok.length; i++) {


                while (resultSet.next()) {

                    int NUM_POKEDEX = resultSet.getInt("NUM_POKEDEX");
                    nomPokemon[i] = resultSet.getString("NOM_POKEMON");
                    tipo1[i] = resultSet.getString("TIPO1");
                    tipo2[i] = resultSet.getString("TIPO2");
                    imagenUrlPokemonGenerado = resultSet.getString("IMAGEN");
                    String SONIDO = resultSet.getString("SONIDO");
                    int NIVEL_EVOLUCION = resultSet.getInt("NIVEL_EVOLUCION");
                    int NUM_POKEDEX_EVO = resultSet.getInt("NUM_POKEDEX_EVO");
                    String SEXO = resultSet.getString("SEXO");
                    VIDA[i] = resultSet.getInt("VITALIDAD");
                    int NIVEL = resultSet.getInt("NIVEL");




                    //System.out.println(NUM_POKEDEX + " " + NOM_POKEMON + " " + TIPO1 + " " + TIPO2 + " " +
                    //       ImagenUrlPokemonGenerado + " " + SONIDO + " " + NIVEL_EVOLUCION + " " + NUM_POKEDEX_EVO + " " + SEXO + " " + VIDA);


                    break;

                }

            }
        } catch (SQLException s){
            System.out.println("Error SQL");
        }

    }





    public static void main(String[] args) {

        CombateController prueba = new CombateController();

            //prueba.cargarEquipoContrario();


    }


}
