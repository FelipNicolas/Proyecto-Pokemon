package es.cesur.progprojectpok.controllers;

import es.cesur.progprojectpok.ImageData;
import es.cesur.progprojectpok.clases.Entrenador;
import es.cesur.progprojectpok.database.ConfigDB;
import es.cesur.progprojectpok.database.DBConnection;
import es.cesur.progprojectpok.utils.Utils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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

   private Entrenador entrenadorEquipo;

    public Entrenador getEntrenadorEquipo() {
        return entrenadorEquipo;
    }

    public void setEntrenadorEquipo(Entrenador entrenadorEquipo) {
        this.entrenadorEquipo = entrenadorEquipo;
    }

    String[] imgPok = new String[6];

    String ImagenUrlPokemonGenerado = "";

    String[] nomPokemon = new String[6];

    String[] tipo1 = new String[6];
    String[] tipo2 = new String[6];


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        }

    @FXML
    void cargarEquipo(ActionEvent a) {

        System.out.println("id equipo" + entrenadorEquipo);

        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM POKEDEX PO INNER JOIN POKEMON P ON PO.NUM_POKEDEX = P.NUM_POKEDEX WHERE CAJA = 0 AND ID_USER = ?;";

        String[] imgPok = new String[6];
        String ImagenUrlPokemonGenerado = "";


        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entrenadorEquipo.getIdEntrenador());

            ResultSet resultSet = preparedStatement.executeQuery();

            for (int i = 0; i < imgPok.length; i++) {


                while (resultSet.next()) {

                    int NUM_POKEDEX = resultSet.getInt("NUM_POKEDEX");
                    nomPokemon[i] = resultSet.getString("NOM_POKEMON");
                    tipo1[i] = resultSet.getString("TIPO1");
                    tipo2[i] = resultSet.getString("TIPO2");
                    ImagenUrlPokemonGenerado = resultSet.getString("IMAGEN");
                    String SONIDO = resultSet.getString("SONIDO");
                    int NIVEL_EVOLUCION = resultSet.getInt("NIVEL_EVOLUCION");
                    int NUM_POKEDEX_EVO = resultSet.getInt("NUM_POKEDEX_EVO");
                    String SEXO = resultSet.getString("SEXO");
                    int VIDA = resultSet.getInt("VITALIDAD");
                    int NIVEL = resultSet.getInt("NIVEL");



                    System.out.println(NUM_POKEDEX + " " + nomPokemon + " " + tipo1 + " " + tipo2 + " " +
                            ImagenUrlPokemonGenerado + " " + SONIDO + " " + NIVEL_EVOLUCION + " " + NUM_POKEDEX_EVO + " " + SEXO);

                    //Cambio de imagen
                    break;

                }

                imgPok[i] = ConfigDB.URL_POK + ImagenUrlPokemonGenerado;

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


            resultSet.close();
            preparedStatement.close();
            connection.close();


        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void clickPok1(MouseEvent event) {

        File fileImgPok1 = new File(img1.getImage().getUrl());
        imgFinal.setImage(new Image(fileImgPok1.getAbsolutePath()));
        lblNomPok.setText(nomPokemon[0]);
    }

    @FXML
    void clickPok2(MouseEvent event) {

        File fileImgPok2 = new File(img2.getImage().getUrl());
        imgFinal.setImage(new Image(fileImgPok2.getAbsolutePath()));
        lblNomPok.setText(nomPokemon[1]);

    }

    @FXML
    void clickPok3(ActionEvent event) {

        File fileImgPok3 = new File(img2.getImage().getUrl());
        imgFinal.setImage(new Image(fileImgPok3.getAbsolutePath()));
        lblNomPok.setText(nomPokemon[2]);

    }

    @FXML
    void clickPok4(ActionEvent event) {

        File fileImgPok4 = new File(img2.getImage().getUrl());
        imgFinal.setImage(new Image(fileImgPok4.getAbsolutePath()));
        lblNomPok.setText(nomPokemon[3]);

    }

    @FXML
    void clickPok5(ActionEvent event) {

        File fileImgPok5 = new File(img2.getImage().getUrl());
        imgFinal.setImage(new Image(fileImgPok5.getAbsolutePath()));
        lblNomPok.setText(nomPokemon[4]);

    }

    @FXML
    void clickPok6(ActionEvent event) {

        File fileImgPok6 = new File(img2.getImage().getUrl());
        imgFinal.setImage(new Image(fileImgPok6.getAbsolutePath()));
        lblNomPok.setText(nomPokemon[5]);

    }




    }
