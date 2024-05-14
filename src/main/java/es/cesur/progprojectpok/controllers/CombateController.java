package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import es.cesur.progprojectpok.clases.Entrenador;
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
import java.util.Random;
import java.util.ResourceBundle;

public class CombateController implements Initializable {

    Stage stage = new Stage();
    FXMLLoader fxmlLoader = null;

    private Entrenador entrenadorCombate;

    public Entrenador getEntrenadorCombate() {
        return entrenadorCombate;
    }

    public void setEntrenadorCombate(Entrenador entrenadorCombate) {
        this.entrenadorCombate = entrenadorCombate;
    }

      @FXML
    void btnLuchar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/combate-luchar-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1015, 685);
        stage.setTitle("movimientos-view");
        stage.setScene(scene);
        stage.show();

        Stage stageAnterior = (Stage) cerrarCombatePK.getScene().getWindow();
        stageAnterior.close();

        idPaneMain.setDisable(true);
        idPaneMain.setVisible(false);
        idPaneEquipo.setDisable(false);
        idPaneEquipo.setVisible(true);

    }

    @FXML
    void btnPK(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/combate-equipo-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1015, 685);
        stage.setTitle("pokemons-view");
        stage.setScene(scene);
        CombateEquipoController combateEquipoController = fxmlLoader.getController();
        combateEquipoController.setEntrenadorCombEquipo(entrenadorCombate);
        stage.show();

        Stage stageAnterior = (Stage) cerrarCombatePK.getScene().getWindow();
        stageAnterior.close();
    }

    @FXML
    void btnMochila(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/combate-mochila-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1015, 685);
        stage.setTitle("mochila-view");
        stage.setScene(scene);
        stage.show();

        Stage stageAnterior = (Stage) cerrarCombatePK.getScene().getWindow();
        stageAnterior.close();

        idPaneMain.setDisable(true);
        idPaneMain.setVisible(false);
        idPaneObjetos.setDisable(false);
        idPaneObjetos.setVisible(true);

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

    private String[] imgPok = new String[6];

    private int[] vidaPivote = new int[6];

    private String[] nomPok = new String[6];

    private String ImagenUrlPokemonGenerado = "";

    private String[] NOM_POKEMON = new String[6];

    private String[] TIPO1 = new String[6];
    private String[] TIPO2 = new String[6];
    private int[] VIDA = new int[6];
    private Random random = new Random();
    private int pokemonRandom;
    private Connection connection;

    private String nomPokRandom;
    private int vidaPokRandom;
    private String imgPokRandom;


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
    void btnPokemon(ActionEvent event) throws  IOException {

        System.out.println("id equipo" + entrenadorCombate);

        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM POKEDEX PO INNER JOIN POKEMON P ON PO.NUM_POKEDEX = P.NUM_POKEDEX WHERE CAJA = 0 AND ID_USER = ?;";

        String[] imgPok = new String[6];
        String ImagenUrlPokemonGenerado = "";


        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entrenadorCombate.getIdEntrenador());

            ResultSet resultSet = preparedStatement.executeQuery();



            for (int i = 0; i < imgPok.length; i++) {


                while (resultSet.next()) {

                    int NUM_POKEDEX = resultSet.getInt("NUM_POKEDEX");
                    NOM_POKEMON[i] = resultSet.getString("NOM_POKEMON");
                    TIPO1[i] = resultSet.getString("TIPO1");
                    TIPO2[i] = resultSet.getString("TIPO2");
                    ImagenUrlPokemonGenerado = resultSet.getString("IMAGEN");
                    String SONIDO = resultSet.getString("SONIDO");
                    int NIVEL_EVOLUCION = resultSet.getInt("NIVEL_EVOLUCION");
                    int NUM_POKEDEX_EVO = resultSet.getInt("NUM_POKEDEX_EVO");
                    String SEXO = resultSet.getString("SEXO");
                    VIDA[i] = resultSet.getInt("VITALIDAD");
                    int NIVEL = resultSet.getInt("NIVEL");



                    System.out.println(NUM_POKEDEX + " " + NOM_POKEMON + " " + TIPO1 + " " + TIPO2 + " " +
                            ImagenUrlPokemonGenerado + " " + SONIDO + " " + NIVEL_EVOLUCION + " " + NUM_POKEDEX_EVO + " " + SEXO + " " + VIDA);

                    //Cambio de imagen
                    break;


                }

                imgPok[i] = ConfigDB.URL_POK + ImagenUrlPokemonGenerado;

                System.out.println(imgPok[i]);

                for (int j = 0; j < VIDA.length; j++) {

                    vidaPivote[i] = VIDA[i] ;

                }


                prgrsBar2.setProgress(((double) vidaPivote[0] / 100));




                for (int j = 0; j < NOM_POKEMON.length; j++) {

                    nomPok[i] = NOM_POKEMON[i] ;

                }

                lblNombre2.setText(nomPok[0]);

                 idBtnAtaque1.setText(nomPok[0]);
                 idBtnAtaque1.setText(nomPok[1]);
                 idBtnAtaque1.setText(nomPok[2]);
                 idBtnAtaque1.setText(nomPok[3]);
                 idBtnAtaque1.setText(nomPok[4]);
                 idBtnAtaque1.setText(nomPok[5]);






                System.out.println("La chupa a:" + vidaPivote[0]);
                System.out.println("La chupa a:" + vidaPivote[1]);



            }



            File fileImageFondo1 = new File(imgPok[0]);

          /*  File fileImageFondo2 = new File(imgPok[1]);
            File fileImageFondo3 = new File(imgPok[2]);
            File fileImageFondo4 = new File(imgPok[3]);
            File fileImageFondo5 = new File(imgPok[4]);
            File fileImageFondo6 = new File(imgPok[5]); */


            System.out.println("Posicion 1 = " + imgPok[0]);
            //System.out.println("Posicion 2 = " + imgPok[1]);


            imgPok1.setImage(new Image(fileImageFondo1.getAbsolutePath()));

            /* imgPok2.setImage(new Image(fileImageFondo2.getAbsolutePath()));
            imgPok3.setImage(new Image(fileImageFondo3.getAbsolutePath()));
            imgPok4.setImage(new Image(fileImageFondo4.getAbsolutePath()));
            imgPok5.setImage(new Image(fileImageFondo5.getAbsolutePath()));
            imgPok6.setImage(new Image(fileImageFondo6.getAbsolutePath())); */





        } catch(SQLException e){
            throw new RuntimeException(e);
        }


    }

    @FXML
    private AnchorPane cerrarCombatePK;

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
    private Label lblComb1;

    @FXML
    private ImageView Pok6;

    @FXML
    private ImageView Pok4;

    @FXML
    private ImageView Pok5;

    @FXML
    private ImageView imgPok1;

    @FXML
    private ImageView imgPok2;

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
    private Button idBtnAtaque1;

    @FXML
    private Button idBtnAtaque2;

    @FXML
    private Button idBtnAtaque3;

    @FXML
    private Button idBtnAtaque4;

    @FXML
    private Button idBtnEquipo1;

    @FXML
    private Button idBtnEquipo2;

    @FXML
    private Button idBtnEquipo3;

    @FXML
    private Button idBtnEquipo4;

    @FXML
    private Button idBtnEquipo5;

    @FXML
    private Button idBtnEquipo6;

    @FXML
    private Button idBtnObjeto1;

    @FXML
    private Button idBtnObjeto2;

    @FXML
    private Button idBtnObjeto3;

    @FXML
    private Button idBtnObjeto4;

    @FXML
    private Button idBtnObjeto5;

    @FXML
    private Button idBtnObjeto6;

    @FXML
    private Button idBtnObjeto7;

    @FXML
    private AnchorPane idPaneAtaques;

    @FXML
    private AnchorPane idPaneEquipo;

    @FXML
    private AnchorPane idPaneObjetos;

    @FXML
    private AnchorPane idPaneMain;

    @FXML
    private ImageView imgEquipoPok1Tipo1;

    @FXML
    private ImageView imgEquipoPok1Tipo2;

    @FXML
    private ImageView imgEquipoPok2Tipo1;

    @FXML
    private ImageView imgEquipoPok2Tipo2;

    @FXML
    private ImageView imgEquipoPok3Tipo1;

    @FXML
    private ImageView imgEquipoPok3Tipo2;

    @FXML
    private ImageView imgEquipoPok4Tipo1;

    @FXML
    private ImageView imgEquipoPok5Tipo1;

    @FXML
    private ImageView imgEquipoPok6Tipo1;

    @FXML
    private ImageView imgEquipoPok6Tipo2;

    @FXML
    private ImageView imgObj1;

    @FXML
    private ImageView imgObj2;

    @FXML
    private ImageView imgObj3;

    @FXML
    private ImageView imgObj4;

    @FXML
    private ImageView imgObj5;

    @FXML
    private ImageView imgObj6;

    @FXML
    private ImageView imgObj7;

    @FXML
    private ImageView imgTipoMov1;

    @FXML
    private ImageView imgTipoMov2;

    @FXML
    private ImageView imgTipoMov3;

    @FXML
    private ImageView imgTipoMov4;

    @FXML
    private Label lblPPAtaque1;

    @FXML
    private Label lblPPAtaque2;

    @FXML
    private Label lblPPAtaque3;

    @FXML
    private Label lblPPAtaque4;

    @FXML
    private Label logAtaques;

    @FXML
    private Label logCombateMain;

    @FXML
    private Label logEquipo;

    @FXML
    private Label logObjetos;

    @FXML
    void btnAtaque1(ActionEvent event) {

    }

    @FXML
    void btnAtaque2(ActionEvent event) {

    }

    @FXML
    void btnAtaque3(ActionEvent event) {

    }

    @FXML
    void btnAtaque4(ActionEvent event) {

    }

    @FXML
    void btnEquipoPok1(ActionEvent event) {

    }

    @FXML
    void btnEquipoPok2(ActionEvent event) {

    }

    @FXML
    void btnEquipoPok3(ActionEvent event) {

    }

    @FXML
    void btnEquipoPok4(ActionEvent event) {

    }

    @FXML
    void btnEquipoPok5(ActionEvent event) {

    }

    @FXML
    void btnEquipoPok6(ActionEvent event) {

    }

    @FXML
    void btnObjeto1(ActionEvent event) {

    }

    @FXML
    void btnObjeto2(ActionEvent event) {

    }

    @FXML
    void btnObjeto3(ActionEvent event) {

    }

    @FXML
    void btnObjeto4(ActionEvent event) {

    }

    @FXML
    void btnObjeto5(ActionEvent event) {

    }

    @FXML
    void btnObjeto6(ActionEvent event) {

    }

    @FXML
    void btnObjeto7(ActionEvent event) {

    }

    @FXML
    void disableAtaques(ActionEvent event) {

    }

    @FXML
    void disableEquipo(ActionEvent event) {

    }

    @FXML
    void disableObjetos(ActionEvent event) {

    }


}