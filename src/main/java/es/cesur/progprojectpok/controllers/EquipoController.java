package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.HelloApplication;
import es.cesur.progprojectpok.ImageData;
import es.cesur.progprojectpok.clases.Entrenador;
import es.cesur.progprojectpok.database.ConfigDB;
import es.cesur.progprojectpok.database.DBConnection;
import es.cesur.progprojectpok.utils.Utils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EquipoController implements Initializable {

    Stage stage = new Stage();
    FXMLLoader fxmlLoader = null;

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


    @FXML
    private ImageView imgtipo2;

    @FXML
    private Label lblNivel;

    @FXML
    private ImageView imgObj;

    @FXML
    private ImageView imgTipo1;

    @FXML
    private Label lblNomPok;

    @FXML
    private TextArea txtDescrip;

    @FXML
    private ImageView imgGen;

    @FXML
    private ProgressBar barVida;

    @FXML
    private Label idEntrenador;

    @FXML
    private Label cerrarEquipo;
    @FXML
    private Label lblTipo1;
    @FXML
    private Label lblTipo2;




    private Entrenador entrenadorEquipo;

    public Entrenador getEntrenadorEquipo() {
        return entrenadorEquipo;
    }

    public void setEntrenadorEquipo(Entrenador entrenadorEquipo) {
        this.entrenadorEquipo = entrenadorEquipo;
    }

    private String[] imgPok = new String[6];

    private String[] imagenUrlPokemonGenerado = new String[6];

    private String[] nomPokemon = new String[6];

    private String[] tipo1 = new String[6];

    private String[] tipo2 = new String[6];
    private  String[] sexo = new String[6];
    private int[] vida = new int[6];
    private int[] nivel = new int[6];
    private int[] numPokedex = new int[6];
    ResultSet resultSet;



    @Override
    public void initialize(URL location, ResourceBundle resources) {


        }

    @FXML
    void cargarEquipo(ActionEvent a) {


        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM POKEDEX PO INNER JOIN POKEMON P ON PO.NUM_POKEDEX = P.NUM_POKEDEX WHERE CAJA = 0 AND ID_USER = ?;";


        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entrenadorEquipo.getIdEntrenador());

            resultSet = preparedStatement.executeQuery();

               for (int i = 0; i < imgPok.length; i++) {


                while (resultSet.next()) {

                    numPokedex[i] = resultSet.getInt("NUM_POKEDEX");
                    nomPokemon[i] = resultSet.getString("NOM_POKEMON");
                    tipo1[i] = resultSet.getString("TIPO1");
                    tipo2[i] = resultSet.getString("TIPO2");
                    imagenUrlPokemonGenerado[i] = resultSet.getString("IMAGEN");
                    sexo[i] = resultSet.getString("SEXO");
                    vida[i] = resultSet.getInt("VITALIDAD");
                    nivel[i] = resultSet.getInt("NIVEL");

                    //Cambio de imagen
                    break;


                }

                imgPok[i] = ConfigDB.URL_POK + imagenUrlPokemonGenerado[i];

                System.out.println(imgPok[i]);


            }

            File fileImageFondo1 = new File(imgPok[0]);
            File fileImageFondo2 = new File(imgPok[1]);
            File fileImageFondo3 = new File(imgPok[2]);
            File fileImageFondo4 = new File(imgPok[3]);
            File fileImageFondo5 = new File(imgPok[4]);
            File fileImageFondo6 = new File(imgPok[5]);


            System.out.println("Posicion 1 = " + imgPok[0]);
            System.out.println("Posicion 2 = " + imgPok[1]);


            img1.setImage(new Image(fileImageFondo1.getAbsolutePath()));
            img2.setImage(new Image(fileImageFondo2.getAbsolutePath()));
            img3.setImage(new Image(fileImageFondo3.getAbsolutePath()));
            img4.setImage(new Image(fileImageFondo4.getAbsolutePath()));
            img5.setImage(new Image(fileImageFondo5.getAbsolutePath()));
            img6.setImage(new Image(fileImageFondo6.getAbsolutePath()));


        } catch(SQLException e){
            throw new RuntimeException(e);
        }


    }

    @FXML
    void btnBACK(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view-centropk.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 715, 700);
        stage.setTitle("boton-vuelta-view");
        stage.setScene(scene);
        MenuCentroPKController menuCentroPKController = fxmlLoader.getController();
        menuCentroPKController.setEntrenadorMenu(entrenadorEquipo);
        stage.show();

        Stage stageAnterior = (Stage) cerrarEquipo.getScene().getWindow();
        stageAnterior.close();
    }
    File fileImgPok1;
    File fileImgPokGenero;




    @FXML
    void clickPok1(MouseEvent event) {

        fileImgPok1 = new File(img1.getImage().getUrl());
            System.out.println("ruta: " + fileImgPok1);
        imgFinal.setImage(new Image(fileImgPok1.getAbsolutePath()));

        lblNomPok.setText(nomPokemon[0]);
        barVida.setProgress(vida[0]);
        lblNivel.setText("Nv" + nivel[0]);
        lblTipo1.setText(tipo1[0]);
        lblTipo2.setText(tipo2[0]);



    }

    @FXML
    void clickPok2(MouseEvent event) {

        File fileImgPok2 = new File(img2.getImage().getUrl());
        imgFinal.setImage(new Image(fileImgPok2.getAbsolutePath()));
        lblNomPok.setText(nomPokemon[1]);
        lblNivel.setText("Nv" + nivel[1]);
        lblTipo1.setText(tipo1[1]);
        lblTipo2.setText(tipo2[1]);

    }

    @FXML
    void clickPok3(MouseEvent event) {

        File fileImgPok3 = new File(img3.getImage().getUrl());
        imgFinal.setImage(new Image(fileImgPok3.getAbsolutePath()));
        lblNomPok.setText(nomPokemon[2]);
        lblNivel.setText("Nv" + nivel[2]);
        lblTipo1.setText(tipo1[2]);
        lblTipo2.setText(tipo2[2]);

    }

    @FXML
    void clickPok4(MouseEvent event) {

        File fileImgPok4 = new File(img4.getImage().getUrl());
        imgFinal.setImage(new Image(fileImgPok4.getAbsolutePath()));
        lblNomPok.setText(nomPokemon[3]);
        lblNivel.setText("Nv" + nivel[3]);
        lblTipo1.setText(tipo1[3]);
        lblTipo2.setText(tipo2[3]);

    }

    @FXML
    void clickPok5(MouseEvent event) {

        File fileImgPok4 = new File(img4.getImage().getUrl());
        imgFinal.setImage(new Image(fileImgPok4.getAbsolutePath()));
        lblNomPok.setText(nomPokemon[4]);
        lblNivel.setText("Nv" + nivel[4]);
        lblTipo1.setText(tipo1[4]);
        lblTipo2.setText(tipo2[4]);
    }

    @FXML
    void clickPok6(MouseEvent event) {

        File fileImgPok5 = new File(img5.getImage().getUrl());
        imgFinal.setImage(new Image(fileImgPok5.getAbsolutePath()));
        lblNomPok.setText(nomPokemon[5]);
        lblNivel.setText("Nv" + nivel[5]);
        lblTipo1.setText(tipo1[5]);
        lblTipo2.setText(tipo2[5]);

    }




    }
